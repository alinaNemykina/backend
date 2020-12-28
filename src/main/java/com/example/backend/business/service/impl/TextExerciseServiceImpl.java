package com.example.backend.business.service.impl;

import com.example.backend.business.dao.TextExerciseRepository;
import com.example.backend.business.entity.TextExerciseEntity;
import com.example.backend.business.service.TextExerciseService;
import com.example.backend.business.service.User2TextProgressService;
import com.example.backend.web.dto.mapper.TextExerciseMapper;
import com.example.backend.web.dto.read.TextExerciseReadDto;
import com.example.backend.web.error.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TextExerciseServiceImpl implements TextExerciseService{
    private final TextExerciseRepository textExerciseRepository;
    private final User2TextProgressService user2TextProgressService;
    private final TextExerciseMapper textExerciseMapper;

    public TextExerciseServiceImpl(TextExerciseRepository textExerciseRepository, User2TextProgressService user2TextProgressService, TextExerciseMapper textExerciseMapper) {
        this.textExerciseRepository = textExerciseRepository;
        this.user2TextProgressService = user2TextProgressService;
        this.textExerciseMapper = textExerciseMapper;
    }

    @Override
    public List<TextExerciseEntity> getByIdNot(UUID id) {
        List<Long> listId = user2TextProgressService.getIdTextInStatusLearned(id);
        return listId.isEmpty() ? textExerciseRepository.findAll() :
                textExerciseRepository.findByIdNotIn(listId);
    }

    @Override
    public List<TextExerciseEntity> getAll() {
        return textExerciseRepository.findAll();
    }

    @Override
    public TextExerciseReadDto getById(Long id) {
        TextExerciseEntity textExerciseEntity = textExerciseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return textExerciseMapper.toReadDto(textExerciseEntity);
    }
}
