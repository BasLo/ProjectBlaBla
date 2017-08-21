package com.company.db.repository;

import com.company.domain.entity.VerificationToken;
import com.company.domain.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokenRepository
        extends JpaRepository<VerificationToken, Long>{

    VerificationToken findByToken(String token);

    VerificationToken findByUser(User user);
}
