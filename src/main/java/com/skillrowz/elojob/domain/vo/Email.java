package com.skillrowz.elojob.domain.vo;

import com.skillrowz.elojob.domain.exceptions.InvalidUserEmailException;

import java.util.regex.Pattern;

public record Email(String value) {

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$");

    public Email(String value) {
        validate(value);
        this.value = value.toLowerCase();
    }

    private void validate(String value) {
        if (value == null || !EMAIL_PATTERN.matcher(value).matches()) {
            throw new InvalidUserEmailException();
        }
    }
}
