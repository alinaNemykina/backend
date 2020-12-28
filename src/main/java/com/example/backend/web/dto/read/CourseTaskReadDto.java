package com.example.backend.web.dto.read;

import com.example.backend.business.enums.StatusCourseEnum;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class CourseTaskReadDto {
    private Long id;
    StatusCourseEnum status;
    String theory;
    Integer cookies;
    String name;
    String imagePath;
    String explanation;
    String title;
}
