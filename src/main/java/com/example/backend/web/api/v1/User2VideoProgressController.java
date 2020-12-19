package com.example.backend.web.api.v1;


import com.example.backend.business.service.User2VideoProgressService;
import com.example.backend.web.dto.update.VideoExerciseUpdateDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.backend.utils.ApiConstantUtils.USER2VIDEO;

@RestController
@RequestMapping(USER2VIDEO)
public class User2VideoProgressController {

    private final User2VideoProgressService user2VideoProgressService;

    public User2VideoProgressController(User2VideoProgressService user2VideoProgressService) {
        this.user2VideoProgressService = user2VideoProgressService;
    }

    @PostMapping
    public void setStatus(@RequestBody VideoExerciseUpdateDto dto){
        user2VideoProgressService.setNewStatus(dto);
    }
}
