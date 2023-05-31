DROP DATABASE IF EXISTS `balance`;
CREATE DATABASE `balance`;
USE `balance`;

CREATE TABLE `balance`
(
    `id`           bigint(10) NOT NULL AUTO_INCREMENT,
    `balance`      float(20)        DEFAULT NULL,
    `day`          DATE             DEFAULT NULL,
    PRIMARY KEY (`id`)
);

INSERT INTO balance (balance, day) VALUES (312.99, "2023-05-29");