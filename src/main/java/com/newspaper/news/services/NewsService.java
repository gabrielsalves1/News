package com.newspaper.news.services;

import com.newspaper.news.controller.dto.NewsDto;
import com.newspaper.news.controller.form.NewsForm;
import com.newspaper.news.model.News;
import com.newspaper.news.repository.CategoryRepository;
import com.newspaper.news.repository.NewsRepository;
import com.newspaper.news.repository.UserRepository;
import com.newspaper.news.services.validations.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<NewsDto> findAll() {
        List<News> list = newsRepository.findAll();
        List<NewsDto> listDto = list.stream().map(NewsDto::new).collect(Collectors.toList());;

        return listDto;
    }

    @Transactional(readOnly = true)
    public NewsDto findById(Long id) {
        Optional<News> optional = newsRepository.findById(id);
        News news = optional.orElseThrow(() -> new EntityNotFoundException("Entity not found"));;

        return new NewsDto(news);
    }

    @Transactional
    public NewsDto insert(NewsForm form) {
        News news = form.converterToNews(categoryRepository, userRepository);
        news = newsRepository.save(news);

        return new NewsDto(news);
    }
}
