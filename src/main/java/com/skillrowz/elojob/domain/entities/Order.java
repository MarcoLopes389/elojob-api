package com.skillrowz.elojob.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Order {
    private UUID id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<OrderItem> items;
    private User user;
    private boolean paid;

    public Order(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, User user, List<OrderItem> items, boolean paid) {
        this.id = id;
        this.items = items;
        this.user = user;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.paid = paid;
    }

    public UUID getId() { return id; }
    public List<OrderItem> getItems() { return Collections.unmodifiableList(items); }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public User getUser() {
        return user;
    }
    public boolean isPaid() { return paid; }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(UUID itemId) {
        items.removeIf(i -> i.getId().equals(itemId));
    }

    public BigDecimal getTotalPrice() {
        return items.stream()
                .map(OrderItem::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void markAsPaid() {
        this.paid = true;
    }
}
