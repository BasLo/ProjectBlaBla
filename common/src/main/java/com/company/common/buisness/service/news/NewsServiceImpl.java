package com.company.common.buisness.service.news;

import com.company.db.repository.news.NewsRepository;
import com.company.domain.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("newsService")
public class NewsServiceImpl implements NewsService {

    private NewsRepository newsRepository;

    @Override
    public News addNews(News news) {
        return newsRepository.saveAndFlush(news);
    }

    @Autowired
    public void setNewsRepository(@Qualifier("newsRepositoryImpl") NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }
}