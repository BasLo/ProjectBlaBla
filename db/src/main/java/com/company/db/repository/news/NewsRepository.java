package com.company.db.repository.news;

import com.company.domain.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository
        extends JpaRepository<News, Long> {
}
