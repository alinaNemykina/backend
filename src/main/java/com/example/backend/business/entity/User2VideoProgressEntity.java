package com.example.backend.business.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Entity
@Table(name = "user2video_progress")
@EqualsAndHashCode()
public class User2VideoProgressEntity {
    public User2VideoProgressEntity(Long id, UserEntity user, VideoExerciseEntity videoExercise, @NotNull Integer progress, @NotNull Boolean status) {
        this.id = id;
        this.user = user;
        this.videoExercise = videoExercise;
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
    @JoinColumn(name = "video_exercise_id", referencedColumnName = "id")
    private VideoExerciseEntity videoExercise;

    @NotNull
    @Column(name = "progress")
    private Integer progress;

    @NotNull
    @Column(name = "status")
    private Boolean status;
}