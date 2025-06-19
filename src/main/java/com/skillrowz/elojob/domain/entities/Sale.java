package com.skillrowz.elojob.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Sale {
    private UUID id;
    private GameAccount gameAccount;
    private User previousOwner;
    private User nextOwner;
    private BigDecimal amountPaid;
    private LocalDateTime transferredAt;

    public Sale(UUID id, GameAccount gameAccount, User previousOwner, User nextOwner, BigDecimal amountPaid, LocalDateTime transferredAt) {
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

    public BigDecimal getAmountPaid() {
        return amountPaid;
    }

    public LocalDateTime getTransferredAt() {
        return transferredAt;
    }

    public GameAccount getGameAccount() {
        return gameAccount;
    }

    public User getPreviousOwner() {
        return previousOwner;
    }

    public User getNextOwner() {
        return nextOwner;
    }
}
