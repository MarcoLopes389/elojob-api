package com.skillrowz.elojob.domain.entities;

import com.skillrowz.elojob.domain.exceptions.InvalidChatUsersException;

import java.util.UUID;

public class Chat {
    private UUID id;
    private User seller;
    private User buyer;
    private GameAccount gameAccount;

    public Chat(UUID id, User seller, User buyer, GameAccount gameAccount) {
        validateUsers(seller, buyer);

        this.id = id;
        this.seller = seller;
        this.buyer = buyer;
        this.gameAccount = gameAccount;
    }

    private void validateUsers(User seller, User buyer) {
        if (seller.equals(buyer)) {
            throw new InvalidChatUsersException();
        }
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
