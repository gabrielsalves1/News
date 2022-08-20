package com.newspaper.news.controller.dto;

import com.newspaper.news.model.Users;

import java.io.Serializable;

public class UserDto implements Serializable {
    public static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String email;

    public UserDto() {
    }

    public UserDto(Users users) {
        this.id = users.getId();
        this.name = users.getName();
        this.email = users.getEmail();
    }

    public UserDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
