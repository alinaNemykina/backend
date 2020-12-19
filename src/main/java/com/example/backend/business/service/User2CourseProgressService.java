package com.example.backend.business.service;


import com.example.backend.business.entity.CourseEntity;
import com.example.backend.business.enums.StatusCourseEnum;
import com.example.backend.web.dto.update.CourseStatusUpdateDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface User2CourseProgressService {
    List<Integer> getIdCourseInStatusLearned(UUID id);
    StatusCourseEnum save(UUID id, CourseEntity courseEntity);
    void setNewStatus(CourseStatusUpdateDto courseStatusUpdateDto);
}
