INSERT INTO form_all_requests (id, form_creator, form_type, unit_name, subunit_name, created_time_UTC, approval_status)
VALUES (:id, :form_creator, :form_type, :unit_name, :subunit_name, :created_time_UTC, 'Pending Review');

