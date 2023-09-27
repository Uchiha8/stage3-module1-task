package com.mjc.school.controller;

import com.mjc.school.service.dto.NewsDTO;
import com.mjc.school.service.impl.NewsServiceImpl;

import java.util.List;

public class NewsController {
    private NewsServiceImpl newsService;


    public void getAllNews() {
        List<NewsDTO> newsDTOList = newsService.readAll();
        for (NewsDTO news : newsDTOList) {
            System.out.println(news);
        }
    }

    public void getNewsById(Long id) {
        System.out.println(newsService.readById(id));
    }

    public void updateNewsById(NewsDTO newsDTO, Long id) {
        System.out.println(newsService.update(newsDTO, id));
    }

    public void create(NewsDTO newsDTO) {
        System.out.println(newsService.create(newsDTO));
    }

    public void deleteNewsById(Long id) {
        System.out.println(newsService.delete(id));
    }
}
