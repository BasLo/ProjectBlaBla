package com.company.domain.entity.user;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity(name = "user")
public class User
        extends UserDetailsImpl {

    private static final long serialVersionUID = 3683990149362108908L;

    public User(){
        super();
        this.setEnabled(false);
    }

    @Transient
    private String normalPassword;

    public String getNormalPassword() {
        return normalPassword;
    }

    public void setNormalPassword(String normalPassword) {
        this.normalPassword = normalPassword;
    }
}