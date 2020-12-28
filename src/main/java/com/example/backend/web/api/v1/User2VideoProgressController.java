package com.example.backend.web.api.v1;


import com.example.backend.business.service.User2VideoProgressService;
import com.example.backend.web.dto.read.VideoExerciseReadDto;
import com.example.backend.web.dto.update.VideoExerciseUpdateDto;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.example.backend.utils.ApiConstantUtils.USER2VIDEO;

@RestController
@RequestMapping(USER2VIDEO)
public class User2VideoProgressController {

    private final User2VideoProgressService user2VideoProgressService;

    public User2VideoProgressController(User2VideoProgressService user2VideoProgressService) {
        this.user2VideoProgressService = user2VideoProgressService;
    }

    @GetMapping("/{uuid}/{id}")
    public VideoExerciseReadDto getByUserId(@PathVariable UUID uuid, @PathVariable Long id){
        return user2VideoProgressService.getByUserId(uuid, id);
    }

    @PostMapping
    public void setStatus(@RequestBody VideoExerciseUpdateDto dto){
        user2VideoProgressService.setNewStatus(dto);
    }
}
