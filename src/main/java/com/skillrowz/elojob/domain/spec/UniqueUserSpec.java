package com.skillrowz.elojob.domain.spec;

import com.skillrowz.elojob.domain.entities.User;

public class UniqueUserSpec {
    public boolean isSatisfiedBy(User user) {
        return true;
    }
}
