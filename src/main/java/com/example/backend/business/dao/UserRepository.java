package com.example.backend.business.dao;

import com.example.backend.business.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaSpecificationExecutor<UserEntity>, JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByUsername(String userName);
    Optional<UserEntity> findByEmail(String email);
    List<UserEntity> findAllByEnabledTrue();
}

