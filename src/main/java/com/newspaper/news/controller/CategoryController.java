package com.newspaper.news.controller;

import com.newspaper.news.controller.dto.CategoryDto;
import com.newspaper.news.controller.dto.NewsDto;
import com.newspaper.news.model.Category;
import com.newspaper.news.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public List<CategoryDto> list() {
        List<Category> category = categoryRepository.findAll();

        return CategoryDto.converter(category);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> show(@PathVariable Long id) {
        Optional<Category> category = categoryRepository.findById(id);

        if (category.isPresent()) {
            return ResponseEntity.ok(new CategoryDto(category.get()));
        }

        return ResponseEntity.notFound().build();
    }
}
