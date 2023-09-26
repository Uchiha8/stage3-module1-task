package com.mjc.school.service.impl;

import com.mjc.school.repository.exceptions.NewsNotFoundException;
import com.mjc.school.repository.implementation.News;
import com.mjc.school.repository.implementation.NewsRepositoryImpl;
import com.mjc.school.service.Service;
import com.mjc.school.service.dto.NewsDTO;
import com.mjc.school.service.mapper.NewsMapper;

import java.util.ArrayList;
import java.util.List;

public class NewsServiceImpl implements Service<NewsDTO> {
    private final NewsMapper newsMapper;
    private final NewsRepositoryImpl newsRepository;

    public NewsServiceImpl(NewsMapper newsMapper, NewsRepositoryImpl newsRepository) {
        this.newsMapper = newsMapper;
        this.newsRepository = newsRepository;
    }


    @Override
    public NewsDTO create(NewsDTO newsDTO) {
        if (validParam(newsDTO)) {
            News news = newsMapper.toModel(newsDTO);
            newsRepository.create(news);
        }
        return newsDTO;
    }

    @Override
    public NewsDTO readById(Long id) {
        try {
            NewsDTO newsDTO = newsMapper.toDTO(newsRepository.getNewsById(id));
            return newsDTO;
        } catch (NewsNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<NewsDTO> readAll() {
        List<News> newsList = newsRepository.getAllNews();
        List<NewsDTO> newsDTOList = new ArrayList<>();
        for (News news : newsList) {
            newsDTOList.add(newsMapper.toDTO(news));
        }
        return newsDTOList;
    }

    @Override
    public NewsDTO update(NewsDTO newsDTO, Long id) {
        if (validParam(newsDTO) && existNews(id)) {
            newsRepository.updateNewsById(newsMapper.toModel(newsDTO), id);
        }
        return newsDTO;
    }

    @Override
    public Boolean delete(Long id) {
        if (existNews(id)) {
            return newsRepository.deleteNewsById(id);
        }
        return false;
    }

    public boolean validParam(NewsDTO newsDTO) {
        int contentLength = newsDTO.getContent().length();
        int titleLength = newsDTO.getTitle().length();
        if (!(contentLength >= 5 && contentLength <= 255)) {
            throw new RuntimeException("Content length should be between 5 and 255");
        }
        if (!(titleLength >= 5 && titleLength <= 30)) {
            throw new RuntimeException("Title length should be between 5 and 30");
        }
        return true;
    }

    public boolean existNews(Long id) {
        try {
            News news = newsRepository.getNewsById(id);
            return true;
        } catch (NewsNotFoundException e) {
            throw new RuntimeException("News with provided ID: " + id + " not found");
        }
    }
}
