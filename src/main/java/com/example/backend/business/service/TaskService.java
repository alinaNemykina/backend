package com.example.backend.business.service;

import com.example.backend.business.entity.TaskEntity;

import java.util.List;

public interface TaskService {
    TaskEntity getById(Long id);
    List<TaskEntity> getAll();
}
