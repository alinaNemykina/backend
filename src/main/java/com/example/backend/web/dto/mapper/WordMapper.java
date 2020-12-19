package com.example.backend.web.dto.mapper;

import com.example.backend.business.entity.WordEntity;
import com.example.backend.business.enums.StatusWordEnum;
import com.example.backend.web.dto.read.WordReadDto;
import org.mapstruct.Mapper;

@Mapper
public abstract class WordMapper {

    public WordReadDto toReadDto(WordEntity wordEntity, StatusWordEnum statusWordEnum) {
        if ( wordEntity == null ) {
            return null;
        }

        WordReadDto wordReadDto = new WordReadDto();

        wordReadDto.setId( wordEntity.getId() );
        wordReadDto.setOriginal( wordEntity.getOriginal() );
        wordReadDto.setTranslation( wordEntity.getTranslation() );
        wordReadDto.setStatus(statusWordEnum);

        return wordReadDto;
    }

}
