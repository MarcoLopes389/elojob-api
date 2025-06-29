package com.skillrowz.elojob.domain.repositories;

import com.skillrowz.elojob.domain.entities.User;
import com.skillrowz.elojob.infrastructure.persistence.entities.UserEntity;
import com.skillrowz.elojob.infrastructure.persistence.repositories.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {
    @Autowired
    private UserJpaRepository userJpaRepository;

    public Optional<User> findByEmail(String email) {
        var user = userJpaRepository.findByEmail(email);

        return user.map(UserEntity::toDomain);
    }

    public User create(User user) {
        var createdUser = userJpaRepository.save(UserEntity.fromDomain(user));
        return createdUser.toDomain();
    }
}
