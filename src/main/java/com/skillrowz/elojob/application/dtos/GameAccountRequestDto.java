package com.skillrowz.elojob.application.dtos;

import java.util.UUID;

public record GameAccountRequestDto(UUID gameId, String encryptedUsername, String encryptedPassword) {
}
