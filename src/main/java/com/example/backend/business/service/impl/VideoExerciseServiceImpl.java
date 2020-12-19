package com.example.backend.business.service.impl;


import com.example.backend.business.dao.VideoExerciseRepository;
import com.example.backend.business.entity.VideoExerciseEntity;
import com.example.backend.business.service.User2VideoProgressService;
import com.example.backend.business.service.VideoExerciseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VideoExerciseServiceImpl implements VideoExerciseService {
    private final VideoExerciseRepository videoExerciseRepository;
    private final User2VideoProgressService user2VideoProgressService;

    public VideoExerciseServiceImpl(VideoExerciseRepository videoExerciseRepository, User2VideoProgressService user2VideoProgressService) {
        this.videoExerciseRepository = videoExerciseRepository;
        this.user2VideoProgressService = user2VideoProgressService;
    }


    @Override
    public List<VideoExerciseEntity> getByIdNot(UUID id) {
        List<Long> listId = user2VideoProgressService.getIdVideoInStatusLearned(id);
        return listId.isEmpty() ? videoExerciseRepository.findAll() :
                videoExerciseRepository.findByIdNotIn(listId);
    }

    @Override
    public List<VideoExerciseEntity> getAll(){
        return videoExerciseRepository.findAll();
    }


}
