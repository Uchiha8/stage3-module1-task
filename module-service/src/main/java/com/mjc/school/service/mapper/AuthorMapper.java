package com.mjc.school.service.mapper;

import com.mjc.school.repository.implementation.Author;
import com.mjc.school.service.dto.AuthorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    AuthorDTO toDTO(Author author);

    Author toModel(AuthorDTO authorDTO);
}
