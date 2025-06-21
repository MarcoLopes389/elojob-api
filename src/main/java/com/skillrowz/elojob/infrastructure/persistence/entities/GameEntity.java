package com.skillrowz.elojob.infrastructure.persistence.entities;

import com.skillrowz.elojob.domain.entities.Game;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "games")
public class GameEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private String developer;

    @Column(nullable = false)
    private boolean supportsMentorship;

    protected GameEntity() {}

    public GameEntity(UUID id, String name, String genre, String developer, boolean supportsMentorship) {
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

    public boolean isSupportsMentorship() {
        return supportsMentorship;
    }

    public Game toDomain() {
        return new Game(
                this.getId(),
                this.getName(),
                this.getGenre(),
                this.getDeveloper(),
                this.isSupportsMentorship()
        );
    }

    public static GameEntity fromDomain(Game domain) {
        return new GameEntity(
                domain.getId(),
                domain.getName(),
                domain.getGenre(),
                domain.getDeveloper(),
                domain.supportsMentorship()
        );
    }
}

