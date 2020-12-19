package com.example.backend.business.service;

import com.example.backend.business.entity.WordEntity;

import java.util.List;
import java.util.UUID;

public interface WordService {
    List<WordEntity> getByIdNot(UUID id);
    List<WordEntity> getAll();
}
