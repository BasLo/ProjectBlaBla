package com.company.common.events.registration;

import com.company.common.buisness.service.token.VerificationTokenService;
import com.company.domain.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RegistrationListener
        implements ApplicationListener<RegistrationCompleteEvent>{

    private VerificationTokenService service;

    private MessageSource messages;

    private JavaMailSender mailSender;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent registrationCompleteEvent) {
        this.confirmRegistration(registrationCompleteEvent);
    }

    private void confirmRegistration(RegistrationCompleteEvent event) {
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        service.createVerificationToken(user, token);

        String recipientAddress = user.getEmailAddress();
        String subject = "Registration Confirmation";
        String confirmationUrl
                = event.getAppUrl() + "/mailRegistrationConfirm?token=" + token;
        String message = messages.getMessage("message.regSucc", null, event.getLocale());

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message + " rn" + "http://localhost:8080" + confirmationUrl);
//        mailSender.send(email);
    }

    @Autowired
    public void setMessages(MessageSource messages) {
        this.messages = messages;
    }

    @Autowired
    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Autowired
    public void setService(VerificationTokenService service) {
        this.service = service;
    }
}
