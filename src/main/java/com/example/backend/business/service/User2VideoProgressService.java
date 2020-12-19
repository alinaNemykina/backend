package com.example.backend.business.service;

import com.example.backend.business.entity.VideoExerciseEntity;
import com.example.backend.web.dto.update.TextExerciseStatusUpdateDto;
import com.example.backend.web.dto.update.VideoExerciseUpdateDto;

import java.util.List;
import java.util.UUID;

public interface User2VideoProgressService {
    List<Long> getIdVideoInStatusLearned(UUID id);
    void save (UUID id, VideoExerciseEntity videoExerciseEntity);
    void setNewStatus(VideoExerciseUpdateDto videoExerciseUpdateDto);
}
