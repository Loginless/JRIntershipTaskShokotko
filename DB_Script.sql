create database test;

use test;

drop table if exists ComputerParts;

create table ComputerParts(
id int not null auto_increment,
partName varchar(255) not null,
mandatory bit not null,
quantity int not null,
primary key (id))
engine = InnoDB
default char set = utf8;

insert into ComputerParts (partName, mandatory, quantity) values 
('Процессор', 1, 23),
('Материнская плата', 1, 15),
('Корпус', 1, 5),
('Видеокарта', 0, 12),
('Оперативная память', 1, 8),
('Жесткий диск', 1, 43),
('SSD-накопитель', 0, 32),
('Кулер', 1, 6),
('Блок питания', 1, 9),
('Сетевая карта', 0, 22),
('Модуль Wi-Fi', 0, 18),
('Монитор', 1, 24),
('Мышь', 1, 50),
('Стабилизатор напряжения', 0, 3),
('Оптический привод', 0, 2),
('Клавиатура', 1, 42),
('Наушники', 0, 67),
('Джойстик', 0, 47),
('Коврик для мышки', 0, 87),
('Игровое оружие', 0, 1),
('Игровой штурвал', 0, 4),
('Операционная система', 1, 2);

