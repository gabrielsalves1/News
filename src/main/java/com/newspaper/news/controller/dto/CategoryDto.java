package com.newspaper.news.controller.dto;

import com.newspaper.news.model.Category;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryDto implements Serializable {
    public static final long serialVersionUID = 1L;
    private Long id;
    private String name;

    public CategoryDto(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }

    public static List<CategoryDto> converter(List<Category> news) {
        return news.stream().map(CategoryDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
