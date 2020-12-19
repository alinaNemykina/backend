package com.example.backend.web.dto.update;

import com.example.backend.business.enums.StatusCourseEnum;
import lombok.Data;

import java.util.UUID;

@Data
public class CourseStatusUpdateDto {
    private UUID id;
    private Integer courseId;
    private StatusCourseEnum statusCourseEnum;
}
