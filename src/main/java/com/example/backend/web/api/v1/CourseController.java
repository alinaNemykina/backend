package com.example.backend.web.api.v1;

import com.example.backend.business.entity.CourseEntity;
import com.example.backend.business.service.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.backend.utils.ApiConstantUtils.ALL;
import static com.example.backend.utils.ApiConstantUtils.COURSE;

@RestController
@RequestMapping(COURSE)
public class CourseController {

    private final CourseService courseService;


    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/{id}")
    public CourseEntity findById(@PathVariable Integer id) {
        return courseService.getById(id);
    }

    @GetMapping(ALL)
    public List<CourseEntity> getAll() {
        return courseService.getAll();
    }
}
