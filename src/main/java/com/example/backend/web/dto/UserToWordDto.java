package com.example.backend.web.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UserToWordDto {
    private UUID id;
    private Long wordId;
}
