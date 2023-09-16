
CREATE TABLE b92486_rooms
(
    id         UUID PRIMARY KEY,
    room_Name  VARCHAR(255) NOT NULL UNIQUE,
    created_By VARCHAR(255) NOT NULL
);

CREATE TABLE b92486_users
(
    id       UUID PRIMARY KEY,
    user_Name VARCHAR(255) NOT NULL UNIQUE,
    room_Id  UUID,
    FOREIGN KEY (room_Id) REFERENCES rooms (id)
);

CREATE TABLE b92486_messages
(
    message_Id UUID PRIMARY KEY,
    room_Id    UUID,
    user_Name   VARCHAR(255),
    message    VARCHAR(1000),
    created_On DATE,
    FOREIGN KEY (room_Id) REFERENCES rooms (id)
);