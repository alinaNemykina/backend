package com.example.backend.web.api.v1;

import com.example.backend.business.service.TaskService;
import com.example.backend.web.dto.read.TaskReadDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static com.example.backend.utils.ApiConstantUtils.TASK;

@RestController
@RequestMapping(TASK)
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{id}")
    public TaskReadDto findById(@PathVariable UUID id){
        return taskService.getById(id);
    }

}
