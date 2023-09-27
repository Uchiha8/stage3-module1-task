package com.mjc.school.repository.implementation;

import com.mjc.school.repository.NewsRepository;
import com.mjc.school.repository.exceptions.NewsNotFoundException;

import java.time.LocalDateTime;
import java.util.List;

public class NewsRepositoryImpl implements NewsRepository<News> {

    private final DataSource dataSource = DataSource.getInstance();

    @Override
    public News create(News news) {
        dataSource.addNews(news);
        return news;
    }

    @Override
    public List readAll() {
        return dataSource.getNewsList();
    }

    @Override
    public News updateNewsById(News news) {
        try {
            News update_news = readBy(news.getId());
            update_news.setTitle(news.getTitle());
            update_news.setContent(news.getContent());
            update_news.setAuthorId(news.getAuthorId());
            update_news.setLastUpdateDate(LocalDateTime.now());
            return update_news;
        } catch (NewsNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public News readBy(Long id) throws NewsNotFoundException {
        List<News> newsList = dataSource.getNewsList();
        for (News news : newsList) {
            if (news.getId() == id) {
                return news;
            }
        }
        throw new NewsNotFoundException("News with ID: " + id + " not found");
    }

    @Override
    public Boolean deleteNewsById(Long id) {
        return dataSource.removeNews(id);
    }
}
