package com.example.backend.business.service.impl;

import com.example.backend.business.dao.AuthorityRepository;
import com.example.backend.business.dao.UserRepository;
import com.example.backend.business.entity.AuthorityEntity;
import com.example.backend.business.entity.UserEntity;
import com.example.backend.business.enums.AuthorityEnum;
import com.example.backend.business.service.UserService;
import com.example.backend.web.dto.create.CreateUserDto;
import com.example.backend.web.dto.mapper.UserMapper;
import com.example.backend.web.dto.update.UserUpdateDto;
import com.example.backend.web.error.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AuthorityRepository authorityRepository;

    private static final PasswordEncoder PASSWORD_ENCODER = PasswordEncoderFactories.createDelegatingPasswordEncoder();


    @Override
    public UserEntity getById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public UserEntity loadUserByUsername(String userName) throws UsernameNotFoundException {
        return findByEmail(userName);
    }

    @Override
    public UserEntity findByEmail(String email) {
        log.info("Find user by email: {}", email);
        return userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User", email));
    }

    @Override
    public UserEntity saveForRegister(UserEntity user) {
        log.info("Save user: {}",user);
        user.setPassword(PASSWORD_ENCODER.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public UUID register(CreateUserDto newUser) {
        log.info("register service start new user: {}", newUser);
        UserEntity user = userMapper.toNewEntity(newUser);
        user.addAuthority(findAuthorityByName(newUser.getAuthority()));
        log.info("register service end");
        return saveForRegister(user).getId();

    }

    @Override
    public AuthorityEntity findAuthorityByName(AuthorityEnum authority) {
        log.info("Find authority by name:{}", authority.name());
        return authorityRepository.findAllByName(authority.name());
    }

    @Override
    public void update(UserUpdateDto userDto){
        UUID id = userDto.getId();
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));;
        userMapper.fromUpdateDto(userEntity, userDto);
        userRepository.save(userEntity);


    }

    @Override
    public Integer getCountUser() {
        return userRepository.findAll().size();
    }


}
