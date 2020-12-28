package com.example.backend.web.api.v1;

import com.example.backend.business.service.WordService;
import com.example.backend.web.dto.UserToWordDto;
import com.example.backend.web.dto.read.WordReadDto;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.example.backend.utils.ApiConstantUtils.WORD;

@RestController
@RequestMapping(WORD)
public class WordController {

    private final WordService wordService;

    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping("/{uuid}/{id}")
    public WordReadDto getWord(@PathVariable UUID uuid, @PathVariable Long id) {
        return wordService.getById(uuid, id);
    }
}
