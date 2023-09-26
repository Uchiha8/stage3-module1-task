package com.mjc.school.service;

import java.util.List;

public interface Service<T> {
    T create(T t);

    T readById(Long id);

    List<T> readAll();

    T update(T t, Long id);

    Boolean delete(Long id);

}
