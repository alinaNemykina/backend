package com.example.backend.web.dto.read;

import com.example.backend.business.enums.StatusCourseEnum;
import lombok.Data;

@Data
public class CourseReadDto {
    private Long id;
    private String name;
    private String theory;
    private Integer cookies;
    private String category;
    private String subcategory;

}
