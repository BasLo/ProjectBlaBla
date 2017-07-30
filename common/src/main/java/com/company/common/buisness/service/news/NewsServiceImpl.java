package com.company.common.buisness.service.news;

import com.company.db.dao.NewsDao;
import com.company.domain.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("newsService")
public class NewsServiceImpl implements NewsService {

    private NewsDao newsDao;

    @Override
    @Transactional
    public News addNews(News news) {
        return newsDao.create(news);
    }

    @Override
    public News getNewsById(Long id) {
        return newsDao.read(id);
    }

    @Override
    @Transactional
    public void removeNews(Long id) {
        newsDao.delete(id);
    }

    @Autowired
    public void setNewsDao(NewsDao newsDao) {
        this.newsDao = newsDao;
    }

}