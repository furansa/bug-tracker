/*
 * To run inside a Docker container from the host machine:
 * $ docker exec -i postgresql psql -h localhost -U postgres -d bugtracker < create_tables.sql
 */

\echo Creating applications table
DROP TABLE IF EXISTS applications CASCADE;
CREATE TABLE applications(
    id SERIAL PRIMARY KEY,
    name VARCHAR(200) NOT NULL UNIQUE,
    description VARCHAR(2000) NOT NULL,
    owner VARCHAR(200) NOT NULL
);
COMMENT ON TABLE applications IS 'Domain table for applications';

\echo Creating releases table
DROP TABLE IF EXISTS releases CASCADE;
CREATE TABLE releases(
    id SERIAL PRIMARY KEY,
    date VARCHAR(10) NOT NULL,
    description VARCHAR(2000) NOT NULL
);
COMMENT ON TABLE releases IS 'Domain table for releases';

\echo Creating tickets table
DROP TABLE IF EXISTS tickets CASCADE;
CREATE TABLE tickets(
    id SERIAL PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    description VARCHAR(2000) NOT NULL,
    application INTEGER NOT NULL REFERENCES applications(id),
    status VARCHAR(200) NOT NULL
);
COMMENT ON TABLE tickets IS 'Registry table for tickets';

\echo Creating tickets_releases table
DROP TABLE IF EXISTS tickets_releases CASCADE;
CREATE TABLE tickets_releases
(
    ticket_id INTEGER NOT NULL REFERENCES tickets (id),
    release_id INTEGER NOT NULL REFERENCES releases (id)
);
COMMENT ON TABLE tickets_releases IS 'Relationship table between tickets and releases';

\echo Done