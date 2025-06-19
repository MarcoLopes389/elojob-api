package com.skillrowz.elojob.domain.entities;

import java.util.UUID;

public class Game {

    private UUID id;
    private String name;
    private String genre;
    private String developer;
    private boolean supportsMentorship;

    public Game(UUID id, String name, String genre, String developer, boolean supportsMentorship) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.developer = developer;
        this.supportsMentorship = supportsMentorship;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getDeveloper() {
        return developer;
    }

    public boolean supportsMentorship() {
        return supportsMentorship;
    }

    public void enableMentorship() {
        this.supportsMentorship = true;
    }

    public void disableMentorship() {
        this.supportsMentorship = false;
    }
}

