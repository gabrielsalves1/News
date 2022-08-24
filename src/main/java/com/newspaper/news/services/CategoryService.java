package com.newspaper.news.services;

import com.newspaper.news.controller.dto.CategoryDto;
import com.newspaper.news.controller.dto.NewsDto;
import com.newspaper.news.controller.form.CategoryForm;
import com.newspaper.news.model.Category;
import com.newspaper.news.model.News;
import com.newspaper.news.repository.CategoryRepository;
import com.newspaper.news.services.validations.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Transactional(readOnly = true)
    public List<CategoryDto> findAll() {
        List<Category> list = categoryRepository.findAll();
        List<CategoryDto> listDto = list.stream().map(CategoryDto::new).collect(Collectors.toList());;

        return listDto;
    }

    @Transactional(readOnly = true)
    public CategoryDto findById(Long id) {
        Optional<Category> optional = categoryRepository.findById(id);
        Category category = optional.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

        return new CategoryDto(category);
    }
    @Transactional
    public CategoryDto insert(CategoryForm form) {
        Category category = form.convertToCategory(categoryRepository);
        category = categoryRepository.save(category);

        return new CategoryDto(category);
    }
    @Transactional
    public CategoryDto update(Long id, CategoryForm categoryForm) {
        try {
            Category category = categoryRepository.getReferenceById(id);

            category.setName(categoryForm.getName());
            category = categoryRepository.save(category);

            return new CategoryDto(category);
        } catch(EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    public void delete(Long id) {
        try {
            categoryRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }
}
