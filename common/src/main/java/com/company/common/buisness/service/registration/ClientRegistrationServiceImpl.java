package com.company.common.buisness.service.registration;

import com.company.common.dto.web.UserDto;
import com.company.common.events.registration.RegistrationCompleteEvent;
import com.company.common.events.registration.RegistrationEventInfo;
import com.company.common.events.registration.WebRegistrationEventData;
import com.company.common.exceptions.validate.EmailExistsException;
import com.company.common.exceptions.validate.UsernameExistsException;
import com.company.domain.entity.VerificationToken;
import com.company.domain.entity.user.User;
import com.sun.istack.internal.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;
import java.util.Locale;

/**
 * Create clients from main registration form, social networks and etc.
 */
@Service
public class ClientRegistrationServiceImpl
    extends AbstractClientRegistrationService{

    @Override
    public User registerUser(User newUserAccount, RegistrationEventInfo regInfo) {
        final User registered = userService.saveUser(newUserAccount);
        if (registered == null){
            //TODO: send error
            return null;
        }

        final RegistrationCompleteEvent registrationEvent = new RegistrationCompleteEvent(registered, regInfo);
        try {
            eventPublisher.publishEvent(registrationEvent);
        }catch (Exception e){
            //TODO: Email send failed
        }
        return registered;
    }

    @Override
    @Nullable
    public User addUserByRegistrationForm(final UserDto userDto, final BindingResult bindingResult, final WebRequest request) { //TODO: BindingResult?
        User registered;
        try {
            registered = createUserBlank(userDto);
        } catch (EmailExistsException | UsernameExistsException e) {
            e.printStackTrace(); //TODO fix it!
            return null;
        }
        final RegistrationEventInfo regInfo = new WebRegistrationEventData(request);
        return registerUser(registered, regInfo);
    }

    @Override
    public String processEmailRegistrationConfirm(final String token, final WebRequest request, final ModelAndView model) {
        Locale locale = request.getLocale();

        VerificationToken verificationToken = tokenService.getVerificationToken(token);
        if (verificationToken == null) {
            String message = messageSource.getMessage("auth.message.invalidToken", null, locale);
            model.addObject("message", message);
            return "redirect:/badUser?lang=" + locale.getLanguage();
        }


        Calendar cal = Calendar.getInstance();
        if ((verificationToken.getExpireDate().getTime() - cal.getTime().getTime()) <= 0) {
            String messageValue = messageSource.getMessage("auth.message.expired", null, locale);
            model.addObject("message", messageValue);
            return "redirect:/badUser?lang=" + locale.getLanguage();
        }

        User user = verificationToken.getUser(); //TODO: load user by ver. token
        user.setEnabled(true);
        userService.saveUser(user);
        return "redirect:/login?lang=" + request.getLocale().getLanguage();
    }

}