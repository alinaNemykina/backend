package com.example.backend.business.service;

import com.example.backend.business.entity.WordEntity;
import com.example.backend.business.enums.StatusWordEnum;
import com.example.backend.web.dto.read.WordReadDto;
import com.example.backend.web.dto.update.VideoExerciseUpdateDto;
import com.example.backend.web.dto.update.WordStatusUpdateDto;

import java.util.List;
import java.util.UUID;

public interface User2WordStatusService {
    List<Long> getIdWordInStatusLearned(UUID id);
    StatusWordEnum save(UUID id, WordEntity wordEntity);
    List<WordReadDto> getAllForUser(UUID id);
    void setNewStatus(WordStatusUpdateDto wordStatusUpdateDto);
}
