package com.newspaper.news.services;

import com.newspaper.news.controller.dto.CategoryDto;
import com.newspaper.news.controller.form.CategoryForm;
import com.newspaper.news.model.Category;
import com.newspaper.news.repository.CategoryRepository;
import com.newspaper.news.services.validations.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Transactional(readOnly = true)
    public List<CategoryDto> findAll() {
        List<Category> list = categoryRepository.findAll();
        List<CategoryDto> listDto = CategoryDto.converter(list);

        return listDto;
    }

    @Transactional(readOnly = true)
    public CategoryDto findById(Long id) {
        Optional<Category> optional = categoryRepository.findById(id);
        Category category = optional.orElseThrow(() -> new EntityNotFoundException("Entity not found"));

        return new CategoryDto(category);
    }
    @Transactional
    public CategoryDto insert(CategoryForm form) {
        Category category = form.converterToCategory(categoryRepository);
        category = categoryRepository.save(category);

        return new CategoryDto(category);
    }
}
