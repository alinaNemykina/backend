package com.example.backend.business.service;

import com.example.backend.business.entity.UserEntity;

public interface UserService {
    UserEntity getById(Long id);
}
