package com.newspaper.news.repository;

import com.newspaper.news.factory.CategoryFactory;
import com.newspaper.news.factory.UserFactory;
import com.newspaper.news.model.Category;
import com.newspaper.news.model.Users;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldFindByIdWhenCategoryExists() {
        long id = 1L;
        String userName = "Gabriel Alves";
        Users user = userRepository.findById(id).get();

        Assertions.assertEquals(userName, user.getName());
    }

    @Test
    public void shouldFindAllCategoryWhenExists() {
        List<Users> list = userRepository.findAll();
        String userName1 = "Gabriel Alves";
        String userName2 = "Teste da Silva";

        Assertions.assertEquals(userName1, list.get(0).getName());
        Assertions.assertEquals(userName2, list.get(1).getName());
    }

    @Test
    public void shouldCreateCategory() {
        Users user = UserFactory.createUser();
        user = userRepository.save(user);

        Assertions.assertEquals("Gabriel", user.getName());
    }
}
