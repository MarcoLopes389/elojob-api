package com.skillrowz.elojob.domain.exceptions;

public class InvalidChatUsersException extends DomainException {
    public InvalidChatUsersException() {
        super("Um chat precisa envolver mais de uma usuário");
    }
}
