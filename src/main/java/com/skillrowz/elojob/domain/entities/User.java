package com.skillrowz.elojob.domain.entities;

import com.skillrowz.elojob.domain.vo.Email;

import java.util.UUID;

public class User {
    private UUID id;
    private Email email;
    private String password;
    private String name;
    private String nickname;

    public User(UUID id, Email email, String password, String name, String nickname) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
    }

    public UUID getId() { return id; }
    public Email getEmail() { return email; }
    public String getPassword() { return password; }
    public String getName() { return name; }
    public String getNickname() { return nickname; }

    public void changeName(String newName) {
        this.name = newName;
    }

    public void changeNickname(String newNick) {
        this.nickname = newNick;
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }
}
