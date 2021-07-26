BEGIN;

DROP TABLE IF EXISTS films CASCADE;
CREATE TABLE films (
                       id       bigserial PRIMARY KEY,
                       name     VARCHAR,
                       duration INTEGER);
INSERT INTO films (name, duration) VALUES
('Interstellar', 175),
('The Fight Club', 150),
('Forest Gump', 115),
('Movie 43', 95);

DROP TABLE IF EXISTS timetable CASCADE;
CREATE TABLE timetable (
                           id         bigserial  PRIMARY KEY,
                           id_film    INTEGER
                               REFERENCES films (id),
                           price      INTEGER,
                           start_time DATETIME,
                           bued_tickets INTEGER);
INSERT INTO timetable (id_film, price, start_time, bued_tickets) VALUES
(3,400,'2021-07-25 23:00:00',2),
(2,350,'2021-07-25 20:00:00',15),
(3,300,'2021-07-25 17:00:00',22),
(2,230,'2021-07-25 10:00:00',5),
(1,250,'2021-07-25 14:00:00',4),
(1,200,'2021-07-25 08:00:00',0),
(4,260,'2021-07-25 12:40:00',7);

COMMIT;