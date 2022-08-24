package com.newspaper.news.factory;

import com.newspaper.news.model.Users;

public class UserFactory {
    public static Users createUser() {
        return new Users("Gabriel", "gabrielsalves2k18@gmail.com");
    }
}
