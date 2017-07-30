package com.company.common.buisness.service.news;

import com.company.domain.entity.News;

public interface NewsService {

    News addNews(News news);

    News getNewsById(Long id);

    void removeNews(Long id);
}
