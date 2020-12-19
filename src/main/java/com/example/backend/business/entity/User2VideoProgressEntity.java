package com.example.backend.business.entity;

import com.example.backend.business.enums.StatusTaskEnum;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Entity
@Table(name = "user2video_progress")
@EqualsAndHashCode()
public class User2VideoProgressEntity {

    public User2VideoProgressEntity(Long id, UserEntity user, VideoExerciseEntity videoExercise, @NotNull Integer progress, @NotNull StatusTaskEnum status) {
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
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private StatusTaskEnum status;

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

    public VideoExerciseEntity getVideoExercise() {
        return videoExercise;
    }

    public void setVideoExercise(VideoExerciseEntity videoExercise) {
        this.videoExercise = videoExercise;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public StatusTaskEnum getStatus() {
        return status;
    }

    public void setStatus(StatusTaskEnum status) {
        this.status = status;
    }
}
