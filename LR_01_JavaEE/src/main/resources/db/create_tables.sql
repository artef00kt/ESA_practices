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