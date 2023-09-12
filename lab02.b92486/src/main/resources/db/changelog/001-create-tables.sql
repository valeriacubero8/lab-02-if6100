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
