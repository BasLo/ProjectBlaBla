package com.company.web.config.context;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import java.util.Properties;

public abstract class JpaSettings {

    @Value("${hibernate.dialect}")
    public String DIALECT;

    @Value("${hibernate.show_sql}")
    public String SHOW_SQL;

    @Value("${hibernate.format_sql}")
    public String FORMAT_SQL;

    @Value("${hibernate.hbm2ddl.auto}")
    public String HBM2DDL_AUTO;

    @Value("${hibernate.isolation.transactions}")
    public String ISOLATION;

    @Value("${hibernate.id.new_generator_mappings}")
    public String USE_NEW_ID_GENERATOR_MAPPINGS;

    //Data source properties
    @Value("${datasource.driver-class-name}")
    public String DATABASE_DRIVER_CLASSNAME;

    @Value("${datasource.url}")
    public String DATABASE_URL;

    @Value("${datasource.username}")
    public String DATABASE_USERNAME;

    @Value("${datasource.password}")
    public String DATABASE_PASSWORD;

    @Value("${datasource.datasource-name}")
    public String DATABASE_TYPE;

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    protected DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(DATABASE_DRIVER_CLASSNAME);
        dataSource.setUrl(DATABASE_URL);
        dataSource.setUsername(DATABASE_USERNAME);
        dataSource.setPassword(DATABASE_PASSWORD);

        return dataSource;
    }

    protected Properties jpaProperties() {
        Properties jpaProperties = new Properties();

        jpaProperties.put(Environment.DIALECT, DIALECT);
        jpaProperties.put(Environment.SHOW_SQL, SHOW_SQL);
        jpaProperties.put(Environment.FORMAT_SQL, FORMAT_SQL);
        jpaProperties.put(Environment.HBM2DDL_AUTO, HBM2DDL_AUTO);
        jpaProperties.put(Environment.ISOLATION, ISOLATION);
        jpaProperties.put(Environment.USE_NEW_ID_GENERATOR_MAPPINGS, USE_NEW_ID_GENERATOR_MAPPINGS);

        return jpaProperties;
    }

    @Bean
    public HibernateJpaVendorAdapter hibernateJpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();

        hibernateJpaVendorAdapter.setDatabase(Database.valueOf(DATABASE_TYPE));

        return hibernateJpaVendorAdapter;
    }

    protected HibernateJpaDialect hibernateJpaDialect() {
        return new HibernateJpaDialect();
    }
}
