package com.example.backend.web.dto.mapper;

import com.example.backend.business.entity.WordSetEntity;
import com.example.backend.web.dto.read.WordSetReadDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public abstract class WordSetMapper {

    public abstract List<WordSetReadDto> toReadDtos(List<WordSetEntity> wordSetEntity);
    public abstract WordSetReadDto toReadDto(WordSetEntity wordSetEntity);
}
