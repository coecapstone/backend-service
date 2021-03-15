SET NAMES utf8;

SET character_set_client = utf8mb4;

DROP TABLE IF EXISTS `form_type`;
CREATE TABLE `form_type` (
    `key` varchar(50),
    `text` varchar(50),
    `value` varchar(50),
    PRIMARY KEY (`key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `form_travel_request`;
CREATE TABLE `form_travel_request` (
    `id` int(50) unsigned NOT NULL AUTO_INCREMENT,
    `legal_firstname` varchar(50),
    `legal_lastname` varchar(50),
    `is_approved` int(1) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

