package com.example.backend.web.dto.read;

import com.example.backend.business.enums.StatusCourseEnum;
import lombok.Data;

@Data
public class CourseTaskReadDto {
    Long id;
    StatusCourseEnum status;
    String theory;
    Integer cookies;
}
