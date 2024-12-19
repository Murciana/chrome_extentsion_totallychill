package com.mlb.apiProjectTC.model;

import jakarta.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "good_vibe_phrases")

public class Phrases {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="phrase")
    private String goodVibePhrase;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodVibePhrase() {
        return goodVibePhrase;
    }

    public void setGoodVibePhrase(String goodVibePhrase) {
        this.goodVibePhrase = goodVibePhrase;
    }
}
