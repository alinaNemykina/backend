package com.example.backend.business.service.impl;

import com.example.backend.business.entity.CourseEntity;
import com.example.backend.business.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private List<CourseEntity> init() {
        List<CourseEntity> courseEntities = new ArrayList<>();
        courseEntities.add(new CourseEntity(1, "Для начинающего уровня", 6, "grammatical"));
        courseEntities.add(new CourseEntity(2, "Для среднего уровня", 4, "grammatical"));
        courseEntities.add(new CourseEntity(3, "Для продвинутого уровня", 4, "grammatical"));
        return courseEntities;
    }

    @Override
    public CourseEntity getById(Integer id) {
        return init().stream().filter(i -> i.getId().equals(id)).findFirst().get();
    }

    @Override
    public List<CourseEntity> getAll() {
        return init();
    }
}
