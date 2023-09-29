package com.mjc.school.service.mapper;

import com.mjc.school.repository.implementation.NewsModel;
import com.mjc.school.service.dto.NewsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NewsMapper {
    NewsMapper INSTANCE = Mappers.getMapper(NewsMapper.class);

    NewsDTO toDTO(NewsModel newsModel);

    NewsModel toModel(NewsDTO newsDTO);
}
