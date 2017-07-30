package com.company.web.config.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.persistence.EntityManagerFactory;

@Configuration
@PropertySource({
        "classpath:/jdbc.properties",
        "classpath:jpa/jpa.properties"
})
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.company.db.repository")
public class JpaConfig
        extends JpaSettings
        implements TransactionManagementConfigurer {

    @Override
    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new JpaTransactionManager();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPersistenceUnitName("com.company.domain.entity");
        entityManagerFactoryBean.setPackagesToScan("com.company.domain.entity");
        entityManagerFactoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter());
        entityManagerFactoryBean.setJpaDialect(hibernateJpaDialect());
        entityManagerFactoryBean.setJpaProperties(jpaProperties());
        entityManagerFactoryBean.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());

        return entityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager jpaTransactionManager(EntityManagerFactory emf) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();

        jpaTransactionManager.setEntityManagerFactory(emf);
        jpaTransactionManager.setJpaDialect(hibernateJpaDialect());

        return jpaTransactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

  /*  @Bean
    public EntityManager entityManager() {
        return entityManagerFactory().getObject().RepositoryDefinitionscreateEntityManager();
    }*/

}