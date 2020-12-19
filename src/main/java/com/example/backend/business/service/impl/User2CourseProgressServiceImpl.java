package com.example.backend.business.service.impl;

import com.example.backend.business.dao.User2CourseProgressRepository;
import com.example.backend.business.entity.CourseEntity;
import com.example.backend.business.entity.User2CourseProgressEntity;
import com.example.backend.business.enums.StatusCourseEnum;
import com.example.backend.business.service.User2CourseProgressService;
import com.example.backend.business.service.UserService;
import com.example.backend.web.dto.update.CourseStatusUpdateDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class User2CourseProgressServiceImpl implements User2CourseProgressService {

    private final User2CourseProgressRepository user2CourseProgressRepository;
    private final UserService userService;

    public User2CourseProgressServiceImpl(User2CourseProgressRepository user2CourseProgressRepository, UserService userService) {
        this.user2CourseProgressRepository = user2CourseProgressRepository;
        this.userService = userService;
    }

    @Override
    public List<Integer> getIdCourseInStatusLearned(UUID id) {
        return user2CourseProgressRepository.findAllByUserIdAndStatus(id, StatusCourseEnum.LEARNED).stream()
                .map(User2CourseProgressEntity::getCourse).map(CourseEntity::getId).collect(Collectors.toList());

    }

    @Override
    public StatusCourseEnum save(UUID id, CourseEntity courseEntity) {
        if (user2CourseProgressRepository.existsByUserIdAndCourseId(id, courseEntity.getId())){
            return user2CourseProgressRepository.findByUserIdAndCourseId(id, courseEntity.getId()).getStatus();
        } else {
            User2CourseProgressEntity user2CourseProgressEntity = new User2CourseProgressEntity();
            user2CourseProgressEntity.setProgress(0);
            user2CourseProgressEntity.setCourse(courseEntity);
            user2CourseProgressEntity.setStatus(StatusCourseEnum.LEARNING);
            user2CourseProgressEntity.setUser(userService.getById(id));
            user2CourseProgressRepository.save(user2CourseProgressEntity);
            return StatusCourseEnum.LEARNING;
        }

    }

    @Override
    public void setNewStatus(CourseStatusUpdateDto courseStatusUpdateDto) {
        User2CourseProgressEntity user2CourseProgressEntity =
                user2CourseProgressRepository.findByUserIdAndCourseId(courseStatusUpdateDto.getId(), courseStatusUpdateDto.getCourseId());
        user2CourseProgressEntity.setStatus(courseStatusUpdateDto.getStatusCourseEnum());
        user2CourseProgressRepository.save(user2CourseProgressEntity);
    }
}
