package com.skillrowz.elojob.presentation.controllers;

import com.skillrowz.elojob.application.dtos.UserRequestDto;
import com.skillrowz.elojob.application.dtos.UserResponseDto;
import com.skillrowz.elojob.application.usecases.CreateUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/users")
public class UsersController {
    @Autowired
    private CreateUserUseCase createUserUseCase;

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto body) {
        var user = createUserUseCase.execute(body);
        return ResponseEntity.ok().body(user);
    }
}
