package com.company.domain.entity.role;

import com.company.domain.entity.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.Version;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.List;

@Entity(name = "role")
@Scope("prototype")
@Component
public class Role
        extends AbstractPersistable<Long> {
    public static final String AUTHORITY_ADMIN = "AUTHORITY_ADMIN";
    public static final String AUTHORITY_USER = "AUTHORITY_USER";
    private static final long serialVersionUID = 3604069725181454250L;
    @Version
    @Column(name = "version")
    private Long version;

    @OneToOne
    @JsonIgnore
    private User user;

    @Column(name = "role")
    private Integer role;

    public Role() {
        super();
    }

    public Role(User user, Roles role) {
        this.user = user;
        this.role = role.getRoleId();
    }

    public static Role createUserRole(User user) {
        return new Role(user, Roles.USER);
    }

    public static Role createArminRole(User user) {
        return new Role(user, Roles.ADMIN);
    }

    public List<GrantedAuthority> getGrantedAuthorities() {
        if (role.equals(Roles.ADMIN.getRoleId())) {
            return AuthorityUtils.createAuthorityList(AUTHORITY_ADMIN,
                    AUTHORITY_USER);
        }
        if (role.equals(Roles.USER.getRoleId())) {
            return AuthorityUtils.createAuthorityList(AUTHORITY_USER);
        }
        return null;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }


}
