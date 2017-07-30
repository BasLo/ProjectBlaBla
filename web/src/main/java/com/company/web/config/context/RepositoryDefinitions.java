package com.company.web.config.context;

import com.company.domain.entity.user.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryDefinitions { //TODO RENAME class

/*    @Bean
    public UserRepository userRepository(EntityManager emf){
        return new UserRepositoryImpl(User.class, emf);
    }*/

    @Bean
    Class<User> userClass() {
        return User.class;
    }
}
