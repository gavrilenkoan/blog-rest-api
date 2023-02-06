CREATE TABLE _user (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    firstname VARCHAR(50),
    lastname VARCHAR(50),
    email VARCHAR(50) NOT NULL,
    "password" VARCHAR(70) NOT NULL,
    unique (username, email)
);