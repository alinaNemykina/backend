package com.example.backend.web.dto.read;

import com.example.backend.business.enums.StatusTaskEnum;
import lombok.Data;

@Data
public class VideoExerciseReadDto {
    private Long id;
    private String name;
    private String videoUrl;
    private Integer cookies;
    private StatusTaskEnum status;
    private String imagePath;
    private String explanation;
    private String title;
}
