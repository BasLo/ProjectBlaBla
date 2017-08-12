package com.company.test.repository.user;

import com.company.db.repository.user.UserRepository;
import com.company.domain.entity.VerificationToken;
import com.company.domain.entity.role.Role;
import com.company.domain.entity.user.User;
import com.company.web.config.context.JpaConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.company.web.config.context.ContextConfiguration.class, JpaConfig.class})
@ActiveProfiles(profiles = "test-profile") //set profile
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD) // start of spring context for each method
public class UserRepositoryTest {

    @Autowired
    @Qualifier("userRepositoryImpl")
    UserRepository userRepository;

    @Test
    public void addUser(){
        User user = createUser();
        userRepository.saveAndFlush(user);
        assertNotNull(user.getId());
    }

    private User createUser(){
        User user = new User();
        user.setEmailAddress("emailadress@email.com");
        user.setUsername("username");
        user.setCreationOn(new Date());
        user.setLocked(false);
        user.setEnabled(true);
        user.setRole(Role.createUserRole(user));
        user.setUpdatedOn(new Date());
        user.setPassword("password");
        user.setVerificationToken(new VerificationToken("token", user));
        return user;
    }
}
