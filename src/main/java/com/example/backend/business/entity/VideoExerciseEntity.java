package com.example.backend.business.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Entity
@Table(name = "video_exercise")
@EqualsAndHashCode()
public class VideoExerciseEntity {
    public VideoExerciseEntity(Long id, @NotBlank String name, @NotBlank String videoUrl, @NotNull Integer cookies) {
        this.id = id;
        this.name = name;
        this.videoUrl = videoUrl;
        this.cookies = cookies;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @NotBlank
    @Column(name = "video_url")
    private String videoUrl;

    @NotNull
    @Column(name = "cookies")
    private Integer cookies;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Integer getCookies() {
        return cookies;
    }

    public void setCookies(Integer cookies) {
        this.cookies = cookies;
    }
}
