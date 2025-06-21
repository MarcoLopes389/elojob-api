package com.skillrowz.elojob.infrastructure.persistence.repositories;

import com.skillrowz.elojob.infrastructure.persistence.entities.ChatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChatJpaRepository extends JpaRepository<ChatEntity, UUID> {
    Optional<ChatEntity> findBySellerIdAndBuyerId(UUID sellerId, UUID buyerId);
    List<ChatEntity> findBySellerIdOrBuyerId(UUID userId1, UUID userId2);
}

