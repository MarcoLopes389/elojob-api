CREATE TABLE users (
    id UUID PRIMARY KEY,
    value VARCHAR(255) NOT NULL, -- email embeddable
    password VARCHAR(255) NOT NULL,
    name VARCHAR(100) NOT NULL,
    nickname VARCHAR(50) NOT NULL UNIQUE
);