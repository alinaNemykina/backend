package com.example.backend.business.service.impl;


import com.example.backend.business.dao.WordEntityRepository;
import com.example.backend.business.entity.WordEntity;
import com.example.backend.business.service.User2WordStatusService;
import com.example.backend.business.service.WordService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WordServiceImpl implements WordService {

    private final User2WordStatusService user2WordStatusService;
    private final WordEntityRepository entityRepository;

    public WordServiceImpl(User2WordStatusService user2WordStatusService, WordEntityRepository entityRepository) {
        this.user2WordStatusService = user2WordStatusService;
        this.entityRepository = entityRepository;
    }


    @Override
    public List<WordEntity> getByIdNot(UUID id) {
        List<Long> listId = user2WordStatusService.getIdWordInStatusLearned(id);
        return listId.isEmpty() ? entityRepository.findAll() :
                entityRepository.findByIdNotIn(listId);
    }

    @Override
    public List<WordEntity> getAll() {
        return entityRepository.findAll();
    }
}
