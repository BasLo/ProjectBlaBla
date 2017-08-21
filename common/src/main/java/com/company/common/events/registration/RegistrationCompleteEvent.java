package com.company.common.events.registration;

import com.company.domain.entity.user.User;
import org.springframework.context.ApplicationEvent;

import java.util.Locale;

public class RegistrationCompleteEvent
        extends ApplicationEvent{

    private String appUrl;
    private Locale locale;
    private User user;

    public RegistrationCompleteEvent(User user) {
        super(user);
    }

    public RegistrationCompleteEvent(User user, RegistrationEventInfo regInfo){
        super(user);
        this.user = user;
        this.appUrl = regInfo.getApplicationUrl();
        this.locale = regInfo.getLocale();
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
