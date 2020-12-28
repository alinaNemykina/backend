package com.example.backend.web.api.v1;


import com.example.backend.business.service.WordSetService;
import com.example.backend.web.dto.create.AddWordSetCreateDto;
import com.example.backend.web.dto.read.WordSetReadDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.backend.utils.ApiConstantUtils.ALL;
import static com.example.backend.utils.ApiConstantUtils.WORD_SET;

@RestController
@RequestMapping(WORD_SET)
public class WordSetController {

    private final WordSetService wordSetService;

    public WordSetController(WordSetService wordSetService) {
        this.wordSetService = wordSetService;
    }


    @GetMapping(ALL)
    public ResponseEntity<List<WordSetReadDto>> getAll() {
        return ResponseEntity.ok(wordSetService.getAll());
    }

    @PutMapping
    public void addSetWord(AddWordSetCreateDto dto) {
        wordSetService.addWordSet(dto);
    }

}


