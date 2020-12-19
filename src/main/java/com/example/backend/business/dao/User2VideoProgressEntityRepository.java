package com.example.backend.business.dao;


import com.example.backend.business.entity.User2VideoProgressEntity;
import com.example.backend.business.enums.StatusTaskEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface User2VideoProgressEntityRepository extends JpaRepository<User2VideoProgressEntity, Long> {
        List<User2VideoProgressEntity> findAllByUserIdAndStatus(UUID userId, StatusTaskEnum status);
        User2VideoProgressEntity findByUserIdAndVideoExerciseId(UUID userId, Long videoExerciseId);
        Boolean existsByUserIdAndVideoExerciseId(UUID userId, Long videoExerciseId);
}
