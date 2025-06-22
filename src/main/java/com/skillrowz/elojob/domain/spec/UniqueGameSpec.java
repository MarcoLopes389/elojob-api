package com.skillrowz.elojob.domain.spec;

import com.skillrowz.elojob.domain.entities.Game;
import com.skillrowz.elojob.domain.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueGameSpec {
    @Autowired
    private GameRepository gameRepository;

    public boolean isSatisfiedBy(Game game) {
        var existingGame = gameRepository.findByName(game.getName());

        return existingGame == null;
    }
}
