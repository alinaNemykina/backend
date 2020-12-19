package com.example.backend.web.dto.update;

import com.example.backend.business.enums.StatusTaskEnum;
import lombok.Data;

import java.util.UUID;

@Data
public class TextExerciseStatusUpdateDto {
    private UUID id;
    private Long textId;
    private StatusTaskEnum statusTaskEnum;

}
