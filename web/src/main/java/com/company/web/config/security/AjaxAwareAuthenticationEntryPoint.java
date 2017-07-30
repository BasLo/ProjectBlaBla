package com.company.web.config.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AjaxAwareAuthenticationEntryPoint
        extends LoginUrlAuthenticationEntryPoint {

    public AjaxAwareAuthenticationEntryPoint() {
        super("/");
    }

    public AjaxAwareAuthenticationEntryPoint(String loginFormUrl) {
        super(loginFormUrl);
    }

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {

        boolean isAjax = request.getRequestURI().contains("/api/");
        if (isAjax) {
            response.sendError(403, "Forbidden");
        } else {
            super.commence(request, response, authException);
        }
    }
}
