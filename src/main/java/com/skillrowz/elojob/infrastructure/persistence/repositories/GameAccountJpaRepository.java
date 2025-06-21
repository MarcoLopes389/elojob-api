package com.skillrowz.elojob.infrastructure.persistence.repositories;

import com.skillrowz.elojob.infrastructure.persistence.entities.GameAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GameAccountJpaRepository extends JpaRepository<GameAccountEntity, UUID> {
    List<GameAccountEntity> findByOwnerId(UUID ownerId);
    List<GameAccountEntity> findBySoldFalse(); // para vitrine
}
