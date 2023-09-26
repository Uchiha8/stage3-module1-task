package com.mjc.school.repository;

import com.mjc.school.repository.exceptions.NewsNotFoundException;

import java.util.List;

public interface NewsRepository<News> {
    News create(News news);

    List<News> getAllNews();

    News getNewsById(Long id) throws NewsNotFoundException;

    News updateNewsById(News news, Long id);

    Boolean deleteNewsById(Long id);
}
