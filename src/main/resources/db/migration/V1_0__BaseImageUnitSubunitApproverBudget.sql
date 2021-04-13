SET NAMES utf8;

SET character_set_client = utf8mb4;

DROP TABLE IF EXISTS `static_unit_info`;
CREATE TABLE `static_unit_info` (
    `unit_name` varchar(50),
    PRIMARY KEY (`unit_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `static_subunit_info`;
CREATE TABLE `static_subunit_info` (
    `subunit_id` int(50) unsigned NOT NULL AUTO_INCREMENT,
    `unit_name` varchar(50),
    `subunit_name` varchar(50),
    PRIMARY KEY (`subunit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `static_approvers_info`;
CREATE TABLE `static_approvers_info` (
    `id` int(50) unsigned NOT NULL AUTO_INCREMENT,
    `approver_netId` varchar(50),
    `subunit_id` int(50),
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `static_fiscal_staffs_info`;
CREATE TABLE `static_fiscal_staffs_info` (
    `id` int(50) unsigned NOT NULL AUTO_INCREMENT,
    `fiscal_staff_netId` varchar(50),
    `subunit_id` int(50),
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `static_system_administrators_info`;
CREATE TABLE `static_system_administrators_info` (
    `system_administrator_netId` varchar(50),
    PRIMARY KEY (`system_administrator_netId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS `static_budget_info`;
CREATE TABLE `static_budget_info` (
    `budget_number` varchar(50),
    `budget_name` varchar(50),
    PRIMARY KEY (`budget_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 往 Subunit 里面加 budget
DROP TABLE IF EXISTS `static_budget_assigned_to_subunit_info`;
CREATE TABLE `static_budget_assigned_to_subunit_info` (
    `id` int(100) unsigned NOT NULL AUTO_INCREMENT,
    `subunit_id` int(50),
    `budget_number` varchar(50),
--     `balance` double(20, 2),
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
