package com.newspaper.news.controller.form;

import com.newspaper.news.model.Users;
import com.newspaper.news.repository.UserRepository;
import com.sun.istack.NotNull;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class UserForm implements Serializable {
    public static final long serialVersionUID = 1L;
    @NotNull @NotEmpty
    private String name;
    @NotNull @NotEmpty
    private String email;
    public UserForm() {
    }
    public UserForm(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public Users convertToUser(UserRepository userRepository) {
        return new Users(name, email);
    }
}
