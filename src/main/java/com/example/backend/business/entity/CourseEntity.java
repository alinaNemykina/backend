package com.example.backend.business.entity;

public class CourseEntity {
    private Integer id;
    private String name;
    private Integer numberOfTopics;
    private String category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfTopics() {
        return numberOfTopics;
    }

    public void setNumberOfTopics(Integer numberOfTopics) {
        this.numberOfTopics = numberOfTopics;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public CourseEntity(Integer id, String name, Integer numberOfTopics, String category) {
        this.id = id;
        this.name = name;
        this.numberOfTopics = numberOfTopics;
        this.category = category;
    }
}
