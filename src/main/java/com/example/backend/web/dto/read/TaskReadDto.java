package com.example.backend.web.dto.read;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class TaskReadDto {
    CourseTaskReadDto courseTaskReadDto;
    TextExerciseReadDto textExerciseReadDto;
    WordReadDto wordReadDto;
    VideoExerciseReadDto videoExerciseReadDto;
}
