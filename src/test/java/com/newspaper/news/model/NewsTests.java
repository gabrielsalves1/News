package com.newspaper.news.model;

import com.newspaper.news.factory.NewsFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NewsTests {

    @Test
    public void newsShouldBeCreate() {
        String titleNews = "Guarulhos";
        String newsText = "Guarulhos está focada no progresso...";
        String userName = "Gabriel";
        String categoryName = "Cidade";
        News news = NewsFactory.createNews();

        Assertions.assertEquals(titleNews, news.getTitle());
        Assertions.assertEquals(newsText, news.getNewsText());
        Assertions.assertEquals(userName, news.getUser().getName());
        Assertions.assertEquals(categoryName, news.getCategory().getName());
    }
}
