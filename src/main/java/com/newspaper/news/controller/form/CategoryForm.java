package com.newspaper.news.controller.form;

import com.newspaper.news.controller.dto.CategoryDto;
import com.newspaper.news.model.Category;
import com.newspaper.news.model.News;
import com.newspaper.news.repository.CategoryRepository;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryForm implements Serializable {
    public static final long serialVersionUID = 1L;
    private Long id;
    private String name;

    public CategoryForm() {
    }

    public CategoryForm(Category category) {
        this.name = category.getName();
    }

    public Category converter(CategoryRepository categoryRepository) {
        return new Category(name);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
