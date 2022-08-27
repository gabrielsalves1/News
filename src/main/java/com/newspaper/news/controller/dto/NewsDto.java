package com.newspaper.news.controller.dto;

import com.newspaper.news.model.Category;
import com.newspaper.news.model.News;
import com.newspaper.news.model.Users;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class NewsDto implements Serializable {
    public static final long serialVersionUID = 1L;
    private Long id;
    private String title;
    private String newsText;
    private Category category;
    private Users user;
    private LocalDateTime publicationDate;
    private List<NewsDto> newsRelated;

    public NewsDto() {
    }

    public NewsDto(News news) {
        this.id = news.getId();
        this.title = news.getTitle();
        this.newsText = news.getNewsText();
        this.category = news.getCategory();
        this.user = news.getUser();
        this.publicationDate = news.getPublicationDate();
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
    public Users getUser() {
        return user;
    }
    public LocalDateTime getPublicationDate() { return publicationDate; }
    public List<NewsDto> getNewsRelated() {
        return newsRelated;
    }
    public void setNewsRelated(List<NewsDto> newsRelated) {
        this.newsRelated = newsRelated;
    }
}
