package com.skillrowz.elojob.domain.vo;

import java.util.regex.Pattern;

public class Email {

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$");

    private String value;

    protected Email() {}

    public Email(String value) {
        validate(value);
        this.value = value.toLowerCase();
    }

    public String getValue() {
        return value;
    }

    private void validate(String value) {
        if (value == null || !EMAIL_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("Invalid email.");
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
