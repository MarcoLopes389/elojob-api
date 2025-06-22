package com.skillrowz.elojob.presentation.controllers;

import com.skillrowz.elojob.application.dtos.GameRequestDto;
import com.skillrowz.elojob.application.dtos.GameResponseDto;
import com.skillrowz.elojob.application.usecases.CreateGameUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/games")
public class GamesController {
    @Autowired
    private CreateGameUseCase createGameUseCase;

    @PostMapping
    public ResponseEntity<GameResponseDto> createGame(@RequestBody GameRequestDto body) {
        var game = createGameUseCase.execute(body);
        return ResponseEntity.ok().body(game);
    }
}
