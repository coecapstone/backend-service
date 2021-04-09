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
    `declined_reason` varchar(1005),
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
    `departing_date` varchar(20),
    `returning_date` varchar(20),
    `reason` varchar(1005),
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `form_budget_list`;
CREATE TABLE `form_budget_list` (
    `id` int(100) unsigned NOT NULL AUTO_INCREMENT,
    `form_id` varchar(60),
    `budget_number` varchar(30),
    `amount` varchar(30),
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `form_whether_to_pay_flight`;
CREATE TABLE `form_whether_to_pay_flight` (
    `id` int(100) unsigned NOT NULL AUTO_INCREMENT,
    `form_id` varchar(60),
    `going_to` varchar(30),
    `whether_to_pay_amount` varchar(30),
    `whether_to_pay_returning_date` varchar(20),
    `whether_to_pay_departing_date` varchar(20),
    `flight_number` varchar(10),
    `flight_from` varchar(20),
    `flight_reference` varchar(1000),
    `birthday` varchar(10),
    `airline` varchar(20),
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `form_purchase_requests`;
CREATE TABLE `form_purchase_requests` (
    `id` varchar(60),
    `form_type` varchar(10),
    `full_name` varchar(50),
    `address_line_1` varchar(100),
    `address_line_2` varchar(100),
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

