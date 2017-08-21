package com.company.common.buisness.service.token;

import com.company.db.repository.VerificationTokenRepository;
import com.company.domain.entity.VerificationToken;
import com.company.domain.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VerificationTokenServiceImpl
        implements VerificationTokenService {

    private VerificationTokenRepository tokenRepository;

    @Override
    public VerificationToken getVerificationToken(String verificationToken) {
        return tokenRepository.findByToken(verificationToken);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public VerificationToken createVerificationToken(User user, String token) {
        VerificationToken verificationToken = new VerificationToken(token, user);
        return tokenRepository.save(verificationToken);
    }

    @Autowired
    public void setTokenRepository(VerificationTokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }
}
