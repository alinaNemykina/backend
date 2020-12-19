package com.example.backend.business.service.impl;


import com.example.backend.business.dao.User2WordStatusRepository;
import com.example.backend.business.dao.WordSetRepository;
import com.example.backend.business.entity.User2WordStatusEntity;
import com.example.backend.business.entity.UserEntity;
import com.example.backend.business.entity.WordSetEntity;
import com.example.backend.business.enums.StatusWordEnum;
import com.example.backend.business.service.User2WordStatusService;
import com.example.backend.business.service.UserService;
import com.example.backend.business.service.WordSetService;
import com.example.backend.web.dto.create.AddWordSetCreateDto;
import com.example.backend.web.dto.mapper.WordSetMapper;
import com.example.backend.web.dto.read.WordSetReadDto;
import com.example.backend.web.error.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordSetServiceImpl implements WordSetService {

    private final User2WordStatusService user2WordStatusService;
    private final User2WordStatusRepository user2WordStatusRepository;
    private final WordSetRepository wordSetRepository;
    private final WordSetMapper wordSetMapper;
    private final UserService userService;

    public WordSetServiceImpl(User2WordStatusService user2WordStatusService, User2WordStatusRepository user2WordStatusRepository, WordSetRepository wordSetRepository, WordSetMapper wordSetMapper, UserService userService) {
        this.user2WordStatusService = user2WordStatusService;
        this.user2WordStatusRepository = user2WordStatusRepository;
        this.wordSetRepository = wordSetRepository;
        this.wordSetMapper = wordSetMapper;
        this.userService = userService;
    }

    @Override
    public List<WordSetReadDto> getAll() {
        return wordSetMapper.toReadDtos(wordSetRepository.findAll());
    }

    @Override
    public void addWordSet(AddWordSetCreateDto dto) {
        UserEntity userEntity = userService.getById(dto.getId());
        WordSetEntity wordSetEntity = wordSetRepository
                .findById(dto.getSetId()).orElseThrow(() -> new ResourceNotFoundException("User"));
        userEntity.getWordSets().add(wordSetEntity);
        wordSetEntity.getWords().forEach(w -> {
            if (!user2WordStatusRepository.existsByUserIdAndWordId(dto.getId(), w.getId())){
                User2WordStatusEntity user2WordStatusEntity = new User2WordStatusEntity();
                user2WordStatusEntity.setStatus(StatusWordEnum.NEW);
                user2WordStatusEntity.setUser(userEntity);
                user2WordStatusEntity.setWord(w);
                user2WordStatusRepository.save(user2WordStatusEntity);
            }
        });
    }
}
