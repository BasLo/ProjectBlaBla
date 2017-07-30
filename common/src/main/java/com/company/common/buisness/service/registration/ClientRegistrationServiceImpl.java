package com.company.common.buisness.service.registration;

import com.company.common.dto.web.ClientDto;
import com.company.domain.entity.user.User;
import org.springframework.stereotype.Service;

@Service
public class ClientRegistrationServiceImpl
    extends AbstractClientRegistrationService{

    @Override
    public User addUserByRegistrationForm(ClientDto clientDto) {
        User user = new User();
        return userService.addUser(user);
    }

}