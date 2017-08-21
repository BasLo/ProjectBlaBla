package com.company.domain.entity.role;

import com.company.domain.entity.Privilege;
import com.company.domain.entity.parent.AbstractVersionPersistable;
import com.company.domain.entity.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity(name = "role")
public class Role
        extends AbstractVersionPersistable<Long>{

    public static final String AUTHORITY_ADMIN = "AUTHORITY_ADMIN";
    public static final String AUTHORITY_USER = "AUTHORITY_USER";

    private static final long serialVersionUID = 3604069725181454250L;

    @Column(name = "role")
    private Integer role;

    @OneToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    private User user;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "jt_privilege_role",
            joinColumns = @JoinColumn(name = "roleid", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "privilegeid", referencedColumnName = "id"))
    private Collection<Privilege> privileges;

    public Role() {
        super();
    }

    public Role(User user, Roles role) {
        super();

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

    public Collection<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Collection<Privilege> privileges) {
        this.privileges = privileges;
    }
}