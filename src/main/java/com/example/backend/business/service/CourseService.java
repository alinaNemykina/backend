package com.example.backend.business.service;

import com.example.backend.business.entity.CourseEntity;
import com.example.backend.web.dto.read.CourseReadDto;
import com.example.backend.web.dto.read.CourseTaskReadDto;

import java.util.List;
import java.util.UUID;

public interface CourseService {
    CourseTaskReadDto getById(Integer id, UUID userID);
    List<CourseReadDto> getAll();
    List<CourseEntity> getAllEntity();
    List<CourseEntity> getByIdNot(UUID ids);
}
