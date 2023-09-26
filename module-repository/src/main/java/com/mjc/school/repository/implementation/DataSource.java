package com.mjc.school.repository.implementation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    private static DataSource INSTANCE;

    public static DataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DataSource();
        }
        return INSTANCE;
    }

    private static final String NEWS_FILE_PATH = "module-repository/src/main/resources/news.txt";
    private static final String AUTHOR_FILE_PATH = "module-repository/src/main/resources/author.txt";

    private static List<News> newsList = new ArrayList<>();
    private static List<Author> authorsList = new ArrayList<>();

    public List<News> getNewsList() {
        return newsList;
    }

    public List<Author> getAuthorsList() {
        return authorsList;
    }

    public News addNews(News news) {
        newsList.add(news);
        return news;
    }

    public Author addAuthor(Author author) {
        authorsList.add(author);
        return author;
    }

    public Boolean removeNews(Long id) {
        return newsList.remove(id);
    }

    public Boolean removeAuthor(Long id) {
        return authorsList.remove(id);
    }

    // static block for parsing data at run time and save into arrays
    static {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(NEWS_FILE_PATH));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] partsNews = line.split(":");
                Long id = Long.valueOf(partsNews[0]);
                String title = partsNews[1];
                String content = partsNews[2];
                LocalDateTime createDate = LocalDateTime.now();
                LocalDateTime lastUpdateDate = LocalDateTime.now();
                Long authorId = Long.valueOf(partsNews[3]);
                News news = new News(id, title, content, createDate, lastUpdateDate, authorId);
                newsList.add(news);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //static block for parsing author at run time I think it's ok
    static {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(AUTHOR_FILE_PATH));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] partsAuthor = line.split(":");
                Long id = Long.valueOf(partsAuthor[0]);
                String name = partsAuthor[1];
                Author author = new Author(id, name);
                authorsList.add(author);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
