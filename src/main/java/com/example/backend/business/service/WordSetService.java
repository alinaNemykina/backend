package com.example.backend.business.service;

import com.example.backend.web.dto.create.AddWordSetCreateDto;
import com.example.backend.web.dto.read.WordSetReadDto;

import java.util.List;

public interface WordSetService {
    List<WordSetReadDto> getAll();
    void addWordSet(AddWordSetCreateDto dto);
}
