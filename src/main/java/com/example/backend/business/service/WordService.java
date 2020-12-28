package com.example.backend.business.service;

import com.example.backend.business.entity.WordEntity;
import com.example.backend.web.dto.UserToWordDto;
import com.example.backend.web.dto.read.WordReadDto;

import java.util.List;
import java.util.UUID;

public interface WordService {
    List<WordEntity> getByIdNot(UUID id);
    List<WordEntity> getAll();
    WordReadDto getById(UUID uuid, Long id);
}
