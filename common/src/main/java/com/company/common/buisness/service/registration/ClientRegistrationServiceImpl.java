package com.company.common.buisness.service.registration;

import com.company.common.dto.web.UserDto;
import com.company.common.exceptions.validate.EmailExistsException;
import com.company.common.exceptions.validate.UsernameExistsException;
import com.company.domain.entity.user.User;
import com.sun.istack.internal.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

/**
 * Create clients from main registration form, social networks and etc.
 */
@Service
public class ClientRegistrationServiceImpl
    extends AbstractClientRegistrationService{

    @Override
    @Nullable
    public User addUserByRegistrationForm(final UserDto userDto, final BindingResult bindingResult) {
        User registered;
        try {
            registered = createUserBlank(userDto);
        } catch (EmailExistsException | UsernameExistsException e) {
            e.printStackTrace(); //TODO fix it!
            return null;
        }
        registered = userService.registerNewUserAccount(registered); // TODO fix if user was not saved;
        return registered;
    }

}