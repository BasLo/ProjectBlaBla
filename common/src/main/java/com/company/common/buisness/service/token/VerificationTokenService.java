package com.company.common.buisness.service.token;

import com.company.domain.entity.VerificationToken;
import com.company.domain.entity.user.User;

public interface VerificationTokenService {

    VerificationToken getVerificationToken(String verificationToken);
    VerificationToken createVerificationToken(User user, String token);

}
