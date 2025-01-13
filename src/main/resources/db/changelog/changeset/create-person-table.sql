-- liquibase formatted sql

-- changeset Author:create-person-table

CREATE TABLE IF NOT EXISTS PERSON (
name           varchar(50)        NOT NULL,
surname        varchar(100)       NOT NULL,
age            int                NOT NULL CHECK ( age >= 1 AND age <= 150),
phone_number   varchar(20),
city_of_living varchar(20)        NOT NULL,
PRIMARY KEY (name, surname, age));