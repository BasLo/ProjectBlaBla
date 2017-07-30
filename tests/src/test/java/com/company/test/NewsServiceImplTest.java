package com.company.test;

import com.company.common.buisness.service.news.NewsService;
import com.company.db.dao.NewsDao;
import com.company.domain.entity.News;
import com.company.web.config.context.JpaConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.company.web.config.context.ContextConfiguration.class, JpaConfig.class})
//подгружаем контекст
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD) // запуск контекста спринга для каждого метода
//@ActiveProfiles (profiles = "test-profile") //выбор профиля
public class NewsServiceImplTest {

    static News news;
    @Autowired
    NewsService newsService;
    @Autowired
    NewsDao newsDao;

    @Test
    public void addNews() throws Exception {
        News n = new News();
        n.setText("some text");
        n.setTitle("title");
        n.setDateTime(new Date());

        news = newsService.addNews(n);

        assertNotNull(news.getId());
    }

    @Test
    public void getNewsById() throws Exception {
        assertNotNull(newsService.getNewsById(news.getId()));
    }

    @Test
    public void listNews() throws Exception {
    }

    @Test
    public void removeNews() throws Exception {
        newsService.removeNews(news.getId());
        assertNull(newsService.getNewsById(news.getId()));
    }

}