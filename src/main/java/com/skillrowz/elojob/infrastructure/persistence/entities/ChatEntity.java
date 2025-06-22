package com.skillrowz.elojob.infrastructure.persistence.entities;

import com.skillrowz.elojob.domain.entities.Chat;
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

    public ChatEntity(UUID id, UserEntity seller, UserEntity buyer, GameAccountEntity gameAccount) {
        this.id = id;
        this.seller = seller;
        this.buyer = buyer;
        this.gameAccount = gameAccount;
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

    public GameAccountEntity getGameAccount() {
        return gameAccount;
    }

    public Chat toDomain() {
        return new Chat(
                this.getId(),
                this.seller.toDomain(),
                this.buyer.toDomain(),
                this.gameAccount.toDomain()
        );
    }

    public static ChatEntity fromDomain(Chat domain) {
        return new ChatEntity(
                domain.getId(),
                UserEntity.fromDomain(domain.getSeller()),
                UserEntity.fromDomain(domain.getBuyer()),
                GameAccountEntity.fromDomain(domain.getGameAccount())
        );
    }
}

