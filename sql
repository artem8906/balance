-- DROP DATABASE IF EXISTS `balance`;
-- CREATE DATABASE `balance`;
USE `balance`;

CREATE TABLE `operation`
(
    `id`           bigint(10) NOT NULL AUTO_INCREMENT,
    `amount`      float(20)        DEFAULT NULL,
    `date`         DATE             DEFAULT NULL,
    `balance`      float(20)        DEFAULT NULL,
    PRIMARY KEY (`id`)
);

INSERT INTO operation (amount, date, balance) VALUES (-35.50, "2023-06-23", 602.06);
INSERT INTO operation (amount, date, balance) VALUES (-18.16, "2023-06-23", 566.56);
INSERT INTO operation (amount, date, balance) VALUES (-10.30, "2023-06-23", 548.40);



