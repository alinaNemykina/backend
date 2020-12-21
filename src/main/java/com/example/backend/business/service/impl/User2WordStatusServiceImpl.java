package com.example.backend.business.service.impl;

import com.example.backend.business.dao.User2WordStatusRepository;
import com.example.backend.business.entity.User2WordStatusEntity;
import com.example.backend.business.entity.WordEntity;
import com.example.backend.business.enums.StatusWordEnum;
import com.example.backend.business.service.User2WordStatusService;
import com.example.backend.business.service.UserService;
import com.example.backend.web.dto.mapper.WordMapper;
import com.example.backend.web.dto.read.WordCountDto;
import com.example.backend.web.dto.read.WordReadDto;
import com.example.backend.web.dto.update.WordStatusUpdateDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class User2WordStatusServiceImpl implements User2WordStatusService {

    private final User2WordStatusRepository user2WordStatusRepository;
    private final UserService userService;
    private final WordMapper wordMapper;
    private Random random = new Random();

    public User2WordStatusServiceImpl(User2WordStatusRepository user2WordStatusRepository, UserService userService, WordMapper wordMapper) {
        this.user2WordStatusRepository = user2WordStatusRepository;
        this.userService = userService;
        this.wordMapper = wordMapper;
    }

    @Override
    public List<Long> getIdWordInStatusLearned(UUID id) {
        return user2WordStatusRepository.findAllByUserIdAndStatus(id, StatusWordEnum.LEARNED).stream()
                .map(User2WordStatusEntity::getWord).map(WordEntity::getId).collect(Collectors.toList());

    }

    @Override
    public StatusWordEnum save (UUID id, WordEntity wordEntity){
        if (user2WordStatusRepository.existsByUserIdAndWordId(id, wordEntity.getId())){
            return user2WordStatusRepository.findByUserIdAndWordId(id, wordEntity.getId()).getStatus();
        } else {
            User2WordStatusEntity user2WordStatusEntity = new User2WordStatusEntity();
            user2WordStatusEntity.setWord(wordEntity);
            user2WordStatusEntity.setStatus(StatusWordEnum.NEW);
            user2WordStatusEntity.setUser(userService.getById(id));
            user2WordStatusRepository.save(user2WordStatusEntity);
            return StatusWordEnum.NEW;
        }
    }

    @Override
    public List<WordReadDto> getAllForUser(UUID id) {
        List<WordReadDto> wordReadDtos = new ArrayList<>();
        user2WordStatusRepository.findAllByUserId(id).forEach(item -> {
                wordReadDtos.add(wordMapper.toReadDto(item.getWord(), item.getStatus()));
            }
        );
        return wordReadDtos;
    }

    @Override
    public WordReadDto getRandomWord(UUID id) {
        List<User2WordStatusEntity> wordEntitiesStatus = user2WordStatusRepository.findAllByUserId(id);
        List<WordEntity> wordEntities = new ArrayList<>();
        List<StatusWordEnum> statusWordEnums = new ArrayList<>();
        wordEntitiesStatus.forEach(item -> {
            if (item.getStatus() != StatusWordEnum.LEARNED){
                wordEntities.add(item.getWord());
                statusWordEnums.add(item.getStatus());
            }
        });

        if (!wordEntities.isEmpty()){
            int index = random.nextInt(wordEntities.size());
            WordEntity wordEntity = wordEntities.get(index);
            return wordMapper.toReadDto(wordEntity, statusWordEnums.get(index));
        } else {
          return wordMapper.toReadDto (wordEntitiesStatus
                  .get(random.nextInt(wordEntitiesStatus.size())).getWord(), StatusWordEnum.LEARNED);
        }
    }

    @Override
    public WordCountDto getWordCount(UUID id) {
       return wordMapper.getCount(user2WordStatusRepository.findAllByUserId(id));
    }

    @Override
    public void setNewStatus(WordStatusUpdateDto wordStatusUpdateDto) {
        User2WordStatusEntity user2WordStatusEntity = user2WordStatusRepository
                .findByUserIdAndWordId(wordStatusUpdateDto.getId(),wordStatusUpdateDto.getWordId());
        user2WordStatusEntity.setStatus(wordStatusUpdateDto.getStatus());
        user2WordStatusRepository.save(user2WordStatusEntity);
    }
}
