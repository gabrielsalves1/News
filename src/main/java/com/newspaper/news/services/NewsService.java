package com.newspaper.news.services;

import com.newspaper.news.controller.dto.NewsDto;
import com.newspaper.news.controller.form.NewsForm;
import com.newspaper.news.model.News;
import com.newspaper.news.repository.CategoryRepository;
import com.newspaper.news.repository.NewsRepository;
import com.newspaper.news.repository.UserRepository;
import com.newspaper.news.services.validations.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
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
        News news = optional.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

        List<News> related = newsRepository.findByCategory_Id(news.getCategory().getId());
        List<NewsDto> relatedDto = related.stream().map(NewsDto::new).collect(Collectors.toList());

        NewsDto dto = new NewsDto(news);
        dto.setNewsRelated(relatedDto);

        return dto;
    }

    @Transactional
    public NewsDto insert(NewsForm form) {
        News news = form.convertToNews(categoryRepository, userRepository);
        news = newsRepository.save(news);

        return new NewsDto(news);
    }

    @Transactional
    public NewsDto update(Long id, NewsForm newsForm) {
        try {
            News news = newsRepository.getReferenceById(id);

            news.setTitle(newsForm.getTitle());
            news.setNewsText(newsForm.getNewsText());
            news.setCategory(categoryRepository.findById(newsForm.getCategoryId()).get());
            news.setUser(userRepository.findById(newsForm.getUserId()).get());
            news = newsRepository.save(news);

            return new NewsDto(news);
        } catch(EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    public void delete(Long id) {
        try {
            newsRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

}
