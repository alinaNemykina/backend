package com.example.backend.business.entity;

import com.example.backend.business.enums.StatusWordEnum;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "user2word_status")
@EqualsAndHashCode()
public class User2WordStatusEntity {
    public User2WordStatusEntity(Long id, UserEntity user, WordEntity word, StatusWordEnum status) {
        this.id = id;
        this.user = user;
        this.word = word;
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
    @JoinColumn(name = "word_id", referencedColumnName = "id")
    private WordEntity word;

    @Column(name = "status")
    private StatusWordEnum status;

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

    public WordEntity getWord() {
        return word;
    }

    public void setWord(WordEntity word) {
        this.word = word;
    }

    public StatusWordEnum getStatus() {
        return status;
    }

    public void setStatus(StatusWordEnum status) {
        this.status = status;
    }
}
