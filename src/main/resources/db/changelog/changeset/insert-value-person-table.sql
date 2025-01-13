-- liquibase formatted sql

-- changeset Author:insert-value-person-table

INSERT INTO PERSON (name, surname, age, phone_number, city_of_living)
VALUES ('Ivan', 'Ivanov', 25, '+7 (900) 111-1111', 'MOSCOW'),
       ('Aleksey', 'Alekseev', 27, '+7 (901) 222-2222', 'KAZAN'),
       ('Sergey', 'Smirnov', 30, '+7 (900) 333-3333', 'MOSCOW'),
       ('Anna', 'Petrova', 20, '+7 (903) 444-4444', 'SOCHI'),
       ('Andrey', 'Smirnov', 33, '+7 (904) 555-5555', 'PERM'),
       ('Svetlana', 'Korneva', 28, '+7 (900) 667-6677', 'MOSCOW'),
       ('Dmitriy', 'Sidorov', 22, '+7 (905) 777-7777', 'VORONEZH'),
       ('Sergey', 'Aleksandrov', 38, '+7 (906) 888-8888', 'KRASNODAR'),
       ('Olga', 'Fedorova', 26, '+7 (907) 999-9999', 'TVER');
