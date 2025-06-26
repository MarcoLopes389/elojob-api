package com.skillrowz.elojob.infrastructure.persistence.entities;

import com.skillrowz.elojob.domain.entities.User;
import com.skillrowz.elojob.domain.vo.Email;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String nickname;

    protected UserEntity() {}

    public UserEntity(UUID id, String email, String password, String name, String nickname) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
    }

    public UUID getId() { return id; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getName() { return name; }
    public String getNickname() { return nickname; }

    public User toDomain() {
        return new User(
                this.getId(),
                new Email(this.getEmail()),
                this.getPassword(),
                this.getName(),
                this.getNickname()
        );
    }

    public static UserEntity fromDomain(User domain) {
        return new UserEntity(
                domain.getId(),
                domain.getEmail().value(),
                domain.getPassword(),
                domain.getName(),
                domain.getNickname()
        );
    }
}

