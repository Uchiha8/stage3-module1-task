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
    public List getAllNews() {
        return dataSource.getNewsList();
    }

    @Override
    public News getNewsById(Long id) throws NewsNotFoundException {
        List<News> newsList = dataSource.getNewsList();
        for (News news : newsList) {
            if (news.getId() == id) {
                return news;
            }
        }
        throw new NewsNotFoundException("News with ID: " + id + " not found");
    }

    @Override
    public News updateNewsById(News news, Long id) {
        try {
            News update_news = getNewsById(id);
            update_news.setId(news.getId());
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
    public Boolean deleteNewsById(Long id) {
        return dataSource.removeNews(id);
    }
}
