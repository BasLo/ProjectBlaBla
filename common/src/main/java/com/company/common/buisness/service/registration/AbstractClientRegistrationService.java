package com.company.common.buisness.service.registration;

import com.company.common.buisness.service.user.UserService;
import com.company.common.exceptions.validate.EmailExistsException;
import com.company.common.exceptions.validate.UsernameExistsException;
import com.company.db.repository.user.UserRepository;
import com.company.domain.entity.role.Role;
import com.company.domain.entity.user.MainUserInformation;
import com.company.domain.entity.user.PasswordUtils;
import com.company.domain.entity.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public abstract class AbstractClientRegistrationService
        implements ClientRegistrationService{

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    UserRepository userRepository;

    UserService userService;

    protected User createUserBlank(final MainUserInformation userInformation)
            throws EmailExistsException, UsernameExistsException{
        emailAddressIsExists(userInformation.getEmailAddress());
        usernameIsExists(userInformation.getUsername());
        return fillRegistered(userInformation);
    }

    private User fillRegistered(final MainUserInformation userInformation){
        final User registered = new User();
        registered.setUsername(userInformation.getUsername());
        registered.setEmailAddress(userInformation.getEmailAddress());
        String password = PasswordUtils.getEncryptedPassword(userInformation.getPassword());
        registered.setPassword(password);
        registered.setCreationOn(new Date());
        registered.setRole(Role.createUserRole(registered));
        registered.setEnabled(false);
        return registered;
    }

    private void usernameIsExists(final String username) throws UsernameExistsException{
        if (userRepository.usernameIsExists(username)){
            throw new UsernameExistsException();
        }
    }

    private void emailAddressIsExists(final String emailAddress) throws EmailExistsException{
        if (userRepository.emailIsExists(emailAddress)){
            throw new EmailExistsException();
        }
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}