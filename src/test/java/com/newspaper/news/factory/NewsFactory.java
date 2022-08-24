package com.newspaper.news.factory;

import com.newspaper.news.model.Category;
import com.newspaper.news.model.News;
import com.newspaper.news.model.Users;

public class NewsFactory {
    public static News createNews() {
        Category category = CategoryFactory.createCategory();
        Users user = UserFactory.createUser();
        return new News("Guarulhos", "Guarulhos está focada no progresso...", category, user);
    }
}
