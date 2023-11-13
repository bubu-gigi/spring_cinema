CREATE DATABASE testing;

USE `testing`;

CREATE TABLE `films` (
    `id` int NOT NULL,
    `status` varchar(100) NOT NULL,
    `title` varchar(100) NOT NULL ,
    `pellicole` int DEFAULT 0,
    `release_date` varchar(50),
    `daily_gain` float DEFAULT 0,
    `weekly_gain` float DEFAULT 0,
    `monthly_gain` float DEFAULT 0,
    `tot_gain` float DEFAULT 0
);