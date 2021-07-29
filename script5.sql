BEGIN;

DROP TABLE IF EXISTS students CASCADE;
CREATE TABLE students (
                       id       bigserial PRIMARY KEY,
                       name     VARCHAR,
                       mark     INTEGER);
INSERT INTO students (name, mark) VALUES
('tom', 10),
('jery', 20);

COMMIT;