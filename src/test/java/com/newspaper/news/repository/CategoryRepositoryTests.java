package com.newspaper.news.repository;

import com.newspaper.news.factory.CategoryFactory;
import com.newspaper.news.model.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
public class CategoryRepositoryTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void shouldFindByIdWhenCategoryExists() {
        long id = 1L;
        String categoryName = "Cidade";
        Category category = categoryRepository.findById(id).get();

        Assertions.assertEquals(categoryName, category.getName());
    }

    @Test
    public void shouldFindAllCategoryWhenExists() {
        List<Category> list = categoryRepository.findAll();
        String categoryName1 = "Cidade";
        String categoryName2 = "Emprego";

        Assertions.assertEquals(categoryName1, list.get(0).getName());
        Assertions.assertEquals(categoryName2, list.get(1).getName());
    }

    @Test
    public void shouldCreateCategory() {
        Category category = CategoryFactory.createCategory();
        category = categoryRepository.save(category);

        Assertions.assertEquals("Cidade", category.getName());
    }


}
