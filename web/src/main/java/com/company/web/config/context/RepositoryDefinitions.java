package com.company.web.config.context;

import com.company.db.repository.user.UserRepository;
import com.company.db.repository.user.UserRepositoryImpl;
import com.company.domain.entity.VerificationToken;
import com.company.domain.entity.user.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class RepositoryDefinitions {

    @Bean
    public UserRepository userRepository(EntityManager entityManager){
        return new UserRepositoryImpl(User.class, entityManager);
    }

    @Bean
    public Class<User> userClass() {
        return User.class;
    }

/*
    @Bean
    public VerificationToken verificationTokenRepository(EntityManager entityManager){
        return new VerificationTokenRepositoryImpl(VerificationToken.class, entityManager);
    }
*/

    @Bean
    public Class<VerificationToken> verificationTokenClass(){
        return VerificationToken.class;
    }

}