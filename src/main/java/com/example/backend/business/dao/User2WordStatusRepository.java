package com.example.backend.business.dao;


import com.example.backend.business.entity.User2WordStatusEntity;
import com.example.backend.business.enums.StatusWordEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface User2WordStatusRepository extends JpaRepository<User2WordStatusEntity, Long> {
    List<User2WordStatusEntity> findAllByUserIdAndStatus(UUID userId, StatusWordEnum status);
    User2WordStatusEntity findByUserIdAndWordId(UUID userId, Long wordId);
    Boolean existsByUserIdAndWordId(UUID userId, Long wordId);
    List<User2WordStatusEntity> findAllByUserId(UUID userId);

}
