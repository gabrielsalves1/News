package com.newspaper.news.controller.form;

import com.newspaper.news.model.Category;
import com.newspaper.news.model.News;
import com.newspaper.news.repository.CategoryRepository;
import com.newspaper.news.repository.NewsRepository;
import com.newspaper.news.repository.UserRepository;
import com.sun.istack.NotNull;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.Instant;

public class NewsForm implements Serializable {
    public static final long serialVersionUID = 1L;
    @NotNull @NotEmpty
    public String title;
    @NotNull @NotEmpty
    public String newsText;
    @NotNull
    public Long categoryId;
    @NotNull
    public Long userId;

    public NewsForm() {
    }

    public NewsForm(News news) {
        this.title = news.getTitle();
        this.newsText = news.getNewsText();
        this.categoryId = news.getCategory().getId();
        this.userId = news.getUser().getId();
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getNewsText() {
        return newsText;
    }
    public void setNewsText(String newsText) {
        this.newsText = newsText;
    }

    public Long getCategory_id() {
        return categoryId;
    }

    public void setCategory_id(Long categoryId) {
        this.categoryId = categoryId;
    }

    public News converterToNews(CategoryRepository categoryRepository, UserRepository userRepository) {
        return new News(title, newsText, categoryRepository.findById(categoryId).get(), userRepository.findById(userId).get());
    }
}
