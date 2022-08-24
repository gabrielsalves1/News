package com.newspaper.news.model;

import com.newspaper.news.factory.CategoryFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CategoryTests {

    @Test
    public void categoryShouldBeCreate() {
        String categoryName = "Cidade";
        Category category = CategoryFactory.createCategory();

        Assertions.assertEquals(categoryName, category.getName());
    }
}
