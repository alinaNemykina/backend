package com.example.backend.business.entity;

import com.example.backend.business.enums.StatusTaskEnum;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Entity
@Table(name = "user2text_progress")
@EqualsAndHashCode()
public class User2TextProgressEntity {

    public User2TextProgressEntity(Long id, UserEntity user, TextExerciseEntity textExercise, @NotNull Integer progress, @NotNull StatusTaskEnum status) {
        this.id = id;
        this.user = user;
        this.textExercise = textExercise;
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
    @JoinColumn(name = "text_exercise_id", referencedColumnName = "id")
    private TextExerciseEntity textExercise;

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

    public TextExerciseEntity getTextExercise() {
        return textExercise;
    }

    public void setTextExercise(TextExerciseEntity textExercise) {
        this.textExercise = textExercise;
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
