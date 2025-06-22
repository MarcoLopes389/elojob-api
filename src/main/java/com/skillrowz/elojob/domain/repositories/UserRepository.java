package com.skillrowz.elojob.domain.repositories;

import com.skillrowz.elojob.domain.entities.User;
import com.skillrowz.elojob.infrastructure.persistence.entities.UserEntity;
import com.skillrowz.elojob.infrastructure.persistence.repositories.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    @Autowired
    private UserJpaRepository userJpaRepository;

    public User findByEmail(String email) {
        var user = userJpaRepository.findByEmail(email);

        return user.map(UserEntity::toDomain).orElse(null);
    }
}
