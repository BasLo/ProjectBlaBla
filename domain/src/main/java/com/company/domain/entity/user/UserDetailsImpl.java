package com.company.domain.entity.user;

import com.company.domain.entity.VerificationToken;
import com.company.domain.entity.parent.AbstractVersionPersistable;
import com.company.domain.entity.role.Role;
import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.Cascade;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@MappedSuperclass
public class UserDetailsImpl
        extends AbstractVersionPersistable<Long>
        implements UserDetails, MainUserInformation {

    private static final long serialVersionUID = -2199293542485135937L;

    @NotNull
    @Column(unique = true, name = "username")
    private String username;

    @NotNull
    @Column(unique = true, name = "email_address")
    private String emailAddress;

    @NotNull
    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private boolean enabled = true;

    @Column(name = "locked")
    private boolean locked = true;

    @NotNull
    @Column(name = "creation_on")
    private Date creationOn = new Date();

    @Column(name = "updated_on")
    private Date updatedOn = new Date();

    @Column(name = "last_sign_in")
    private Date lastSignIn;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", nullable = false, foreignKey = @ForeignKey(name = "ROLE_WITH_USER_ID"),
            referencedColumnName = "role_id")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private Role role;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "verification_token_id", nullable = false, foreignKey = @ForeignKey(name = "VERIFICATION_TOKEN_WITH_USER_ID"),
            referencedColumnName = "verification_token_id")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private VerificationToken verificationToken;

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false; //TODO : change logic
    }

    @Override
    public boolean isAccountNonLocked() {
        return false; //TODO : change logic
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false; //TODO : change logic
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getGrantedAuthorities();
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public Date getCreationOn() {
        return creationOn;
    }

    public void setCreationOn(Date creationOn) {
        this.creationOn = creationOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public VerificationToken getVerificationToken() {
        return verificationToken;
    }

    public void setVerificationToken(VerificationToken verificationToken) {
        this.verificationToken = verificationToken;
    }

    @Override
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Date getLastSignIn() {
        return lastSignIn;
    }

    public void setLastSignIn(Date lastSignIn) {
        this.lastSignIn = lastSignIn;
    }

}
