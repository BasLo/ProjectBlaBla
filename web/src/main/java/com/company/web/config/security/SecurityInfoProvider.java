package com.company.web.config.security;

import com.company.domain.entity.user.User;

public interface SecurityInfoProvider {
    /**
     * Method to Get Current MainUser
     *
     * @return MainUser
     */
    User getCurrentUser();

    /**
     * Method to get Authenticate MainUser
     *
     * @param user
     */
    void AuthenticateUser(User user);

    /**
     * Method to is CurrentUser
     *
     * @param user
     * @return boolean
     */
    boolean isCurrentUser(User user);
}
