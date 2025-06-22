package com.skillrowz.elojob.domain.repositories;

import com.skillrowz.elojob.domain.entities.Chat;
import com.skillrowz.elojob.infrastructure.persistence.entities.ChatEntity;
import com.skillrowz.elojob.infrastructure.persistence.repositories.ChatJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class ChatRepository {
    @Autowired
    private ChatJpaRepository chatJpaRepository;

    public Chat findBySellerIdAndBuyerId(UUID sellerId, UUID buyerId) {
        var chat = chatJpaRepository.findBySellerIdAndBuyerId(sellerId, buyerId);

        return chat.map(ChatEntity::toDomain).orElse(null);
    }
}
