package com.skillrowz.elojob.domain.repositories;

import com.skillrowz.elojob.domain.entities.Game;
import com.skillrowz.elojob.infrastructure.persistence.entities.GameEntity;
import com.skillrowz.elojob.infrastructure.persistence.repositories.GameJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class GameRepository {
    @Autowired
    private GameJpaRepository gameJpaRepository;

    public Optional<Game> findByName(String name) {
        var game = gameJpaRepository.findByName(name);
        return game.map(GameEntity::toDomain);
    }

    public Optional<Game> findById(UUID id) {
        var game = gameJpaRepository.findById(id);
        return game.map(GameEntity::toDomain);
    }

    public Game create(Game game) {
        var createdGame = gameJpaRepository.save(GameEntity.fromDomain(game));
        return createdGame.toDomain();
    }
}
