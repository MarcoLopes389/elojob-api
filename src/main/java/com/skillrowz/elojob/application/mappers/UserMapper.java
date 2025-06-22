package com.skillrowz.elojob.application.mappers;

import com.skillrowz.elojob.application.dtos.UserResponseDto;
import com.skillrowz.elojob.domain.entities.User;

public class UserMapper {
    public static UserResponseDto mapCreated(User user) {
        return new UserResponseDto(user.getId(), user.getName());
    }
}
