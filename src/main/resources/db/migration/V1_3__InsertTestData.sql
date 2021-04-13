INSERT INTO static_unit_info (`unit_name`) VALUES
('Electrical & Computer Engineering'),
('Mechanical Engineering'),
('Materials Science & Engineering'),
('Aeronautics & Astronautics'),
('Bioengineering'),
('Civil & Environmental Engineering');

INSERT INTO static_subunit_info (`unit_name`, `subunit_name`) VALUES
('Aeronautics & Astronautics', 'AA Test Subunit 1'),
('Electrical & Computer Engineering', 'ECE Info theory'),
('Electrical & Computer Engineering', 'ECE Network security'),
('Electrical & Computer Engineering', 'ECE Test Subunit 1'),
('Electrical & Computer Engineering', 'ECE Test Subunit 2'),
('Electrical & Computer Engineering', 'ECE Test Subunit 3'),
('Electrical & Computer Engineering', 'ECE Test Subunit 4'),
('Electrical & Computer Engineering', 'ECE Test Subunit 5'),
('Mechanical Engineering', 'ME Robotics lab'),
('Mechanical Engineering', 'ME Robotics lab II'),
('Mechanical Engineering', 'ME Robotics lab III'),
('Mechanical Engineering', 'ME Robotics lab IIIV'),
('Materials Science & Engineering', 'MSE Klavin lab'),
('Materials Science & Engineering', 'MSE Test Subunit 1'),
('Materials Science & Engineering', 'MSE Test Subunit 2'),
('Civil & Environmental Engineering', 'CEE Test Subunit 1'),
('Civil & Environmental Engineering', 'CEE Test Subunit 2'),
('Civil & Environmental Engineering', 'CEE Test Subunit 3'),
('Civil & Environmental Engineering', 'CEE Test Subunit 4'),
('Bioengineering', 'Bio blood lab 1'),
('Bioengineering', 'Bio blood lab 2'),
('Bioengineering', 'Bio blood lab 3');

INSERT INTO static_approvers_info (`approver_netId`, `subunit_id`) VALUES
('yangx38', 1),
('yangx38', 2),
('yangx38', 3),
('yangx38', 4);

INSERT INTO static_fiscal_staffs_info (`fiscal_staff_netId`, `subunit_id`) VALUES
('yangx38', 1),
('yangx38', 2),
('yangx38', 3);

INSERT INTO static_system_administrators_info (`system_administrator_netId`) VALUES
('yangx38'),
('xiyueyao');

-- 往 Subunit 里面加 budget
INSERT INTO static_budget_info (`budget_number`, `budget_name`) VALUES
('910-11', '910-11 name'),
('910-22', '910-22 name'),
('910-45', '910-45 name'),
('910-46', '910-46 name'),
('910-47', '910-47 name'),
('910-48', '910-48 name');
-- ('910-49', '910-45 name'),
-- ('910-50', '910-45 name'),
-- ('910-451', '910-45 name'),
-- ('910-452', '910-45 name'),
-- ('910-453', '910-45 name'),
-- ('910-454', '910-45 name'),
-- ('910-455', '910-45 name'),
-- ('910-456', '910-45 name'),
-- ('910-457', '910-45 name'),
-- ('910-458', '910-45 name'),
-- ('910-459', '910-45 name'),
-- ('910-4510', '910-45 name'),
-- ('910-4511', '910-45 name'),
-- ('910-4512', '910-45 name'),
-- ('910-4513', '910-45 name'),
-- ('910-4514', '910-45 name'),
-- ('910-4515', '910-45 name'),
-- ('910-4516', '910-45 name'),
-- ('910-4517', '910-45 name'),
-- ('910-4518', '910-45 name'),
-- ('910-4519', '910-45 name'),
-- ('910-4520', '910-45 name'),
-- ('910-4521', '910-45 name'),
-- ('910-4522', '910-45 name'),
-- ('910-4523', '910-45 name'),
-- ('910-4524', '910-45 name'),
-- ('910-4525', '910-45 name'),
-- ('910-4526', '910-45 name'),
-- ('910-4527', '910-45 name'),
-- ('910-4528', '910-45 name'),
-- ('910-4529', '910-45 name'),
-- ('910-4530', '910-45 name'),
-- ('910-4531', '910-45 name'),
-- ('910-4532', '910-45 name'),
-- ('910-4533', '910-45 name'),
-- ('910-4534', '910-45 name'),
-- ('910-4535', '910-45 name'),
-- ('910-4536', '910-45 name');

-- INSERT INTO static_budget_assigned_to_subunit_info (`subunit_id`, `budget_number`, `budget_name`, `balance`) VALUES
-- (1, '910-11', '910-11 name', 100.50),
-- (1, '910-22', '910-22 name', 200.00),
-- (1, '910-33', '910-33 name', 300.00),
-- (1, '910-45', '910-45 name', 400.80),
-- (1, '910-590', '910-590 name', 1000.80),
-- (2, '910-11', '910-11 name', 500.00),
-- (3, '910-11', '910-11 name', 600.50),
-- (4, '910-11', '910-11 name', 700.70);
