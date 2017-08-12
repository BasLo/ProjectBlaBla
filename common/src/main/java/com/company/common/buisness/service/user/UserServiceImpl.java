package com.company.common.buisness.service.user;

import com.company.db.repository.user.UserRepository;
import com.company.domain.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl
        implements UserService {

    private UserRepository userRepository;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public User addUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Autowired
    public void setUserRepository(@Qualifier("userRepositoryImpl") UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}