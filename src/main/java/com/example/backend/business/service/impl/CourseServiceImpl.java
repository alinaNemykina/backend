package com.example.backend.business.service.impl;

import com.example.backend.business.dao.CourseRepository;
import com.example.backend.business.entity.CourseEntity;
import com.example.backend.business.entity.User2CourseProgressEntity;
import com.example.backend.business.service.CourseService;
import com.example.backend.business.service.User2CourseProgressService;
import com.example.backend.web.dto.mapper.CourseMapper;
import com.example.backend.web.dto.read.CourseReadDto;
import com.example.backend.web.dto.read.CourseTaskReadDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CourseServiceImpl implements CourseService {

    private final User2CourseProgressService user2CourseProgressService;
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseServiceImpl(User2CourseProgressService user2CourseProgressService, CourseRepository courseRepository, CourseMapper courseMapper) {
        this.user2CourseProgressService = user2CourseProgressService;
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    @Override
    public CourseTaskReadDto getById(Integer id, UUID userID) {
        User2CourseProgressEntity user2CourseProgressEntity = user2CourseProgressService.getCourseEntityByUserID(userID, id);
        return courseMapper.toReadDto(user2CourseProgressEntity.getCourse(), user2CourseProgressEntity.getStatus());
    }

    @Override
    public List<CourseReadDto> getAll() {
        return courseMapper.toReadDtos(courseRepository.findAll());
    }

    @Override
    public List<CourseEntity> getAllEntity() {
        return courseRepository.findAll();
    }

    @Override
    public List<CourseEntity> getByIdNot(UUID id) {
        List<Integer> listId = user2CourseProgressService.getIdCourseInStatusLearned(id);
        return listId.isEmpty() ? courseRepository.findAll() :
                courseRepository.findByIdNotIn(listId);
    }
}
