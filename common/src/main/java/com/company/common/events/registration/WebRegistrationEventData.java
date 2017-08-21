package com.company.common.events.registration;

import org.springframework.web.context.request.WebRequest;

import java.util.Locale;

public class WebRegistrationEventData
    implements RegistrationEventInfo{

    private String applicationUrl;
    private Locale locale;

    public WebRegistrationEventData(){
        super();
    }

    public WebRegistrationEventData(WebRequest request) {
        this.applicationUrl = request.getContextPath();
        this.locale = request.getLocale();
    }

    @Override
    public Locale getLocale() {
        return locale;
    }

    @Override
    public String getApplicationUrl() {
        return applicationUrl;
    }

    @Override
    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    @Override
    public void setApplicationUrl(String applicationUrl) {
        this.applicationUrl = applicationUrl;
    }
}
