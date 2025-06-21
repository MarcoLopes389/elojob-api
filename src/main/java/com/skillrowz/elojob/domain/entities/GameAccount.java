package com.skillrowz.elojob.domain.entities;

import java.util.UUID;

public class GameAccount {

    private UUID id;
    private String encryptedUsername;
    private String encryptedPassword;
    private User owner;
    private Game game;
    private boolean sold;

    public GameAccount(UUID id, User owner, Game game, String encryptedUsername, String encryptedPassword, Boolean sold) {
        this.id = id;
        this.owner = owner;
        this.game = game;
        this.encryptedUsername = encryptedUsername;
        this.encryptedPassword = encryptedPassword;
        this.sold = sold;
    }

    public UUID getId() {
        return id;
    }

    public String getEncryptedUsername() {
        return encryptedUsername;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public User getOwner() {
        return owner;
    }

    public Game getGame() {
        return game;
    }

    public boolean isSold() {
        return sold;
    }

    public void markAsSold() {
        this.sold = true;
    }

    public void transferOwnership(User newOwner) {
        this.owner = newOwner;
        this.sold = true;
    }
}