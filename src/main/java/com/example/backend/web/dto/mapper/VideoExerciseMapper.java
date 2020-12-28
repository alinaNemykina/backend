package com.example.backend.web.dto.mapper;

import com.example.backend.business.entity.VideoExerciseEntity;
import com.example.backend.business.enums.StatusTaskEnum;
import com.example.backend.web.dto.read.VideoExerciseReadDto;
import org.mapstruct.Mapper;

@Mapper
public abstract class VideoExerciseMapper {

    public VideoExerciseReadDto toReadDto(VideoExerciseEntity videoExerciseEntity) {
        if ( videoExerciseEntity == null ) {
            return null;
        }

        VideoExerciseReadDto videoExerciseReadDto = new VideoExerciseReadDto();

        videoExerciseReadDto.setId( videoExerciseEntity.getId() );
        videoExerciseReadDto.setName( videoExerciseEntity.getName() );
        videoExerciseReadDto.setVideoUrl( videoExerciseEntity.getVideoUrl() );
        videoExerciseReadDto.setCookies( videoExerciseEntity.getCookies() );
        videoExerciseReadDto.setStatus(StatusTaskEnum.LEARNING);
        videoExerciseReadDto.setImagePath("img/translation.jpeg");
        videoExerciseReadDto.setExplanation("И учи незнакомые слова!");
        videoExerciseReadDto.setTitle("Смотри классное видео!");

        return videoExerciseReadDto;
    }

}
