package com.example.backend.business.service;

import com.example.backend.business.entity.TextExerciseEntity;
import com.example.backend.business.entity.VideoExerciseEntity;
import com.example.backend.web.dto.update.CourseStatusUpdateDto;
import com.example.backend.web.dto.update.TextExerciseStatusUpdateDto;

import java.util.List;
import java.util.UUID;

public interface User2TextProgressService {
    List<Long> getIdTextInStatusLearned(UUID id);
    void save (UUID id, TextExerciseEntity textExerciseEntity);
    void setNewStatus(TextExerciseStatusUpdateDto textExerciseStatusUpdateDto);
}
