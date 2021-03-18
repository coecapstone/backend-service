SELECT id, form_creator, form_type, unit_name, subunit_name, created_time_UTC, approval_status
FROM form_all_requests
where form_creator=:form_creator;
