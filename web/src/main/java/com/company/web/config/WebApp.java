package com.company.web.config;

import com.company.domain.annotation.Production;
import com.company.web.config.context.ContextConfiguration;
import com.company.web.config.context.JpaConfig;
import com.company.web.config.context.RepositoryDefinitions;
import com.company.web.config.tiles.TilesConfiguration;
import com.company.web.config.webmvc.WebMvcConfiguration;
import com.company.web.config.websocket.WebSocketConfig;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import java.nio.charset.StandardCharsets;

@Production
public class WebApp
        extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{
                ContextConfiguration.class,
                JpaConfig.class,
                TilesConfiguration.class,
                RepositoryDefinitions.class,
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{
                WebMvcConfiguration.class,
                WebSocketConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding(StandardCharsets.UTF_8.name());

        return new Filter[]{characterEncodingFilter};
    }

}