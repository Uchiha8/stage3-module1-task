package com.mjc.school.repository;

import com.mjc.school.repository.domain.News;
import com.mjc.school.repository.exceptions.NewsNotFoundException;

import java.util.List;

public interface NewsRepository<T> {
    List<T> getAllNews();

    T getNewsById(Long id) throws NewsNotFoundException;

    News create(News news) throws NewsNotFoundException;

    News update(News o, Long id);

    Boolean deleteById(Long id);
}
