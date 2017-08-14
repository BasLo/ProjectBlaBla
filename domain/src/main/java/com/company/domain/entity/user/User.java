package com.company.domain.entity.user;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity(name = "user")
@Scope("prototype")
@Component
public class User
        extends UserDetailsImpl {

    private static final long serialVersionUID = 3683990149362108908L;

    @Transient
    private String normalPassword;

    public String getNormalPassword() {
        return normalPassword;
    }

    public void setNormalPassword(String normalPassword) {
        this.normalPassword = normalPassword;
    }
}