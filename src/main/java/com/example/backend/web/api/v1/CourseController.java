package com.example.backend.web.api.v1;

import com.example.backend.business.entity.CourseEntity;
import com.example.backend.business.service.CourseService;
import com.example.backend.web.dto.read.CourseReadDto;
import com.example.backend.web.dto.read.CourseTaskReadDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static com.example.backend.utils.ApiConstantUtils.ALL;
import static com.example.backend.utils.ApiConstantUtils.COURSE;

@RestController
@RequestMapping(COURSE)
public class CourseController {

    private final CourseService courseService;


    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/{id}/{userId}")
    public CourseTaskReadDto findById(@PathVariable Integer id, @PathVariable UUID userId) {
        return courseService.getById(id, userId);
    }

    @GetMapping(ALL)
    public List<CourseReadDto> getAll() {
        return courseService.getAll();
    }
}
