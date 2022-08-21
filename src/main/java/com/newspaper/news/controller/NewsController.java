package com.newspaper.news.controller;

import com.newspaper.news.controller.dto.NewsDto;
import com.newspaper.news.controller.form.NewsForm;
import com.newspaper.news.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;
    @GetMapping
    public ResponseEntity<List<NewsDto>> findAll() {
        List<NewsDto> news = newsService.findAll();

        return ResponseEntity.ok().body(news);
    }
    @GetMapping("/{id}")
    public ResponseEntity<NewsDto> findById(@PathVariable Long id) {
        NewsDto news = newsService.findById(id);

        return ResponseEntity.ok().body(news);
    }
    @PostMapping
    public ResponseEntity<NewsDto> insert(@RequestBody @Valid NewsForm form, UriComponentsBuilder uriBuilder) {
        NewsDto news = newsService.insert(form);
        URI uri = uriBuilder.path("/news/{id}").buildAndExpand(news.getId()).toUri();

        return ResponseEntity.created(uri).body(news);
    }
    @PutMapping("/{id}")
    public ResponseEntity<NewsDto> update(@PathVariable Long id, @RequestBody @Valid NewsForm newsForm) {
        NewsDto newsDto = newsService.update(id, newsForm);

        return ResponseEntity.ok().body(newsDto);
    }
}
