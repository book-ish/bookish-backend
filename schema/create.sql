CREATE TABLE IF NOT EXISTS  board
(
    id      SERIAL PRIMARY KEY,
    title varchar(100) NOT NULL,
    memo varchar(100) null,
    image_url varchar(100) null,
    hash_tags json null
);