package com.example.backend.web.dto.mapper;

import com.example.backend.business.entity.User2WordStatusEntity;
import com.example.backend.business.entity.WordEntity;
import com.example.backend.business.enums.StatusWordEnum;
import com.example.backend.web.dto.read.WordCountDto;
import com.example.backend.web.dto.read.WordReadDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public abstract class WordMapper {

    public WordReadDto toReadDto(WordEntity wordEntity, StatusWordEnum statusWordEnum) {
        if (wordEntity == null) {
            return null;
        }

        WordReadDto wordReadDto = new WordReadDto();

        wordReadDto.setId(wordEntity.getId());
        wordReadDto.setOriginal(wordEntity.getOriginal());
        wordReadDto.setTranslation(wordEntity.getTranslation());
        wordReadDto.setStatus(statusWordEnum);
        wordReadDto.setName("Перевод-слово");
        wordReadDto.setImagePath("img/translation_.jpeg");
        wordReadDto.setExplanation("Давай попробуем вместе!");
        wordReadDto.setTitle("Слабо отгадать перевод слова?");

        return wordReadDto;
    }

    public WordCountDto getCount(List<User2WordStatusEntity> user2WordStatusEntities) {
        WordCountDto wordCountDto = new WordCountDto();
        user2WordStatusEntities.forEach(item -> {
            switch (item.getStatus()) {
                case NEW:
                    wordCountDto.incNew();
                    break;
                case LEARNED:
                    wordCountDto.incLearned();
                    break;
                case LEARNING:
                    wordCountDto.incLearning();
                    break;
            }
        });
        return wordCountDto;
    }
}
