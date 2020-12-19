package com.example.backend.web.dto.read;

import lombok.Data;

import java.util.List;

@Data
public class TaskReadDto {
    CourseTaskReadDto courseTaskReadDto;
    TextExerciseReadDto textExerciseReadDto;
    WordReadDto wordReadDto;
    VideoExerciseReadDto videoExerciseReadDto;
}
