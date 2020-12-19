package com.example.backend.web.dto.update;

import com.example.backend.business.enums.StatusTaskEnum;
import lombok.Data;

import java.util.UUID;

@Data
public class VideoExerciseUpdateDto {
    private UUID id;
    private Long videoId;
    private StatusTaskEnum statusTaskEnum;
}
