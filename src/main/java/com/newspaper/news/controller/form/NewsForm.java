package com.newspaper.news.controller.form;

import com.newspaper.news.model.Category;
import com.newspaper.news.model.News;
import com.newspaper.news.repository.NewsRepository;
import com.sun.istack.NotNull;

import javax.validation.constraints.NotEmpty;
public class NewsForm {
    @NotNull @NotEmpty
    public String title;
    @NotNull @NotEmpty
    public String newsText;
    @NotNull @NotEmpty
    public Category category;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public News converter(NewsRepository newsRepository) {
        return new News(title, newsText, category);
    }
}
