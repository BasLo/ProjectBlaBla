package com.company.common.buisness.service.user;

import com.company.db.repository.user.UserRepository;
import com.company.domain.entity.Privilege;
import com.company.domain.entity.role.Role;
import com.company.domain.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserDetailsServiceImpl
        implements UserDetailsService{

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String emailAddress)
            throws UsernameNotFoundException{
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        try {
            User user = userRepository.findByEmailAddress(emailAddress);
            if (user == null) {
                throw new UsernameNotFoundException(
                        "No user found with username: " + emailAddress);
            }

            return new org.springframework.security.core.userdetails.User(
                    user.getEmailAddress(),
                    user.getPassword().toLowerCase(),
                    user.isEnabled(),
                    accountNonExpired,
                    credentialsNonExpired,
                    accountNonLocked,
                    getAuthorities(user.getRole()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private final Collection<? extends GrantedAuthority> getAuthorities(final Role role) {
        return getGrantedAuthorities(getPrivileges(role));
    }

    private final List<String> getPrivileges(final Role role) {
        final List<String> privileges = new ArrayList<>();
        for (final Privilege item : role.getPrivileges()) {
            privileges.add(item.getName());
        }

        return privileges;
    }

    private final List<GrantedAuthority> getGrantedAuthorities(final List<String> privileges) {
        final List<GrantedAuthority> authorities = new ArrayList<>();
        for (final String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
