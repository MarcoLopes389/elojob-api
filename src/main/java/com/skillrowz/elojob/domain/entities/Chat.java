package com.skillrowz.elojob.domain.entities;

import java.util.UUID;

public class Chat {
    private UUID id;
    private User userOne;
    private User userTwo;

    public Chat(UUID id, User userOne, User userTwo) {
        if (userOne.equals(userTwo)) {
            throw new IllegalArgumentException("A chat must involve two different users.");
        }

        this.id = id;
        this.userOne= userOne;
        this.userTwo = userTwo;
    }

    public UUID getId() {
        return id;
    }

    public User getUserOne() {
        return userOne;
    }

    public User getUserTwo() {
        return userTwo;
    }

    public boolean involvesUser(User user) {
        return userOne.equals(user) || userTwo.equals(user);
    }
}
