package com.newspaper.news.controller.dto;

import com.newspaper.news.model.Category;
import com.newspaper.news.model.News;

import java.util.List;
import java.util.stream.Collectors;

public class NewsDto {
    private Long id;
    private String title;
    private String newsText;
    private Category category;

    public NewsDto(News news) {
        this.id = news.getId();
        this.title = news.getTitle();
        this.newsText = news.getNewsText();
        this.category = news.getCategory();
    }

    public static List<NewsDto> converter(List<News> news) {
        return news.stream().map(NewsDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getNewsText() {
        return newsText;
    }

    public Category getCategory() {
        return category;
    }
}
