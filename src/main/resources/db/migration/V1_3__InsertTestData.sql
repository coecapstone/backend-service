INSERT INTO static_unit_info (`unit_name`) VALUES
('ECE'),
('ME'),
('MSE');

INSERT INTO static_subunit_info (`unit_name`, `subunit_name`) VALUES
('ECE', 'Info theory'),
('ECE', 'Network security'),
('ME', 'Robotics lab'),
('MSE', 'Klavin lab');

INSERT INTO static_approvers_info (`approver_netId`, `subunit_id`) VALUES
('sree', 1),
('baosen', 1),
('baosen', 2),
('yangx38', 1),
('yangx38', 2),
('yangx38', 3),
('yangx38', 4),
('dom', 4);

INSERT INTO static_budget_info (`subunit_id`, `budget_number`, `balance`) VALUES
(1, '910-11', 100.50),
(1, '910-22', 200.00),
(1, '910-33', 300.00),
(1, '910-45', 400.80),
(1, '910-590', 100080),
(2, '910-11', 500.00),
(3, '910-11', 600.50),
(4, '910-11', 700.70);
