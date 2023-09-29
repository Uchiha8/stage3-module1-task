package com.mjc.school.repository.implementation;

import com.mjc.school.repository.NewsRepository;
import com.mjc.school.repository.exceptions.NewsNotFoundException;

import java.time.LocalDateTime;
import java.util.List;

public class NewsRepositoryImpl implements NewsRepository<NewsModel> {
    private final DataSource dataSource;

    public NewsRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public NewsModel create(NewsModel newsModel) {
        dataSource.addNews(newsModel);
        return newsModel;
    }

    @Override
    public List readAll() {
        return dataSource.getNewsList();
    }

    @Override
    public NewsModel updateNewsById(NewsModel newsModel) {
        try {
            NewsModel update_newsModel = readBy(newsModel.getId());
            update_newsModel.setTitle(newsModel.getTitle());
            update_newsModel.setContent(newsModel.getContent());
            update_newsModel.setAuthorId(newsModel.getAuthorId());
            update_newsModel.setLastUpdateDate(LocalDateTime.now());
            return update_newsModel;
        } catch (NewsNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public NewsModel readBy(Long id) throws NewsNotFoundException {
        List<NewsModel> newsModelList = dataSource.getNewsList();
        for (NewsModel newsModel : newsModelList) {
            if (newsModel.getId() == id) {
                return newsModel;
            }
        }
        throw new NewsNotFoundException("News with ID: " + id + " not found");
    }

    @Override
    public Boolean deleteNewsById(Long id) {
        return dataSource.removeNews(id);
    }
}
