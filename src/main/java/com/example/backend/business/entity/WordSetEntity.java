package com.example.backend.business.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "word_set")
@EqualsAndHashCode()
public class WordSetEntity {
    public WordSetEntity(Long id, @NotBlank String name, @NotBlank String imagePathUri, List<WordEntity> words) {
        this.id = id;
        this.name = name;
        this.imagePathUri = imagePathUri;
        this.words = words;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @NotBlank
    @Column(name = "image_path_uri")
    private String imagePathUri;

    @ManyToMany
    @JoinTable(name = "word_set2word",
            joinColumns = @JoinColumn(name = "word_set_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "word_id", referencedColumnName = "id"))
    private List<WordEntity> words;

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

    public String getImagePathUri() {
        return imagePathUri;
    }

    public void setImagePathUri(String imagePathUri) {
        this.imagePathUri = imagePathUri;
    }

    public List<WordEntity> getWords() {
        return words;
    }

    public void setWords(List<WordEntity> words) {
        this.words = words;
    }
}
