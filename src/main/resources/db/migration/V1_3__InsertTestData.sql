INSERT INTO static_unit_info (`unit_name`) VALUES
('Electrical & Computer Engineering'),
('Mechanical Engineering'),
('Materials Science & Engineering'),
('Aeronautics & Astronautics'),
('Bioengineering'),
('Civil & Environmental Engineering');

INSERT INTO static_subunit_info (`unit_name`, `subunit_name`) VALUES
('Electrical & Computer Engineering', 'ECE Info theory'),
('Electrical & Computer Engineering', 'ECE Network security'),
('Mechanical Engineering', 'ME Robotics lab'),
('Mechanical Engineering', 'ME Robotics lab II'),
('Materials Science & Engineering', 'MSE Klavin lab'),
('Civil & Environmental Engineering', 'CEE lablab'),
('Bioengineering', 'Bio blood lab');

INSERT INTO static_approvers_info (`approver_netId`, `subunit_id`) VALUES
('sree', 1),
('baosen', 1),
('baosen', 2),
('yangx38', 1),
('yangx38', 2),
('yangx38', 3),
('yangx38', 4),
('dom', 4);

INSERT INTO static_fiscal_staffs_info (`fiscal_staff_netId`, `subunit_id`) VALUES
('sree', 1),
('baosen', 1),
('baosen', 2),
('yangx38', 1),
('yangx38', 2),
('yangx38', 3),
('dom', 4);

INSERT INTO static_system_administrators_info (`system_administrator_netId`) VALUES
('yangx38'),
('xiyueyao');

INSERT INTO static_budget_info (`subunit_id`, `budget_number`, `balance`) VALUES
(1, '910-11', 100.50),
(1, '910-22', 200.00),
(1, '910-33', 300.00),
(1, '910-45', 400.80),
(1, '910-590', 1000.80),
(2, '910-11', 500.00),
(3, '910-11', 600.50),
(4, '910-11', 700.70);
