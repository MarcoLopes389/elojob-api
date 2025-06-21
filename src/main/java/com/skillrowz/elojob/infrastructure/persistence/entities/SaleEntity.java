package com.skillrowz.elojob.infrastructure.persistence.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "sales")
public class SaleEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "game_account_id")
    private GameAccountEntity gameAccount;

    @ManyToOne(optional = false)
    @JoinColumn(name = "previous_owner_id")
    private UserEntity previousOwner;

    @ManyToOne(optional = false)
    @JoinColumn(name = "next_owner_id")
    private UserEntity nextOwner;

    @Column(nullable = false)
    private BigDecimal amountPaid;

    @Column(nullable = false)
    private LocalDateTime transferredAt;

    protected SaleEntity() {}

    public SaleEntity(UUID id, GameAccountEntity gameAccount, UserEntity previousOwner, UserEntity nextOwner, BigDecimal amountPaid, LocalDateTime transferredAt) {
        this.id = id;
        this.gameAccount = gameAccount;
        this.previousOwner = previousOwner;
        this.nextOwner = nextOwner;
        this.amountPaid = amountPaid;
        this.transferredAt = transferredAt;
    }

    public UUID getId() {
        return id;
    }

    public GameAccountEntity getGameAccount() {
        return gameAccount;
    }

    public UserEntity getPreviousOwner() {
        return previousOwner;
    }

    public UserEntity getNextOwner() {
        return nextOwner;
    }

    public BigDecimal getAmountPaid() {
        return amountPaid;
    }

    public LocalDateTime getTransferredAt() {
        return transferredAt;
    }
}

