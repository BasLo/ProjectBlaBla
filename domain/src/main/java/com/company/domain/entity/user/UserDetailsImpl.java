package com.company.domain.entity.user;

import com.company.domain.entity.role.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import java.util.Collection;
import java.util.Date;

@MappedSuperclass
public class UserDetailsImpl
        extends AbstractPersistable<Long>
        implements UserDetails {

    private static final long serialVersionUID = -2199293542485135937L;

    @Column(unique = true, name = "username")
    private String username;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private boolean enabled = true;

    @Column(name = "locked")
    private boolean locked = true;

    @Column(name = "creation_on")
    private Date creationOn = new Date();

    @Column(name = "updated_on")
    private Date updatedOn = new Date();

    @OneToOne(mappedBy = "user", cascade = {CascadeType.ALL}, orphanRemoval = true)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    @JsonIgnore
    private Role role;

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
}