package com.company.db.repository.user;

import com.company.domain.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository
        extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
