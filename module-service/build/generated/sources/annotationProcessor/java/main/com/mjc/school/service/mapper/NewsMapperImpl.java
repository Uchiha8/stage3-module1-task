package com.mjc.school.service.mapper;

import com.mjc.school.repository.implementation.NewsModel;
import com.mjc.school.service.dto.NewsDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-27T10:03:36+0500",
    comments = "version: 1.5.4.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.2.jar, environment: Java 17.0.5 (Oracle Corporation)"
)
public class NewsMapperImpl implements NewsMapper {

    @Override
    public NewsDTO toDTO(NewsModel newsModel) {
        if ( newsModel == null ) {
            return null;
        }

        NewsDTO newsDTO = new NewsDTO();

        newsDTO.setId( newsModel.getId() );
        newsDTO.setTitle( newsModel.getTitle() );
        newsDTO.setContent( newsModel.getContent() );
        newsDTO.setCreateDate( newsModel.getCreateDate() );
        newsDTO.setLastUpdateDate( newsModel.getLastUpdateDate() );
        newsDTO.setAuthorId( newsModel.getAuthorId() );

        return newsDTO;
    }

    @Override
    public NewsModel toModel(NewsDTO newsDTO) {
        if ( newsDTO == null ) {
            return null;
        }

        NewsModel newsModel = new NewsModel();

        newsModel.setId( newsDTO.getId() );
        newsModel.setTitle( newsDTO.getTitle() );
        newsModel.setContent( newsDTO.getContent() );
        newsModel.setCreateDate( newsDTO.getCreateDate() );
        newsModel.setLastUpdateDate( newsDTO.getLastUpdateDate() );
        newsModel.setAuthorId( newsDTO.getAuthorId() );

        return newsModel;
    }
}
