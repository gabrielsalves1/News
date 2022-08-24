package com.newspaper.news.model;

import com.newspaper.news.factory.UserFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTests {

    @Test
    public void userShouldBeCreate() {
        String userName = "Gabriel";
        String userEmail = "gabrielsalves2k18@gmail.com";
        Users user = UserFactory.createUser();

        Assertions.assertEquals(userName, user.getName());
        Assertions.assertEquals(userEmail, user.getEmail());
    }
}
