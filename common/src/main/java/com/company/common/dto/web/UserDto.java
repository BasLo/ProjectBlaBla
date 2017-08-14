package com.company.common.dto.web;

import com.company.common.annotations.validate.EmailValid;
import com.company.common.annotations.validate.PasswordMatches;
import com.company.domain.entity.user.MainUserInformation;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@PasswordMatches
public class UserDto
        implements MainUserInformation {

    @NotNull
    @NotEmpty
    @EmailValid
    private String email;

    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    @Size(min = 1)
    private String matchingPassword;

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getEmailAddress() {
        return this.email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "New user account info. \n Email:" + this.email + ", \n Username: " + this.username;
    }
}