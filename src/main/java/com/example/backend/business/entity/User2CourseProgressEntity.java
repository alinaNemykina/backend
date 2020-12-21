package com.example.backend.business.entity;

import com.example.backend.business.enums.StatusCourseEnum;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Entity
@Table(name = "user2course_progress")
@EqualsAndHashCode()
public class User2CourseProgressEntity {
    public User2CourseProgressEntity(Long id, UserEntity user, CourseEntity course, @NotNull Integer progress, @NotNull StatusCourseEnum status) {
        this.id = id;
        this.user = user;
        this.course = course;
        this.progress = progress;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private CourseEntity course;

    @NotNull
    @Column(name = "progress")
    private Integer progress;

    @NotNull
    @Column(name = "status")
    private StatusCourseEnum status; //enum

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public CourseEntity getCourse() {
        return course;
    }

    public void setCourse(CourseEntity course) {
        this.course = course;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public StatusCourseEnum getStatus() {
        return status;
    }

    public void setStatus(StatusCourseEnum status) {
        this.status = status;
    }
}
