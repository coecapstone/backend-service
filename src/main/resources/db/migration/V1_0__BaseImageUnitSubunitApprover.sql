SET NAMES utf8;

SET character_set_client = utf8mb4;

DROP TABLE IF EXISTS `unit_info`;
CREATE TABLE `unit_info` (
    `unit_id` int(50) unsigned NOT NULL AUTO_INCREMENT,
    `unit_name` varchar(50),
    PRIMARY KEY (`unit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `subunit_info`;
CREATE TABLE `subunit_info` (
    `subunit_id` int(50) unsigned NOT NULL AUTO_INCREMENT,
    `unit_name` varchar(50),
    `subunit_name` varchar(50),
    PRIMARY KEY (`subunit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `approvers_info`;
CREATE TABLE `approvers_info` (
    `id` int(50) unsigned NOT NULL AUTO_INCREMENT,
    `approver_netId` varchar(50),
    `subunit_id` int(50),
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
