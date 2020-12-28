package com.example.backend.web.api;

import com.example.backend.business.service.UserService;
import com.example.backend.web.dto.create.CreateUserDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("api/register")
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UUID register(@RequestBody CreateUserDto user) {
        return userService.register(user);
    }
}
