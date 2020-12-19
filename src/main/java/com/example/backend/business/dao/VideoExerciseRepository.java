package com.example.backend.business.dao;

import com.example.backend.business.entity.VideoExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoExerciseRepository extends JpaRepository<VideoExerciseEntity, Long> {
    List<VideoExerciseEntity> findByIdNotIn(List<Long> id);

}
