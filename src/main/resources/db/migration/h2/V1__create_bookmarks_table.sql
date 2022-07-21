CREATE SEQUENCE bookmark_sequence START WITH 1 INCREMENT BY 50;

CREATE TABLE bookmarks (
    id bigint DEFAULT nextval('bookmark_sequence') NOT NULL,
    created_at TIMESTAMP,
    title VARCHAR(255) NOT NULL,
    url VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);