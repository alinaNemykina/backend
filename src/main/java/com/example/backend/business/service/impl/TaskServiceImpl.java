package com.example.backend.business.service.impl;

import com.example.backend.business.entity.CourseEntity;
import com.example.backend.business.entity.TextExerciseEntity;
import com.example.backend.business.entity.VideoExerciseEntity;
import com.example.backend.business.entity.WordEntity;
import com.example.backend.business.enums.StatusCourseEnum;
import com.example.backend.business.enums.StatusWordEnum;
import com.example.backend.business.service.*;
import com.example.backend.web.dto.mapper.CourseMapper;
import com.example.backend.web.dto.mapper.TextExerciseMapper;
import com.example.backend.web.dto.mapper.VideoExerciseMapper;
import com.example.backend.web.dto.mapper.WordMapper;
import com.example.backend.web.dto.read.TaskReadDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    private final VideoExerciseService videoExerciseService;
    private final TextExerciseService textExerciseService;
    private final CourseService courseService;
    private final WordService wordService;
    private final User2WordStatusService user2WordStatusService;
    private final User2CourseProgressService user2CourseProgressService;
    private final User2TextProgressService user2TextProgressService;
    private final User2VideoProgressService user2VideoProgressService;
    private final CourseMapper courseMapper;
    private final TextExerciseMapper textExerciseMapper;
    private final VideoExerciseMapper videoExerciseMapper;
    private final WordMapper wordMapper;

    private Random random = new Random();

    public TaskServiceImpl(VideoExerciseService videoExerciseService, TextExerciseService textExerciseService, CourseService courseService, WordService wordService, User2WordStatusService user2WordStatusService, User2CourseProgressService user2CourseProgressService, User2TextProgressService user2TextProgressService, User2VideoProgressService user2VideoProgressService, CourseMapper courseMapper, TextExerciseMapper textExerciseMapper, VideoExerciseMapper videoExerciseMapper, WordMapper wordMapper) {
        this.videoExerciseService = videoExerciseService;
        this.textExerciseService = textExerciseService;
        this.courseService = courseService;
        this.wordService = wordService;
        this.user2WordStatusService = user2WordStatusService;
        this.user2CourseProgressService = user2CourseProgressService;
        this.user2TextProgressService = user2TextProgressService;
        this.user2VideoProgressService = user2VideoProgressService;
        this.courseMapper = courseMapper;
        this.textExerciseMapper = textExerciseMapper;
        this.videoExerciseMapper = videoExerciseMapper;
        this.wordMapper = wordMapper;
    }

    @Override
    public TaskReadDto getById(UUID id) {
        TaskReadDto dto = new TaskReadDto();

        List<VideoExerciseEntity> videoExerciseEntities = videoExerciseService.getByIdNot(id);
        List<TextExerciseEntity> textExerciseEntities = textExerciseService.getByIdNot(id);
        List<CourseEntity> courseEntities = courseService.getByIdNot(id);
        List<WordEntity> wordEntities = wordService.getByIdNot(id);

        if (videoExerciseEntities.isEmpty()){
            videoExerciseEntities = videoExerciseService.getAll();
        }
        if (textExerciseEntities.isEmpty()){
            textExerciseEntities = textExerciseService.getAll();
        }
        if (courseEntities.isEmpty()){
            courseEntities = courseService.getAllEntity();
        }
        if (wordEntities.isEmpty()){
            wordEntities = wordService.getAll();
        }


        VideoExerciseEntity videoExerciseEntity = videoExerciseEntities.get(random.nextInt(videoExerciseEntities.size()));
        TextExerciseEntity textExerciseEntity = textExerciseEntities.get(random.nextInt(textExerciseEntities.size()));
        CourseEntity courseEntity = courseEntities.get(random.nextInt(courseEntities.size()));
        WordEntity wordEntity = wordEntities.get(random.nextInt(wordEntities.size()));

        user2VideoProgressService.save(id, videoExerciseEntity);
        StatusCourseEnum statusCourseEnum = user2CourseProgressService.save(id, courseEntity);
        user2TextProgressService.save(id, textExerciseEntity);
        StatusWordEnum statusWordEnum = user2WordStatusService.save(id, wordEntity);

        dto.setCourseTaskReadDto(courseMapper.toReadDto(courseEntity, statusCourseEnum));
        dto.setTextExerciseReadDto(textExerciseMapper.toReadDto(textExerciseEntity));
        dto.setVideoExerciseReadDto(videoExerciseMapper.toReadDto(videoExerciseEntity));
        dto.setWordReadDto(wordMapper.toReadDto(wordEntity, statusWordEnum));

        return dto;
    }


}
