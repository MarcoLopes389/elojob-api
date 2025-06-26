package com.skillrowz.elojob.application.usecases;

import com.skillrowz.elojob.application.dtos.GameAccountRequestDto;
import com.skillrowz.elojob.application.dtos.GameAccountResponseDto;
import com.skillrowz.elojob.domain.entities.GameAccount;
import com.skillrowz.elojob.domain.repositories.GameRepository;
import com.skillrowz.elojob.domain.repositories.UserRepository;
import com.skillrowz.elojob.infrastructure.auth.entities.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateGameAccountUseCase {
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private UserRepository userRepository;

    public GameAccountResponseDto execute(UserDetailsImpl userDetails, GameAccountRequestDto body) {
        var game = gameRepository.findById(body.gameId());

        if (game.isEmpty()) {
            throw new RuntimeException("");
        }

        var user = userRepository.findByEmail(userDetails.getUsername());

        if (user.isEmpty()) {
            throw new RuntimeException("");
        }

        var gameAccount = new GameAccount(
                null,
                user.get(),
                game.get(),
                new String(""),
                new String(""),
                false
        );

        return new GameAccountResponseDto(gameAccount.getId());
    }
}
