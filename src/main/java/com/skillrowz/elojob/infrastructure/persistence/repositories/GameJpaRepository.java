package com.skillrowz.elojob.infrastructure.persistence.repositories;

import com.skillrowz.elojob.infrastructure.persistence.entities.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GameJpaRepository extends JpaRepository<GameEntity, UUID> {
    Optional<GameEntity> findByName(String name);
}

