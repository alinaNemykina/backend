package com.example.backend.business.entity;

import com.example.backend.business.enums.StatusCourseEnum;
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

    public CourseEntity(Integer id, @NotBlank String name, @NotBlank String category, @NotBlank String subcategory, @NotNull Integer cookies, @NotBlank String theory) {
        this.id = id;
        this.name = name;
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
}
