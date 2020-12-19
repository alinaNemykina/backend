package com.example.backend.web.api.v1;


import com.example.backend.business.service.User2CourseProgressService;
import com.example.backend.web.dto.update.CourseStatusUpdateDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.backend.utils.ApiConstantUtils.USER2COURSE;

@RestController
@RequestMapping(USER2COURSE)
public class User2CourseProgressController {

    private final User2CourseProgressService user2CourseProgressService;

    public User2CourseProgressController(User2CourseProgressService user2CourseProgressService) {
        this.user2CourseProgressService = user2CourseProgressService;
    }

    @PostMapping
    public void setStatus(@RequestBody CourseStatusUpdateDto dto){
        user2CourseProgressService.setNewStatus(dto);
    }
}
