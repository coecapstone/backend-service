SET NAMES utf8;

SET character_set_client = utf8mb4;

DROP TABLE IF EXISTS `form_type`;
CREATE TABLE `form_type` (
    `key` varchar(50),
    `text` varchar(50),
    `value` varchar(50),
    PRIMARY KEY (`key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `profile_data`;
CREATE TABLE `profile_data` (
    `email` varchar(50),
    `name` varchar(50),
    `imageUrl` varchar(130),
    PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `travel_request_form`;
CREATE TABLE `travel_request_form` (
    `id` int(30) unsigned NOT NULL AUTO_INCREMENT,
    `legal_firstname` varchar(50),
    `legal_lastname` varchar(50),
    `is_approved` int(1) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

