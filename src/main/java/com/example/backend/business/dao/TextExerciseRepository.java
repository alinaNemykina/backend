package com.example.backend.business.dao;

import com.example.backend.business.entity.TextExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TextExerciseRepository extends JpaRepository<TextExerciseEntity, Long> {
    List<TextExerciseEntity> findByIdNotIn(List<Long> id);

}
