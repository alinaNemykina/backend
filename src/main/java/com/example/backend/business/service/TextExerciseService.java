package com.example.backend.business.service;

import com.example.backend.business.entity.TextExerciseEntity;

import java.util.List;
import java.util.UUID;

public interface TextExerciseService {
    List<TextExerciseEntity> getByIdNot(UUID ids);
    List<TextExerciseEntity> getAll();
}
