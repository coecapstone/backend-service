SET NAMES utf8;

SET character_set_client = utf8mb4;

DROP TABLE IF EXISTS `form_all_types`;
CREATE TABLE `form_all_types` (
    `key` varchar(50),
    `text` varchar(50),
    `value` varchar(50),
    PRIMARY KEY (`key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `form_all_requests`;
CREATE TABLE `form_all_requests` (
    `id` varchar(60),
    `form_creator` varchar(50),
    `form_type` varchar(50),
    `unit_name` varchar(50),
    `subunit_name` varchar(50),
    `created_time_UTC` datetime(3),
    `approval_status` varchar(30) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `form_travel_requests`;
CREATE TABLE `form_travel_requests` (
    `id` varchar(60),
    `form_type` varchar(10),
    `legal_firstname` varchar(50),
    `legal_lastname` varchar(50),
    `departure` varchar(30),
    `destination` varchar(30),
    `reason` varchar(1005),
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `form_purchase_requests`;
CREATE TABLE `form_purchase_requests` (
    `id` varchar(50),
    `form_type` varchar(10),
    `full_name` varchar(50),
    `address_line_1` varchar(100),
    `address_line_2` varchar(100),
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

