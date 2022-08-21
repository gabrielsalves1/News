package com.newspaper.news.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
public class News implements Serializable {
    public static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String newsText;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
    @OneToOne
    @JoinColumn(name="user_id")
    private Users user;

    public News() {
    }
    public News(String title, String newsText, Category category, Users user) {
        this.title = title;
        this.newsText = newsText;
        this.category = category;
        this.user = user;
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
    public Users getUser() {
        return user;
    }
    public void setUser(Users user) {
        this.user = user;
    }
}
