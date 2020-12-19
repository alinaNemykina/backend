package com.example.backend.business.dao;

import com.example.backend.business.entity.CourseEntity;
import com.example.backend.business.entity.WordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordEntityRepository extends JpaRepository<WordEntity, Long> {
    List<WordEntity> findByIdNotIn(List<Long> id);
}
