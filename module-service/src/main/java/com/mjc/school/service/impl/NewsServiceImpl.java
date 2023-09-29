package com.mjc.school.service.impl;

import com.mjc.school.repository.exceptions.NewsNotFoundException;
import com.mjc.school.repository.implementation.NewsModel;
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
            NewsModel newsModel = newsMapper.toModel(newsDTO);
            newsRepository.create(newsModel);
        }
        return newsDTO;
    }

    @Override
    public NewsDTO readById(Long id) {
        try {
            NewsDTO newsDTO = newsMapper.toDTO(newsRepository.readBy(id));
            return newsDTO;
        } catch (NewsNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<NewsDTO> readAll() {
        List<NewsModel> newsModelList = newsRepository.readAll();
        List<NewsDTO> newsDTOList = new ArrayList<>();
        for (NewsModel newsModel : newsModelList) {
            newsDTOList.add(newsMapper.toDTO(newsModel));
        }
        return newsDTOList;
    }

    @Override
    public NewsDTO update(NewsDTO newsDTO) {
        if (validParam(newsDTO) && existNews(newsDTO.getId())) {
            newsRepository.updateNewsById(newsMapper.toModel(newsDTO));
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
            NewsModel newsModel = newsRepository.readBy(id);
            return true;
        } catch (NewsNotFoundException e) {
            throw new RuntimeException("News with provided ID: " + id + " not found");
        }
    }
}
