package com.newspaper.news.services;

import com.newspaper.news.controller.dto.NewsDto;
import com.newspaper.news.controller.form.NewsForm;
import com.newspaper.news.model.News;
import com.newspaper.news.repository.NewsRepository;
import com.newspaper.news.model.validations.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Transactional(readOnly = true)
    public List<NewsDto> findAll() {
        List<News> list = newsRepository.findAll();
        List<NewsDto> listDto = NewsDto.converter(list);

        return listDto;
    }

    @Transactional(readOnly = true)
    public NewsDto findById(Long id) {
        Optional<News> optional = newsRepository.findById(id);
        News news = optional.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));;

        return new NewsDto(news);
    }

    @Transactional
    public NewsDto insert(NewsForm form) {
        News news = form.converter(newsRepository);
        news = newsRepository.save(news);

        return new NewsDto(news);
    }
}
