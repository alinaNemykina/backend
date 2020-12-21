package com.example.backend.web.api.v1;

import com.example.backend.business.entity.UserEntity;
import com.example.backend.business.service.UserService;
import com.example.backend.web.dto.create.CreateUserDto;
import com.example.backend.web.dto.update.UserUpdateDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.UUID;

import static com.example.backend.utils.ApiConstantUtils.USER;

@RestController
@RequestMapping(USER)
@Slf4j
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserEntity findById(@PathVariable UUID id){
        return userService.getById(id);
    }


    @PostMapping
    public ResponseEntity<Object> register(@RequestBody CreateUserDto user) {
        log.info("register controller");
        return ResponseEntity.ok(userService.register(user));
    }

    @PutMapping
    public ResponseEntity<Object> update(@Valid @RequestBody UserUpdateDto userDto){
        userService.update(userDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all_user_count")
    public Long getCount(){
        return userService.getUserCount();
    }

}