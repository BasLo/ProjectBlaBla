package com.company.web.config.context;

import com.company.db.repository.comment.CommentRepository;
import com.company.db.repository.comment.CommentRepositoryImpl;
import com.company.db.repository.news.NewsRepository;
import com.company.db.repository.news.NewsRepositoryImpl;
import com.company.db.repository.user.UserRepository;
import com.company.db.repository.user.UserRepositoryImpl;
import com.company.domain.entity.Comment;
import com.company.domain.entity.News;
import com.company.domain.entity.VerificationToken;
import com.company.domain.entity.user.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class RepositoryDefinitions {

    @Bean
    public UserRepository userRepository(EntityManager entityManager){
        return new UserRepositoryImpl(User.class, entityManager);
    }

    @Bean
    public Class<User> userClass() {
        return User.class;
    }

    @Bean
    public CommentRepository commentRepository(EntityManager entityManager){
        return new CommentRepositoryImpl(Comment.class, entityManager);
    }

    @Bean
    public Class<Comment> commentClass(){
        return Comment.class;
    }

    @Bean
    public NewsRepository newsRepository(EntityManager entityManager){
        return new NewsRepositoryImpl(News.class, entityManager);
    }

    @Bean
    public Class<News> newsClass(){
        return News.class;
    }
}
