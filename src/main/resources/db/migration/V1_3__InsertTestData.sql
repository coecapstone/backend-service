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
INSERT INTO static_budget_info (`subunit_id`, `budget_number`, `budget_name`, `balance`) VALUES
(1, '910-11', '910-11 name', 100.50),
(1, '910-22', '910-22 name', 200.00),
(1, '910-33', '910-33 name', 300.00),
(1, '910-45', '910-45 name', 400.80),
(1, '910-590', '910-590 name', 1000.80),
(2, '910-11', '910-11 name', 500.00),
(3, '910-11', '910-11 name', 600.50),
(4, '910-11', '910-11 name', 700.70);
