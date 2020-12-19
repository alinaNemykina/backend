package com.example.backend.business.dao;

import com.example.backend.business.entity.User2CourseProgressEntity;
import com.example.backend.business.entity.User2TextProgressEntity;
import com.example.backend.business.enums.StatusCourseEnum;
import com.example.backend.business.enums.StatusTaskEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface User2CourseProgressRepository extends JpaRepository<User2CourseProgressEntity, Long> {
    List<User2CourseProgressEntity> findAllByUserIdAndStatus(UUID userId, StatusCourseEnum status);
    User2CourseProgressEntity findByUserIdAndCourseId(UUID userId, Integer courseId);
    Boolean existsByUserIdAndCourseId(UUID userId, Integer courseId);
}
