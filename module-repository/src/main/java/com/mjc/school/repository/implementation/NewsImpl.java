package com.mjc.school.repository.implementation;

import com.mjc.school.repository.NewsRepository;
import com.mjc.school.repository.domain.News;
import com.mjc.school.repository.exceptions.NewsNotFoundException;

import java.util.List;

public class NewsImpl implements NewsRepository {
    private final DataSource dataSource = DataSource.getInstance();

    @Override
    public List<News> getAllNews() {
        return dataSource.getNewsList();
    }

    @Override
    public News getNewsById(Long id) throws NewsNotFoundException {
        List<News> newsList = dataSource.getNewsList();
        for (News news : newsList) {
            if (news.getId() == id) {
                return news;
            } else {
                throw new NewsNotFoundException("News with ID: " + id + " not found!!!");
            }
        }
        return null;
    }

    @Override
    public News create(News news) throws NewsNotFoundException {
        Long id = (long) (dataSource.getNewsList().size() + 1);
        news.setId(id);
        dataSource.saveNews(news);
        return getNewsById(id);
    }

    @Override
    public News update(News updated_news, Long id) {
        News news;
        try {
            news = getNewsById(id);
            news.setId(updated_news.getId());
            news.setTitle(updated_news.getTitle());
            news.setContent(updated_news.getContent());
        } catch (NewsNotFoundException e) {
            throw new RuntimeException(e);
        }
        return news;
    }

    @Override
    public Boolean deleteById(Long id) {
        return dataSource.deleteById(id);
    }
}
