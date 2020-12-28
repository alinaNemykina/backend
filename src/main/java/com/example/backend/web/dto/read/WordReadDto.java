package com.example.backend.web.dto.read;

import com.example.backend.business.enums.StatusWordEnum;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Data
public class WordReadDto {
    private Long id;
    private String original;
    private String translation;
    private StatusWordEnum status;
    private String name;
    private String imagePath;
    private String explanation;
    private String title;
}
