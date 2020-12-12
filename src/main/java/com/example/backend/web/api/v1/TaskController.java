package com.example.backend.web.api.v1;

import com.example.backend.business.entity.TaskEntity;
import com.example.backend.business.service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.backend.utils.ApiConstantUtils.ALL;
import static com.example.backend.utils.ApiConstantUtils.TASK;

@RestController
@RequestMapping(TASK)
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{id}")
    public TaskEntity findById(@PathVariable Long id){
        return taskService.getById(id);
    }

    @GetMapping(ALL)
    public List<TaskEntity> getAll(){
        return taskService.getAll();
    }
}
