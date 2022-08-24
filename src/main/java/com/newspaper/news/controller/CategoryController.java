package com.newspaper.news.controller;

import com.newspaper.news.controller.dto.CategoryDto;
import com.newspaper.news.controller.form.CategoryForm;
import com.newspaper.news.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public ResponseEntity<List<CategoryDto>> findAll() {
        List<CategoryDto> categories = categoryService.findAll();

        return ResponseEntity.ok().body(categories);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> findById(@PathVariable Long id) {
        CategoryDto category = categoryService.findById(id);

        return ResponseEntity.ok().body(category);
    }
    @PostMapping
    public ResponseEntity<CategoryDto> insert(@RequestBody @Valid CategoryForm form, UriComponentsBuilder uriBuilder) {
        CategoryDto category = categoryService.insert(form);
        URI uri = uriBuilder.path("/news/{id}").buildAndExpand(category.getId()).toUri();

        return ResponseEntity.created(uri).body(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> update(@PathVariable Long id, @RequestBody @Valid CategoryForm form) {
        CategoryDto category = categoryService.update(id, form);

        return ResponseEntity.ok().body(category);
    }

    @DeleteMapping
    public ResponseEntity<CategoryDto> delete(@PathVariable Long id) {
        categoryService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
