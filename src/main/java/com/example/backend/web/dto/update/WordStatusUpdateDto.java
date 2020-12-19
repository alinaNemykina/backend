package com.example.backend.web.dto.update;


import com.example.backend.business.enums.StatusWordEnum;
import lombok.Data;

import java.util.UUID;

@Data
public class WordStatusUpdateDto {
    private UUID id;
    private Long wordId;
    private StatusWordEnum status;
}
