package com.newspaper.news.repository;

import com.newspaper.news.factory.CategoryFactory;
import com.newspaper.news.factory.NewsFactory;
import com.newspaper.news.model.Category;
import com.newspaper.news.model.News;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class NewsRepositoryTests {

    @Autowired
    private NewsRepository newsRepository;

    @Test
    public void shouldFindByIdWhenCategoryExists() {
        long id = 1L;
        String title = "Empregos em alta";
        News news = newsRepository.findById(id).get();

        Assertions.assertEquals(title, news.getTitle());
    }

    @Test
    public void shouldFindAllCategoryWhenExists() {
        List<News> list = newsRepository.findAll();
        String title1 = "Empregos em alta";
        String title2 = "Guarulhos no progresso";

        Assertions.assertEquals(title1, list.get(0).getTitle());
        Assertions.assertEquals(title2, list.get(1).getTitle());
    }

    @Test
    public void shouldCreateCategory() {
        News news = NewsFactory.createNews();
        news = newsRepository.save(news);

        Assertions.assertEquals("Guarulhos", news.getTitle());
    }
}
