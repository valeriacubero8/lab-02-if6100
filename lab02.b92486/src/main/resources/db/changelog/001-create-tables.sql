<<<<<<< HEAD
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
=======
CREATE TABLE Room (
    id UUID PRIMARY KEY,
    name VARCHAR(255) UNIQUE,
    createdBy VARCHAR(255) UNIQUE
);

/*CREATE TABLE Users (
    id UUID,
    alias VARCHAR(255),
    CONSTRAINT fk_users PRIMARY KEY (id, alias),
    CONSTRAINT fk_room FOREIGN KEY (id) REFERENCES Room(id)
);

CREATE TABLE Messages (
    id_messages INT PRIMARY KEY,
    room_id UUID,
    user_alias VARCHAR(255),
    message VARCHAR(255),
    message_date date,
    CONSTRAINT fk_alias FOREIGN KEY (user_alias) REFERENCES Users(alias)
);*/
>>>>>>> 1de8c9b132e6dcd5c926007b41e74101717b7035
