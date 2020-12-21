package com.example.backend.web.api.v1;


import com.example.backend.business.service.User2WordStatusService;
import com.example.backend.web.dto.read.WordCountDto;
import com.example.backend.web.dto.read.WordReadDto;
import com.example.backend.web.dto.update.WordStatusUpdateDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.example.backend.utils.ApiConstantUtils.USER2WORD;

@RestController
@RequestMapping(USER2WORD)
public class User2WordStatusController {

    private final User2WordStatusService user2WordStatusService;

    public User2WordStatusController(User2WordStatusService user2WordStatusService) {
        this.user2WordStatusService = user2WordStatusService;
    }

    @GetMapping("/{id}")
    public List<WordReadDto> getAllWord(@PathVariable UUID id){
        return user2WordStatusService.getAllForUser(id);
    }

    @GetMapping("/learning/{id}")
    public WordReadDto learningWord(@PathVariable UUID id){
        return user2WordStatusService.getRandomWord(id);
    }

    @GetMapping("/count/{id}")
    public WordCountDto countWord(@PathVariable UUID id){
        return user2WordStatusService.getWordCount(id);
    }

    @PostMapping
    public void setStatus(@RequestBody WordStatusUpdateDto dto){
        user2WordStatusService.setNewStatus(dto);
    }
}
