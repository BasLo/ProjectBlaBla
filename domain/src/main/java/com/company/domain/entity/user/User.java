package com.company.domain.entity.user;

import com.sun.istack.internal.NotNull;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.Date;

@Entity(name = "user")
@Scope("prototype")
@Component
public class User extends
        UserDetailsImpl {

    private static final long serialVersionUID = 3683990149362108908L;

    @NotNull
    @Column(unique = true, name = "email_address")
    private String emailAddress;

    @Column(name = "last_sign_in")
    private Date lastSignIn;

    @Transient
    private String normalPassword;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getNormalPassword() {
        return normalPassword;
    }

    public void setNormalPassword(String normalPassword) {
        this.normalPassword = normalPassword;
    }

    public Date getLastSignIn() {
        return lastSignIn;
    }

    public void setLastSignIn(Date lastSignIn) {
        this.lastSignIn = lastSignIn;
    }
}