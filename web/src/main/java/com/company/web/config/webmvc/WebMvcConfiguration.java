package com.company.web.config.webmvc;

import com.company.web.config.security.SecurityConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.mvc.WebContentInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.Locale;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
        "com.company.web.controller.**"
})
@Import({SecurityConfig.class})
public class WebMvcConfiguration
        extends WebMvcConfigurerAdapter {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css*//**").addResourceLocations("/css/").setCachePeriod(31556926);
        registry.addResourceHandler("/img*//**").addResourceLocations("/img/").setCachePeriod(31556926);
        registry.addResourceHandler("/js*//**").addResourceLocations("/js/").setCachePeriod(31556926);
        registry.addResourceHandler("/WEB-INF/views*//**").addResourceLocations("/views/");
    }

    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        final InternalResourceViewResolver resolver = new InternalResourceViewResolver();

        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");

        return resolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        final WebContentInterceptor webContentInterceptor = new WebContentInterceptor();
        webContentInterceptor.setCacheSeconds(0);
        registry.addInterceptor(webContentInterceptor);
    }

    @Bean
    public LocaleResolver localeResolver() {
        final CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
        cookieLocaleResolver.setDefaultLocale(Locale.ENGLISH);
        return cookieLocaleResolver;
    }
}
