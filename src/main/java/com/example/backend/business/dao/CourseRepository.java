package com.example.backend.business.dao;

import com.example.backend.business.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {
    List<CourseEntity> findByIdNotIn(List<Integer> id);
}
