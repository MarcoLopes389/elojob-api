package com.skillrowz.elojob.domain.spec;

import com.skillrowz.elojob.domain.entities.User;
import com.skillrowz.elojob.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueUserSpec {
    @Autowired
    private UserRepository userRepository;

    public boolean isSatisfiedBy(User user) {
        var existingUser = userRepository.findByEmail(user.getEmail().value());

        return existingUser.isEmpty();
    }
}
