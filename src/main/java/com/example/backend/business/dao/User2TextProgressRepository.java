package com.example.backend.business.dao;


import com.example.backend.business.entity.User2CourseProgressEntity;
import com.example.backend.business.entity.User2TextProgressEntity;
import com.example.backend.business.entity.User2VideoProgressEntity;
import com.example.backend.business.enums.StatusTaskEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface User2TextProgressRepository extends JpaRepository<User2TextProgressEntity, Long> {
    List<User2TextProgressEntity> findAllByUserIdAndStatus(UUID userId, StatusTaskEnum status);
    User2TextProgressEntity findByUserIdAndTextExerciseId(UUID userId, Long textExerciseId);
    Boolean existsByUserIdAndTextExerciseId(UUID userId, Long textExerciseId);
}
