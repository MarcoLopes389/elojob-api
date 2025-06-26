package com.skillrowz.elojob.domain.exceptions;

public class InvalidUserEmailException extends DomainException {
    public InvalidUserEmailException() {
        super("Email inválido");
    }
}
