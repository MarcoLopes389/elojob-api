package com.skillrowz.elojob.domain.entities;

import java.util.UUID;

public class Chat {
    private UUID id;
    private User seller;
    private User buyer;
    private GameAccount gameAccount;

    public Chat(UUID id, User seller, User buyer, GameAccount gameAccount) {
        if (seller.equals(buyer)) {
            throw new IllegalArgumentException("A chat must involve two different users.");
        }

        this.id = id;
        this.seller = seller;
        this.buyer = buyer;
        this.gameAccount = gameAccount;
    }

    public UUID getId() {
        return id;
    }

    public User getSeller() {
        return seller;
    }

    public User getBuyer() {
        return buyer;
    }

    public GameAccount getGameAccount() {
        return gameAccount;
    }

    public boolean involvesUser(User user) {
        return seller.equals(user) || buyer.equals(user);
    }
}
