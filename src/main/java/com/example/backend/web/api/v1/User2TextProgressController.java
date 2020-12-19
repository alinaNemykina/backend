package com.example.backend.web.api.v1;


import com.example.backend.business.service.User2TextProgressService;
import com.example.backend.web.dto.update.TextExerciseStatusUpdateDto;
import com.example.backend.web.dto.update.WordStatusUpdateDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.backend.utils.ApiConstantUtils.USER2TEXT;

@RestController
@RequestMapping(USER2TEXT)
public class User2TextProgressController {

    private final User2TextProgressService user2TextProgressService;

    public User2TextProgressController(User2TextProgressService user2TextProgressService) {
        this.user2TextProgressService = user2TextProgressService;
    }

    @PostMapping
    public void setStatus(@RequestBody TextExerciseStatusUpdateDto dto){
        user2TextProgressService.setNewStatus(dto);
    }
}
