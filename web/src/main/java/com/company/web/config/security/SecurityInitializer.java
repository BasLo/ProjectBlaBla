package com.company.web.config.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

import javax.servlet.ServletContext;

public class SecurityInitializer
        extends AbstractSecurityWebApplicationInitializer {

    @Override
    protected void afterSpringSecurityFilterChain(ServletContext servletContext) {
        super.afterSpringSecurityFilterChain(servletContext);
    }
}
