package com.skillrowz.elojob.domain.exceptions;

public class DuplicatedUserEmailException extends DomainException {
    public DuplicatedUserEmailException() {
        super("Email já cadastrado");
    }
}
