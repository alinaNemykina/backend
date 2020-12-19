package com.example.backend.web.api.v1;

import com.example.backend.business.service.WordService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.backend.utils.ApiConstantUtils.WORD;

@RestController
@RequestMapping(WORD)
public class WordController {

    private final WordService wordService;

    public WordController(WordService wordService) {
        this.wordService = wordService;
    }
}
