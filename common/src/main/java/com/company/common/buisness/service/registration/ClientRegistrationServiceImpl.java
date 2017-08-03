package com.company.common.buisness.service.registration;

import com.company.common.dto.web.ClientDto;
import com.company.domain.entity.role.Role;
import com.company.domain.entity.user.User;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Create clients from main registration form or other social networks.
 */
@Service
public class ClientRegistrationServiceImpl
    extends AbstractClientRegistrationService{

    //TODO: test method;
    @Override
    public User addUserByRegistrationForm(ClientDto clientDto) {
        User user = new User();
        user.setEmailAddress(clientDto.getEmail());
        user.setUsername(clientDto.getUsername());
        user.setCreationOn(new Date());
        user.setLocked(false);
        user.setEnabled(true);
        user.setRole(Role.createUserRole(user));
        user.setUpdatedOn(new Date());
        user.setPassword("awda");
        return userService.addUser(user);
    }

}