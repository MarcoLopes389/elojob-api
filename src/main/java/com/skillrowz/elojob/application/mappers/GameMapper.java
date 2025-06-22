package com.skillrowz.elojob.application.mappers;

import com.skillrowz.elojob.application.dtos.GameResponseDto;
import com.skillrowz.elojob.domain.entities.Game;

public class GameMapper {
    public static GameResponseDto mapCreate(Game game) {
        return new GameResponseDto(game.getId(), game.getName());
    }
}
