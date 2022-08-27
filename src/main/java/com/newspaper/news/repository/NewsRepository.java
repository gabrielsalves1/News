package com.newspaper.news.repository;

import com.newspaper.news.model.Category;
import com.newspaper.news.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> findByCategory_Id(Long id);
}
