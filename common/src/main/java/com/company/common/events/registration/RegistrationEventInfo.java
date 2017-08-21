package com.company.common.events.registration;

import java.util.Locale;

public interface RegistrationEventInfo {

    Locale getLocale();
    String getApplicationUrl();
    void setLocale(Locale locale);
    void setApplicationUrl(String applicationUrl);
}
