package com.skillrowz.elojob.infrastructure.persistence.entities;

import com.skillrowz.elojob.domain.entities.GameAccount;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "game_accounts")
public class GameAccountEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String encryptedUsername;

    @Column(nullable = false)
    private String encryptedPassword;

    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_id")
    private UserEntity owner;

    @ManyToOne(optional = false)
    @JoinColumn(name = "game_id")
    private GameEntity game;

    @Column(nullable = false)
    private boolean sold;

    protected GameAccountEntity() {}

    public GameAccountEntity(UUID id, UserEntity owner, GameEntity game, String encryptedUsername, String encryptedPassword, boolean sold) {
        this.id = id;
        this.owner = owner;
        this.game = game;
        this.encryptedUsername = encryptedUsername;
        this.encryptedPassword = encryptedPassword;
        this.sold = sold;
    }

    public UUID getId() { return id; }
    public UserEntity getOwner() { return owner; }
    public GameEntity getGame() { return game; }
    public String getEncryptedUsername() { return encryptedUsername; }
    public String getEncryptedPassword() { return encryptedPassword; }
    public boolean isSold() { return sold; }

    public GameAccount toDomain() {
        return new GameAccount(
                this.getId(),
                this.getOwner().toDomain(),
                this.getGame().toDomain(),
                this.getEncryptedUsername(),
                this.getEncryptedPassword(),
                this.isSold()
        );
    }

    public static GameAccountEntity fromDomain(GameAccount domain) {
        return new GameAccountEntity(
                domain.getId(),
                UserEntity.fromDomain(domain.getOwner()),
                GameEntity.fromDomain(domain.getGame()),
                domain.getEncryptedUsername(),
                domain.getEncryptedPassword(),
                domain.isSold()
        );
    }
}

