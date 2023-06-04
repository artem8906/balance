DROP DATABASE IF EXISTS `balance`;
CREATE DATABASE `balance`;
USE `balance`;

CREATE TABLE `balance`
(
    `id`           bigint(10) NOT NULL AUTO_INCREMENT,
    `balance`      float(20)        DEFAULT NULL,
    `date`         DATE             DEFAULT NULL,
    PRIMARY KEY (`id`)
);

INSERT INTO balance (balance, DATE) VALUES (312.99, "2023-05-29");

SELECT `COLUMN_NAME` FROM `INFORMATION_SCHEMA`.`COLUMNS` WHERE `TABLE_SCHEMA`='balance' AND `TABLE_NAME`='balance';