CREATE TABLE rooms
(
    id        UUID PRIMARY KEY,
    room_Name  VARCHAR(255) NOT NULL UNIQUE,
    created_By VARCHAR(255)         NOT NULL
);

CREATE TABLE users
(
    id       UUID PRIMARY KEY,
    user_Name VARCHAR(255) NOT NULL

);



CREATE TABLE usersRooms
(
    id       UUID PRIMARY KEY,
    roomId   UUID NOT NULL,
    senderId UUID NOT NULL,
    FOREIGN KEY (roomId) REFERENCES rooms (id),
    FOREIGN KEY (senderId) REFERENCES users (id)
);

-- Crear la tabla de mensajes
CREATE TABLE messages
(
    id          UUID PRIMARY KEY,
    roomId      UUID         NOT NULL,
    senderId    UUID         NOT NULL,
    messageText VARCHAR(255) NOT NULL,
    timestamp   TIMESTAMP    NOT NULL,
    FOREIGN KEY (roomId) REFERENCES rooms (id),
    FOREIGN KEY (senderId) REFERENCES users (id)
);