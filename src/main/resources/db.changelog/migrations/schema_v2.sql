-- liquibase formatted sql

-- changeset Andrey:1

insert into migration.person
      (name, surname, age, phone_number, city_of_living)
values('Ivan', 'Ivanov', 23, '11111111111', 'Moscow'),
      ('Oly', 'Divanov', 30, '22222222222', 'Moscow'),
      ('Oleg', 'Bavanov', 40, '33333333333', 'Yfa'),
      ('Oleg', 'Tavanov', 22, '555555555555', 'Vlg');