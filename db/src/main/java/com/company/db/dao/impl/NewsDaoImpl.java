package com.company.db.dao.impl;

import com.company.db.dao.NewsDao;
import com.company.db.dao.generic.GenericDaoJpaImpl;
import com.company.domain.entity.News;
import org.springframework.stereotype.Repository;

@Repository
public class NewsDaoImpl
        extends GenericDaoJpaImpl<News, Long>
        implements NewsDao {

}
