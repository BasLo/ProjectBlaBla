package com.company.db.repository.user;

import com.company.domain.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class UserRepositoryImpl
        extends SimpleJpaRepository<User, Long>
        implements UserRepository {

    @Autowired
    public UserRepositoryImpl(@Qualifier("userClass") Class<User> domainClass, EntityManager em) {
        super(domainClass, em);
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

}