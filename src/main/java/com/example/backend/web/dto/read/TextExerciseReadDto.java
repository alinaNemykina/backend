package com.example.backend.web.dto.read;

import com.example.backend.business.enums.StatusTaskEnum;
import lombok.Data;

@Data
public class TextExerciseReadDto {
    private Long id;
    private String name;
    private String text;
    private Integer cookies;
    private StatusTaskEnum status;
    private String imagePath;
    private String explanation;
    private String title;
}
