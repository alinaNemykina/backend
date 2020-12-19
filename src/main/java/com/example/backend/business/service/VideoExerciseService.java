package com.example.backend.business.service;

import com.example.backend.business.entity.VideoExerciseEntity;

import java.util.List;
import java.util.UUID;

public interface VideoExerciseService {
    List<VideoExerciseEntity> getByIdNot(UUID ids);
    List<VideoExerciseEntity> getAll();
}
