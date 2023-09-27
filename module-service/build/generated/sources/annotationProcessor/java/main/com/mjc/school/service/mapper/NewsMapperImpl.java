package com.mjc.school.service.mapper;

import com.mjc.school.repository.implementation.News;
import com.mjc.school.service.dto.NewsDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-27T10:03:36+0500",
    comments = "version: 1.5.4.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.2.jar, environment: Java 17.0.5 (Oracle Corporation)"
)
public class NewsMapperImpl implements NewsMapper {

    @Override
    public NewsDTO toDTO(News news) {
        if ( news == null ) {
            return null;
        }

        NewsDTO newsDTO = new NewsDTO();

        newsDTO.setId( news.getId() );
        newsDTO.setTitle( news.getTitle() );
        newsDTO.setContent( news.getContent() );
        newsDTO.setCreateDate( news.getCreateDate() );
        newsDTO.setLastUpdateDate( news.getLastUpdateDate() );
        newsDTO.setAuthorId( news.getAuthorId() );

        return newsDTO;
    }

    @Override
    public News toModel(NewsDTO newsDTO) {
        if ( newsDTO == null ) {
            return null;
        }

        News news = new News();

        news.setId( newsDTO.getId() );
        news.setTitle( newsDTO.getTitle() );
        news.setContent( newsDTO.getContent() );
        news.setCreateDate( newsDTO.getCreateDate() );
        news.setLastUpdateDate( newsDTO.getLastUpdateDate() );
        news.setAuthorId( newsDTO.getAuthorId() );

        return news;
    }
}
