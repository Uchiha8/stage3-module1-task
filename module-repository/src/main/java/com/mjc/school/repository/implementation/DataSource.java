package com.mjc.school.repository.implementation;

import com.mjc.school.repository.domain.Author;
import com.mjc.school.repository.domain.News;

import java.io.*;
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

    private DataSource() {

    }

    private static final String NEWS_FILE_PATH = "module-repository/src/main/resources/news.txt";
    private static final String CONTENT_FILE_PATH = "module-repository/src/main/resources/content.txt";
    private static final String AUTHOR_FILE_PATH = "module-repository/src/main/resources/author.txt";
    private List<News> newsList = new ArrayList<>();
    private List<Author> authorList = new ArrayList<>();

    public List<News> getNewsList() {
        parseNews();
        return newsList;
    }

    public List<Author> getAuthorList() {
        parseAuthor();
        return authorList;
    }

    public void parseNews() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(NEWS_FILE_PATH));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" : ");
                News news = new News();
                news.setId(Long.valueOf(parts[0]));
                news.setTitle(parts[1]);
                news.setAuthorId(Long.valueOf(parts[2]));
                news.setCreateDate(LocalDateTime.now());
                news.setLastUpdateDate(LocalDateTime.now());
                news = parseContent(news);
                newsList.add(news);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static News parseContent(News news) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(CONTENT_FILE_PATH));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(":");
                Long id = Long.valueOf(parts[0]);
                if (news.getId() == id) {
                    news.setContent(parts[1]);
                } else {
                    news.setContent("No content found");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return news;
    }

    public void parseAuthor() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(AUTHOR_FILE_PATH));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(" : ");
                Long id = Long.valueOf(parts[0]);
                String name = parts[1];
                authorList.add(new Author(id, name));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(News news) {
        newsList.add(news);
    }

    public Boolean deleteById(Long id) {
        return newsList.remove(id);
    }
}
