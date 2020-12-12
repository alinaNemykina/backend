package com.example.backend.business.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TaskEntity {
    private Long id;
    private String title;
    private String category;
    private String imagePathUri;
    private String explanation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImagePathUri() {
        return imagePathUri;
    }

    public void setImagePathUri(String imagePathUri) {
        this.imagePathUri = imagePathUri;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public TaskEntity(Long id, String title, String category, String imagePathUri, String explanation) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.imagePathUri = imagePathUri;
        this.explanation = explanation;
    }
}
