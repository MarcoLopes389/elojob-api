CREATE TABLE games (
    id UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    genre VARCHAR(50) NOT NULL,
    developer VARCHAR(100) NOT NULL,
    supports_mentorship BOOLEAN NOT NULL
);