package com.newspaper.news.controller;

import com.newspaper.news.controller.dto.NewsDto;
import com.newspaper.news.controller.form.NewsForm;
import com.newspaper.news.model.News;
import com.newspaper.news.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsRepository newsRepository;

    @GetMapping
    public List<NewsDto> list() {
        List<News> news = newsRepository.findAll();

        return NewsDto.converter(news);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsDto> show(@PathVariable Long id) {
        Optional<News> news = newsRepository.findById(id);
        if (news.isPresent()) {
            return ResponseEntity.ok(new NewsDto(news.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<NewsDto> create(@RequestBody @Valid NewsForm form, UriComponentsBuilder uriBuilder) {
        News news = form.converter(newsRepository);
        newsRepository.save(news);

        URI uri = uriBuilder.path("/news/{id}").buildAndExpand(news.getId()).toUri();
        return ResponseEntity.created(uri).body(new NewsDto(news));
    }
}
