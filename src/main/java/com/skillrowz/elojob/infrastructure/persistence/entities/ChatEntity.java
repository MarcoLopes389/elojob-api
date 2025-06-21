package com.skillrowz.elojob.infrastructure.persistence.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "chats")
public class ChatEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "seller_id")
    private UserEntity seller;

    @ManyToOne(optional = false)
    @JoinColumn(name = "buyer_id")
    private UserEntity buyer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "game_account_id")
    private GameAccountEntity gameAccount;

    protected ChatEntity() {}

    public ChatEntity(UUID id, UserEntity seller, UserEntity buyer) {
        this.id = id;
        this.seller = seller;
        this.buyer = buyer;
    }

    public UUID getId() {
        return id;
    }

    public UserEntity getSeller() {
        return seller;
    }

    public UserEntity getBuyer() {
        return buyer;
    }
}

