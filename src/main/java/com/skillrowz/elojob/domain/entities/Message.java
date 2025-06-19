package com.skillrowz.elojob.domain.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class Message {
    private UUID id;
    private Chat chat;
    private User sender;
    private String text;
    private String imageUrl;
    private LocalDateTime sentAt;

    public Message(UUID id, Chat chat, User sender, String text, String imageUrl, LocalDateTime sentAt) {
        if ((text == null || text.isBlank()) && (imageUrl == null || imageUrl.isBlank())) {
            throw new IllegalArgumentException("Message must contain at least text or image.");
        }

        this.id = id;
        this.chat= chat;
        this.sender = sender;
        this.text = text;
        this.imageUrl = imageUrl;
        this.sentAt = sentAt;
    }

    public UUID getId() {
        return id;
    }

    public Chat getChat() {
        return chat;
    }

    public User getSender() {
        return sender;
    }

    public String getText() {
        return text;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public boolean isTextOnly() {
        return text != null && imageUrl == null;
    }

    public boolean isImageOnly() {
        return imageUrl != null && (text == null || text.isBlank());
    }

    public boolean isTextAndImage() {
        return text != null && imageUrl != null;
    }
}
