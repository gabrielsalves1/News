package com.newspaper.news.model;

import javax.persistence.*;

@Entity
public class News {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String newsText;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    public News() {
    }

    public News(String title, String newsText, Category category) {
        this.title = title;
        this.newsText = newsText;
        this.category = category;
    }
    public Long getId() {
        return id;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
