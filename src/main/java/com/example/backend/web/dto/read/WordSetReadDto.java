package com.example.backend.web.dto.read;

import com.example.backend.business.entity.WordEntity;
import lombok.Data;

import java.util.List;

@Data
public class WordSetReadDto {
    private Long id;
    private List<WordEntity> words;
    private String name;
    private String imagePathUri;
}
