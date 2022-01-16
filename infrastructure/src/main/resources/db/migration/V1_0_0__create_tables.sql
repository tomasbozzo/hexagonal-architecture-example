CREATE TABLE IF NOT EXISTS things
(
    thing_id   VARCHAR(36),
    thing_name TEXT,
    CONSTRAINT pk_things
        PRIMARY KEY (thing_id)
);

CREATE TABLE IF NOT EXISTS subthings
(
    thing_id   VARCHAR(36),
    thing_name TEXT,
    CONSTRAINT fk_subthings_things
        FOREIGN KEY (thing_id)
            REFERENCES things (thing_id)
);