package com.newspaper.news.controller;

import com.newspaper.news.controller.dto.NewsDto;
import com.newspaper.news.controller.dto.UserDto;
import com.newspaper.news.controller.form.NewsForm;
import com.newspaper.news.controller.form.UserForm;
import com.newspaper.news.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        List<UserDto> users = userService.findAll();

        return ResponseEntity.ok().body(users);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Long id) {
        UserDto user = userService.findById(id);

        return ResponseEntity.ok().body(user);
    }
    @PostMapping
    public ResponseEntity<UserDto> insert(@RequestBody @Valid UserForm form, UriComponentsBuilder uriBuilder) {
        UserDto user = userService.insert(form);
        URI uri = uriBuilder.path("/news/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(user);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable Long id, @RequestBody @Valid UserForm form) {
        UserDto user = userService.update(id, form);

        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping
    public ResponseEntity<UserDto> delete(@PathVariable Long id) {
        userService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
