package com.example.backend.web.dto.create;

import lombok.Data;

import java.util.UUID;

@Data
public class AddWordSetCreateDto {
    private UUID id;
    private Long setId;
}
