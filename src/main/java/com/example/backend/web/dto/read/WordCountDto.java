package com.example.backend.web.dto.read;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class WordCountDto {
    Integer newStatus = 0;
    Integer learningStatus = 0;
    Integer learnedStatus = 0;

    public void incNew(){
        newStatus++;
    }

    public void  incLearning(){
        learningStatus++;
    }

    public void incLearned(){
        learnedStatus++;
    }
}
