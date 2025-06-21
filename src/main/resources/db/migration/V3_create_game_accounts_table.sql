CREATE TABLE game_accounts (
    id UUID PRIMARY KEY,
    encrypted_username TEXT NOT NULL,
    encrypted_password TEXT NOT NULL,
    owner_id UUID NOT NULL REFERENCES users(id),
    game_id UUID NOT NULL REFERENCES games(id),
    sold BOOLEAN NOT NULL DEFAULT FALSE
);