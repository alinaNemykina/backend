package com.example.backend.business.service.impl;

import com.example.backend.business.dao.User2VideoProgressEntityRepository;
import com.example.backend.business.entity.User2VideoProgressEntity;
import com.example.backend.business.entity.VideoExerciseEntity;
import com.example.backend.business.enums.StatusTaskEnum;
import com.example.backend.business.service.User2VideoProgressService;
import com.example.backend.business.service.UserService;
import com.example.backend.web.dto.update.VideoExerciseUpdateDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class User2VideoProgressServiceImpl implements User2VideoProgressService {

    private final User2VideoProgressEntityRepository user2VideoProgressEntityRepository;
    private final UserService userService;

    public User2VideoProgressServiceImpl(User2VideoProgressEntityRepository user2VideoProgressEntityRepository, UserService userService) {
        this.user2VideoProgressEntityRepository = user2VideoProgressEntityRepository;
        this.userService = userService;
    }

    @Override
    public List<Long> getIdVideoInStatusLearned(UUID id) {
        return user2VideoProgressEntityRepository.findAllByUserIdAndStatus(id, StatusTaskEnum.LEARNED).stream()
                .map(User2VideoProgressEntity::getVideoExercise).map(VideoExerciseEntity::getId).collect(Collectors.toList());
    }

    @Override
    public void save(UUID id, VideoExerciseEntity videoExerciseEntity) {
        if (!user2VideoProgressEntityRepository.existsByUserIdAndVideoExerciseId(id, videoExerciseEntity.getId())) {
            User2VideoProgressEntity user2VideoProgressEntity = new User2VideoProgressEntity();
            user2VideoProgressEntity.setProgress(0);
            user2VideoProgressEntity.setStatus(StatusTaskEnum.LEARNING);
            user2VideoProgressEntity.setVideoExercise(videoExerciseEntity);
            user2VideoProgressEntity.setUser(userService.getById(id));
            user2VideoProgressEntityRepository.save(user2VideoProgressEntity);
        }
    }

    @Override
    public void setNewStatus(VideoExerciseUpdateDto videoExerciseUpdateDto) {
        User2VideoProgressEntity user2VideoProgressEntity =
                user2VideoProgressEntityRepository.findByUserIdAndVideoExerciseId(videoExerciseUpdateDto.getId(),
                        videoExerciseUpdateDto.getVideoId());
        user2VideoProgressEntity.setStatus(videoExerciseUpdateDto.getStatusTaskEnum());
        user2VideoProgressEntityRepository.save(user2VideoProgressEntity);
    }
}
