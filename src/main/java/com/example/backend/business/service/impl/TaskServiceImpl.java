package com.example.backend.business.service.impl;

import com.example.backend.business.entity.TaskEntity;
import com.example.backend.business.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private List<TaskEntity> init() {
        List<TaskEntity> taskEntities = new ArrayList<>();
        taskEntities.add(new TaskEntity(1L, "Present Simple", "Прокачаем грамматику?", "img/grammar.png", "Много грамматики не бывает!"));
        taskEntities.add(new TaskEntity(2L, "Перевод-слово", "Слабо отгадать все слова?", "img/translation_.jpeg", "Давай попробуем вместе!"));
        taskEntities.add(new TaskEntity(3L, "Good friends are like stars.", "Читай скорее текст!", "img/reading.jpeg", "И добавляй слова"));
        return taskEntities;
    }

    @Override
    public TaskEntity getById(Long id) {
        return init().stream().filter(i -> i.getId().equals(id)).findFirst().get();
    }

    @Override
    public List<TaskEntity> getAll() {
        return init();
    }
}
