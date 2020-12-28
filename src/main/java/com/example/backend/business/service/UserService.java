package com.example.backend.business.service;

import com.example.backend.business.entity.AuthorityEntity;
import com.example.backend.business.entity.UserEntity;
import com.example.backend.business.enums.AuthorityEnum;
import com.example.backend.web.dto.create.CreateUserDto;
import com.example.backend.web.dto.read.UserReadDto;
import com.example.backend.web.dto.update.UserUpdateDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import java.util.Map;
import java.util.UUID;

public interface UserService extends UserDetailsService {
    UserEntity getById(UUID id);

    UserReadDto getDtoById(UUID id);

    UserEntity findByEmail(String email);

    UUID register(CreateUserDto newUser);

    UserEntity saveForRegister(UserEntity user);

    UserEntity save(UserEntity user);

    AuthorityEntity findAuthorityByName(AuthorityEnum authority);

    void update(UserUpdateDto userDto);


    Map<String, Object> getAdditionInformation(OAuth2Authentication auth);

    void checkResolution(UUID id);

    Long getUserCount();


}
