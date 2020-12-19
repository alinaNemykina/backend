package com.example.backend.business.service.impl;

import com.example.backend.business.dao.TextExerciseRepository;
import com.example.backend.business.entity.TextExerciseEntity;
import com.example.backend.business.service.TextExerciseService;
import com.example.backend.business.service.User2TextProgressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TextExerciseServiceImpl implements TextExerciseService{
    private final TextExerciseRepository textExerciseRepository;
    private final User2TextProgressService user2TextProgressService;

    public TextExerciseServiceImpl(TextExerciseRepository textExerciseRepository, User2TextProgressService user2TextProgressService) {
        this.textExerciseRepository = textExerciseRepository;
        this.user2TextProgressService = user2TextProgressService;
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
}
