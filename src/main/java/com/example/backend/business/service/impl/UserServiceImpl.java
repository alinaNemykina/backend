package com.example.backend.business.service.impl;

import com.example.backend.business.entity.UserEntity;
import com.example.backend.business.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private List<UserEntity> init() {
        List<UserEntity> userEntities = new ArrayList<>();
        userEntities.add(new UserEntity(1L, "firstuser", 0));
        userEntities.add(new UserEntity(2L, "seconduser", 0));
        userEntities.add(new UserEntity(3L, "thirduser", 0));
        return userEntities;
    }

    @Override
    public UserEntity getById(Long id) {
        return init().stream().filter(i -> i.getId().equals(id)).findFirst().get();
    }
}
