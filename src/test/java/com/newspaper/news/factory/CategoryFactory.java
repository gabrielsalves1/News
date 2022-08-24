package com.newspaper.news.factory;

import com.newspaper.news.model.Category;

public class CategoryFactory {
    public static Category createCategory() {
        return new Category("Cidade");
    }
}
