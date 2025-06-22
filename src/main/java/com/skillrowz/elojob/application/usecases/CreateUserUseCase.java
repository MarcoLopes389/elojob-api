package com.skillrowz.elojob.application.usecases;

import com.skillrowz.elojob.application.dtos.UserRequestDto;
import com.skillrowz.elojob.application.dtos.UserResponseDto;
import com.skillrowz.elojob.application.mappers.UserMapper;
import com.skillrowz.elojob.domain.entities.User;
import com.skillrowz.elojob.domain.exceptions.DuplicatedUserEmailException;
import com.skillrowz.elojob.domain.repositories.UserRepository;
import com.skillrowz.elojob.domain.spec.UniqueUserSpec;
import com.skillrowz.elojob.domain.vo.Email;
import com.skillrowz.elojob.domain.vo.Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase {
    @Autowired
    private UniqueUserSpec uniqueUserSpec;
    @Autowired
    private UserRepository userRepository;

    public UserResponseDto execute(UserRequestDto body) {
        var email = new Email(body.email());
        var password = new Password(body.password());

        var user = new User(null, email, password.getValue(), body.name(), body.nickname());

        if (!uniqueUserSpec.isSatisfiedBy(user)) {
            throw new DuplicatedUserEmailException();
        }

        var createdUser = userRepository.create(user);
        return UserMapper.mapCreated(createdUser);
    }
}
