package com.skillrowz.elojob.domain.repositories;

import com.skillrowz.elojob.domain.entities.Game;
import com.skillrowz.elojob.infrastructure.persistence.repositories.GameJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GameRepository {
    @Autowired
    private GameJpaRepository gameJpaRepository;

    public Game findByName(String name) {
        var game = gameJpaRepository.findByName(name);
    }
}
