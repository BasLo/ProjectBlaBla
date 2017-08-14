package com.company.common.buisness.service.registration;

import com.company.common.dto.web.UserDto;
import com.company.domain.entity.user.User;
import org.springframework.validation.BindingResult;

public interface ClientRegistrationService {

     User addUserByRegistrationForm(UserDto userDto, BindingResult bindingResult);
}
