package com.company.web.config.security;

import com.company.db.repository.user.UserRepository;
import com.company.domain.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SecurityInfoProviderImpl
        implements SecurityInfoProvider {

    @Autowired
    UserRepository userRepository;

    private User overridenCurrentUser;

    @Override
    public User getCurrentUser() {
        if (overridenCurrentUser != null) {
            return overridenCurrentUser;
        }
        User user = userRepository.findByUsername(getUsername());
        if (user == null)
            return user; //TODO
        return user;
    }

    private String getUsername() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        if (authentication == null)
            return null;
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        } else {
            return principal.toString();
        }
    }

    @Override
    public void AuthenticateUser(User user) {
        authenticateWithAuthorities(user, user.getRole()
                .getGrantedAuthorities());
    }

    private void authenticateWithAuthorities(User user,
                                             List<GrantedAuthority> authorities) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                user.getUsername(), user.getPassword(), authorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Override
    public boolean isCurrentUser(User user) {
        User currentUser = getCurrentUser();
        return currentUser != null && user.getId().equals(currentUser.getId());
    }
}
