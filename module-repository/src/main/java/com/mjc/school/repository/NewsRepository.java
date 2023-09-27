package com.mjc.school.repository;

import com.mjc.school.repository.exceptions.NewsNotFoundException;

import java.util.List;

public interface NewsRepository<T> {
    T create(T t);
    T readBy(Long id) throws NewsNotFoundException;
    List<T> readAll();
    T updateNewsById(T t);
    Boolean deleteNewsById(Long id);
}
