package com.example.backend.business.service;

import com.example.backend.business.entity.CourseEntity;

import java.util.List;

public interface CourseService {
    CourseEntity getById(Integer id);
    List<CourseEntity> getAll();
}
