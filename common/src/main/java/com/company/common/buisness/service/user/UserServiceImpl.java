package com.company.common.buisness.service.user;

import com.company.db.repository.user.UserRepository;
import com.company.domain.entity.user.User;
import com.sun.istack.internal.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl
        implements UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private UserRepository userRepository;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    @Nullable
    public User saveUser(User user) {
        User registered ;
        try{
            registered = userRepository.save(user);
        } catch (Exception e){
            LOGGER.error("Exception {} \n created User with data: {}", e.getMessage(), user);
            return null;
        }
        return registered;
    }

    @Autowired
    public void setUserRepository(@Qualifier("userRepositoryImpl") UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}