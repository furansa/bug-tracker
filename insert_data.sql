/*
 * To run inside a Docker container from the host machine:
 * $ docker exec -i postgresql psql -h localhost -U postgres -d bugtracker < insert_data.sql
 */

\echo Inserting data into applications table
INSERT INTO applications(name, description, owner) VALUES('BugTracker', 'BugTracker Web Application', 'Fernando');

\echo Inserting data into releases table
INSERT INTO releases(date, description) VALUES('20-04-2020', '0.0.1');

\echo Inserting data into tickets table
INSERT INTO tickets(title, description, application, status) VALUES('Ticket test', 'Simple ticket test', 1, 'Opened');

\echo Inserting data into tickets_releases table
INSERT INTO tickets_releases(ticket_id, release_id) VALUES(1, 1);

\echo Done