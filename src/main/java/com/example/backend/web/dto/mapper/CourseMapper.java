package com.example.backend.web.dto.mapper;

import com.example.backend.business.entity.CourseEntity;
import com.example.backend.business.enums.StatusCourseEnum;
import com.example.backend.web.dto.read.CourseReadDto;
import com.example.backend.web.dto.read.CourseTaskReadDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public abstract class CourseMapper {
    public CourseTaskReadDto toReadDto(CourseEntity courseEntity, StatusCourseEnum statusCourseEnum) {
        if ( courseEntity == null ) {
            return null;
        }

        CourseTaskReadDto courseTaskReadDto = new CourseTaskReadDto();

        if ( courseEntity.getId() != null ) {
            courseTaskReadDto.setId( courseEntity.getId().longValue() );
        }
        courseTaskReadDto.setStatus( statusCourseEnum );
        courseTaskReadDto.setTheory( courseEntity.getTheory() );
        courseTaskReadDto.setCookies( courseEntity.getCookies() );

        return courseTaskReadDto;
    }

    public abstract List<CourseReadDto> toReadDtos(List<CourseEntity> courseEntities);
    public abstract CourseReadDto toReadDto(CourseEntity courseEntitie);
}
