package com.example.backend.business.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Entity
@Table (name = "word")
@EqualsAndHashCode()
public class WordEntity {
    public WordEntity(Long id, @NotBlank String original, @NotBlank String translation, String wordSet) {
        this.id = id;
        this.original = original;
        this.translation = translation;
        this.wordSet = wordSet;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Column(name = "original")
    private String original;

    @NotBlank
    @Column(name = "translation")
    private String translation;

    @Column(name = "word_set")
    private String wordSet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getWordSet() {
        return wordSet;
    }

    public void setWordSet(String wordSet) {
        this.wordSet = wordSet;
    }

}