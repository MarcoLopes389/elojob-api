package com.skillrowz.elojob.application.usecases;

import com.skillrowz.elojob.application.dtos.GameRequestDto;
import com.skillrowz.elojob.application.dtos.GameResponseDto;
import com.skillrowz.elojob.application.mappers.GameMapper;
import com.skillrowz.elojob.domain.entities.Game;
import com.skillrowz.elojob.domain.exceptions.DuplicatedGameNameException;
import com.skillrowz.elojob.domain.repositories.GameRepository;
import com.skillrowz.elojob.domain.spec.UniqueGameSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateGameUseCase {
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private UniqueGameSpec uniqueGameSpec;

    public GameResponseDto execute(GameRequestDto body) {
        var game = new Game(null, body.name(), body.genre(), body.developer(), body.supportsMentorship());

        if (!uniqueGameSpec.isSatisfiedBy(game)) {
            throw new DuplicatedGameNameException();
        }

        var createdGame = gameRepository.create(game);

        return GameMapper.mapCreate(createdGame);
    }
}
