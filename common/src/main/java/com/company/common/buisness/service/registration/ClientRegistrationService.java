package com.company.common.buisness.service.registration;

import com.company.common.dto.web.UserDto;
import com.company.common.events.registration.RegistrationEventInfo;
import com.company.domain.entity.user.User;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

public interface ClientRegistrationService {

     User registerUser(User newUserAccount, RegistrationEventInfo regInfo);
     User addUserByRegistrationForm(UserDto userDto, BindingResult bindingResult, WebRequest request);
     String processEmailRegistrationConfirm(String token, WebRequest request, ModelAndView model);
}
