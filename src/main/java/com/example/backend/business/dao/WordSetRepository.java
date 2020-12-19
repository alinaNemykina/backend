package com.example.backend.business.dao;

import com.example.backend.business.entity.WordSetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordSetRepository extends JpaRepository<WordSetEntity, Long> {
}
