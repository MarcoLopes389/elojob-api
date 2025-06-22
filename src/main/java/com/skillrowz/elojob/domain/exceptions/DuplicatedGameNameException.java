package com.skillrowz.elojob.domain.exceptions;

public class DuplicatedGameNameException extends DomainException {
    public DuplicatedGameNameException() {
        super("Nome de jogo já existe");
    }
}
