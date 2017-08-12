package com.company.db.repository.news;

import com.company.domain.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class NewsRepositoryImpl
        extends SimpleJpaRepository<News, Long>
        implements NewsRepository {

    @Autowired
    public NewsRepositoryImpl(@Qualifier("newsClass") Class<News> domainClass, EntityManager em) {
        super(domainClass, em);
    }
}
