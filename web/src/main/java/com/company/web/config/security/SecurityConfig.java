package com.company.web.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig
        extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private SimpleUrlAuthenticationSuccessHandler loginSuccessHandler;

    @Autowired
    private SimpleUrlAuthenticationFailureHandler loginFailureHandler;

    @Autowired
    private AjaxAwareAuthenticationEntryPoint ajaxAwareAuthenticationEntryPoint;

    @Autowired
    private AjaxLogoutSuccessHandler ajaxLogoutSuccessHandler;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .antMatchers("/authentication/**").hasRole("USER")
                .and()
                .formLogin()
                .loginProcessingUrl("/authentication")
                .loginPage("/login")
                .usernameParameter("j_username").passwordParameter("j_password").permitAll()
                .successHandler(loginSuccessHandler)
                .failureHandler(loginFailureHandler).permitAll().and()
                .logout().logoutUrl("/logout")
                .logoutSuccessHandler(ajaxLogoutSuccessHandler)
                .deleteCookies("JSESSIONID").permitAll().and()
                .authorizeRequests().antMatchers("/user").authenticated()
                .antMatchers("/resources*//**//**").permitAll()
                .antMatchers("/ws").permitAll().antMatchers("/api*//**//**")
                .authenticated().and().exceptionHandling()
                .authenticationEntryPoint(ajaxAwareAuthenticationEntryPoint);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}