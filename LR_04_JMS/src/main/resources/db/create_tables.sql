CREATE TABLE album (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    record_label VARCHAR(255) NOT NULL
);

CREATE TABLE song (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    executor VARCHAR(255) NOT NULL,
    album_id INTEGER NOT NULL,
    FOREIGN KEY (album_id) REFERENCES album(id) ON DELETE CASCADE
);

CREATE TABLE audit_events (
    id SERIAL PRIMARY KEY,
    entity_name VARCHAR(255) NOT NULL,
    entity_id BIGINT NOT NULL,
    change_type VARCHAR(50) NOT NULL,
    change_details TEXT,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE notification_conditions (
     id SERIAL PRIMARY KEY,
     entity_name VARCHAR(255) NOT NULL,
     email VARCHAR(255) NOT NULL
);