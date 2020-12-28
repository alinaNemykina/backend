package com.example.backend.business.service.impl;


import com.example.backend.business.dao.WordEntityRepository;
import com.example.backend.business.entity.User2WordStatusEntity;
import com.example.backend.business.entity.WordEntity;
import com.example.backend.business.service.User2WordStatusService;
import com.example.backend.business.service.WordService;
import com.example.backend.web.dto.UserToWordDto;
import com.example.backend.web.dto.mapper.WordMapper;
import com.example.backend.web.dto.read.WordReadDto;
import com.example.backend.web.error.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WordServiceImpl implements WordService {

    private final User2WordStatusService user2WordStatusService;
    private final WordEntityRepository entityRepository;
    private final WordMapper wordMapper;

    public WordServiceImpl(User2WordStatusService user2WordStatusService, WordEntityRepository entityRepository, WordMapper wordMapper) {
        this.user2WordStatusService = user2WordStatusService;
        this.entityRepository = entityRepository;
        this.wordMapper = wordMapper;
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

    @Override
    public WordReadDto getById(UUID uuid, Long id) {
        User2WordStatusEntity user2WordStatusEntity = user2WordStatusService.getWordEntityByUserIdAndWordId(uuid, id);
        return wordMapper.toReadDto(user2WordStatusEntity.getWord(), user2WordStatusEntity.getStatus());
    }
}
