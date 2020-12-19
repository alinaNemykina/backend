package com.example.backend.business.service;

import com.example.backend.web.dto.read.TaskReadDto;

import java.util.UUID;

public interface TaskService {
     TaskReadDto getById(UUID id);
//    List<TaskEntity> getAll();
}
