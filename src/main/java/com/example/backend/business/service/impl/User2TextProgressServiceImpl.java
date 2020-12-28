package com.example.backend.business.service.impl;

import com.example.backend.business.dao.User2TextProgressRepository;
import com.example.backend.business.entity.TextExerciseEntity;
import com.example.backend.business.entity.User2TextProgressEntity;
import com.example.backend.business.entity.UserEntity;
import com.example.backend.business.enums.StatusTaskEnum;
import com.example.backend.business.service.User2TextProgressService;
import com.example.backend.business.service.UserService;
import com.example.backend.web.dto.update.TextExerciseStatusUpdateDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class User2TextProgressServiceImpl implements User2TextProgressService {

    private final User2TextProgressRepository user2TextProgressRepository;
    private final UserService userService;

    public User2TextProgressServiceImpl(User2TextProgressRepository user2TextProgressRepository, UserService userService) {
        this.user2TextProgressRepository = user2TextProgressRepository;
        this.userService = userService;
    }

    @Override
    public List<Long> getIdTextInStatusLearned(UUID id) {
        return user2TextProgressRepository.findAllByUserIdAndStatus(id, StatusTaskEnum.LEARNED).stream()
                .map(User2TextProgressEntity::getTextExercise).map(TextExerciseEntity::getId).collect(Collectors.toList());
    }

    @Override
    public void save (UUID id, TextExerciseEntity textExerciseEntity){
        if (!user2TextProgressRepository.existsByUserIdAndTextExerciseId(id, textExerciseEntity.getId())) {
            User2TextProgressEntity user2TextProgressEntity = new User2TextProgressEntity();
            user2TextProgressEntity.setProgress(0);
            user2TextProgressEntity.setStatus(StatusTaskEnum.LEARNING);
            user2TextProgressEntity.setTextExercise(textExerciseEntity);
            user2TextProgressEntity.setUser(userService.getById(id));
            user2TextProgressRepository.save(user2TextProgressEntity);
        }
    }

    @Override
    public void setNewStatus(TextExerciseStatusUpdateDto textExerciseStatusUpdateDto) {
        User2TextProgressEntity user2TextProgressEntity
                = user2TextProgressRepository.findByUserIdAndTextExerciseId(textExerciseStatusUpdateDto.getId(), textExerciseStatusUpdateDto.getTextId());
        user2TextProgressEntity.setStatus(textExerciseStatusUpdateDto.getStatusTaskEnum());
        UserEntity user = user2TextProgressEntity.getUser();
        TextExerciseEntity textExerciseEntity = user2TextProgressEntity.getTextExercise();
        user.setBalanceOfCookies(user.getBalanceOfCookies() + textExerciseEntity.getCookies());
        user2TextProgressRepository.save(user2TextProgressEntity);
    }
}
