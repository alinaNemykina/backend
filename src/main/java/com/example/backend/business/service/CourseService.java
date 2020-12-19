package com.example.backend.business.service;

import com.example.backend.business.entity.CourseEntity;
import com.example.backend.business.entity.TextExerciseEntity;
import com.example.backend.web.dto.read.CourseReadDto;

import java.util.List;
import java.util.UUID;

public interface CourseService {
    CourseEntity getById(Integer id);
    List<CourseReadDto> getAll();
    List<CourseEntity> getByIdNot(UUID ids);
    List<CourseEntity> getAllEntities();
}
