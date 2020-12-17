package com.example.backend.business.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Entity
@Data
@Table(name = "course")
@EqualsAndHashCode()
public class CourseEntity {

    public CourseEntity(Integer id, @NotBlank String name, @NotNull Integer numberOfTopics, @NotBlank String category, @NotBlank String subcategory, @NotNull Integer cookies, @NotBlank String theory) {
        this.id = id;
        this.name = name;
        this.numberOfTopics = numberOfTopics;
        this.category = category;
        this.subcategory = subcategory;
        this.cookies = cookies;
        this.theory = theory;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "number_of_topics")
    private Integer numberOfTopics;

    @NotBlank
    @Column(name = "category")
    private String category;

    @NotBlank
    @Column(name = "subcategory")
    private String subcategory;

    @NotNull
    @Column(name = "cookies")
    private Integer cookies;

    @NotBlank
    @Column(name = "theory")
    private String theory;

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

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public Integer getCookies() {
        return cookies;
    }

    public void setCookies(Integer cookies) {
        this.cookies = cookies;
    }

    public String getTheory() {
        return theory;
    }

    public void setTheory(String theory) {
        this.theory = theory;
    }
}
