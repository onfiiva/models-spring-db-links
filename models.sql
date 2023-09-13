-- Создание базы данных models_spring
CREATE DATABASE IF NOT EXISTS models_spring;
USE models_spring;

-- Таблица для модели House
CREATE TABLE House (
    id INT AUTO_INCREMENT PRIMARY KEY,
    Type VARCHAR(255),
    Street VARCHAR(255),
    Number INT,
    Owner VARCHAR(255),
    ConstructionDate DATE
);

-- Таблица для модели Job
CREATE TABLE Job (
    id INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(255),
    Type VARCHAR(255),
    Slogan VARCHAR(255),
    Employees INT,
    Budget INT
);

-- Таблица для модели Person
CREATE TABLE Person (
    id INT AUTO_INCREMENT PRIMARY KEY,
    Surname VARCHAR(255),
    Name VARCHAR(255),
    Patronymic VARCHAR(255),
    Age INT
);

-- Таблица для модели Transport
CREATE TABLE Transport (
    id INT AUTO_INCREMENT PRIMARY KEY,
    Type VARCHAR(255),
    Company VARCHAR(255),
    Model VARCHAR(255),
    Series INT,
    Color VARCHAR(255)
);
