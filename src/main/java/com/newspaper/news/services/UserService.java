package com.newspaper.news.services;

import com.newspaper.news.controller.dto.UserDto;
import com.newspaper.news.controller.form.UserForm;
import com.newspaper.news.model.Users;
import com.newspaper.news.repository.UserRepository;
import com.newspaper.news.services.validations.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<UserDto> findAll() {
        List<Users> users = userRepository.findAll();
        List<UserDto> usersDto = users.stream().map(UserDto::new).collect(Collectors.toList());

        return usersDto;
    }

    @Transactional(readOnly = true)
    public UserDto findById(Long id) {
        Optional<Users> optional = userRepository.findById(id);
        Users user = optional.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

        return new UserDto(user);
    }

    @Transactional
    public UserDto insert(UserForm form) {
        Users user = form.convertToUser(userRepository);
        user = userRepository.save(user);

        return new UserDto(user);
    }

    @Transactional
    public UserDto update(Long id, UserForm form) {
        Users user = userRepository.getReferenceById(id);

        user.setName(form.getName());
        user.setEmail(form.getEmail());
        user = userRepository.save(user);

        return new UserDto(user);
    }

    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

}
