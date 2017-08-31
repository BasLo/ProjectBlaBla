package com.company.web.config.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class MailSender {

    private Environment environment;

    @Bean
    public JavaMailSender javaMailSender(){
        final JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setDefaultEncoding("UTF-8");
        mailSender.setHost(environment.getProperty("spring.mail.host"));
        mailSender.setPort(environment.getProperty("spring.mail.port", Integer.class, 25));
        mailSender.setUsername(environment.getProperty("spring.mail.username"));
        mailSender.setPassword(environment.getProperty("spring.mail.password"));

        final Properties properties = new Properties();
        properties.put(
                "spring.mail.properties.smtp.auth",
                environment.getProperty("spring.mail.properties.smtp.auth", Boolean.class, false));

        properties.put(
                "spring.mail.smtp.properties.starttls.enable",
                environment.getProperty("spring.mail.properties.smtp.starttls.enable", Boolean.class, false));

        properties.put(
                "spring.mail.properties.transport.protocol",
                environment.getProperty("spring.mail.properties.transport.protocol", String.class));

        properties.put(
                "spring.mail.properties.smtps.timeout",
                environment.getProperty("spring.mail.properties.smtps.timeout", Integer.class ));
        mailSender.setJavaMailProperties(properties);
        return mailSender;
    }

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
