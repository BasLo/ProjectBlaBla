package com.company.web.config.context;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.PostConstruct;

@Configuration
@ComponentScan(basePackages = {
        "com.company.common.**",
        "com.company.web.config.**",
        "com.company.db.**"
})
@PropertySource({
        "classpath:/jdbc.properties",
        "classpath:jpa/jpa.properties"
})
//@Import(RepositoryDefinitions.class)
public class ContextConfiguration
        extends JpaSettings {

    @Bean
    @PostConstruct
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();

        liquibase.setDataSource(dataSource());
        liquibase.setContexts("test, production");
        liquibase.setChangeLog("classpath:liquibase/liquibase-changelog-config.xml");

        return liquibase;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(
                "com.company.domain.entity",
                "com.company.domain.entity.**"
        );
        sessionFactory.setHibernateProperties(jpaProperties());

        return sessionFactory;
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(10000);
        return multipartResolver;
    }
}