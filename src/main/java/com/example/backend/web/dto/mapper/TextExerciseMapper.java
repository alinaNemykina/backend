package com.example.backend.web.dto.mapper;

import com.example.backend.business.entity.TextExerciseEntity;
import com.example.backend.business.enums.StatusTaskEnum;
import com.example.backend.web.dto.read.TextExerciseReadDto;
import org.mapstruct.Mapper;

@Mapper
public abstract class TextExerciseMapper {

    public TextExerciseReadDto toReadDto(TextExerciseEntity textExerciseEntity) {
        if ( textExerciseEntity == null ) {
            return null;
        }

        TextExerciseReadDto textExerciseReadDto = new TextExerciseReadDto();

        textExerciseReadDto.setId( textExerciseEntity.getId() );
        textExerciseReadDto.setName( textExerciseEntity.getName() );
        textExerciseReadDto.setText( textExerciseEntity.getText() );
        textExerciseReadDto.setCookies( textExerciseEntity.getCookies() );
        textExerciseReadDto.setStatus(StatusTaskEnum.LEARNING);

        return textExerciseReadDto;
    }
}
