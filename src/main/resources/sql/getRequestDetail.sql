SELECT form_travel_requests.form_type as form_type,
form_travel_requests.legal_firstname as legal_firstname,
form_travel_requests.legal_lastname as legal_lastname,
form_travel_requests.departure as departure,
form_travel_requests.destination as destination,
form_travel_requests.departing_date as departing_date,
form_travel_requests.returning_date as returning_date,
form_travel_requests.reason as reason,
form_all_requests.unit_name as unit_name,
form_all_requests.subunit_name as subunit_name,
form_all_requests.created_time_UTC as created_time_UTC,
form_all_requests.approval_status as approval_status,
form_all_requests.declined_reason as declined_reason
FROM form_travel_requests
LEFT JOIN form_all_requests
ON form_travel_requests.id = form_all_requests.id
where form_travel_requests.id=:id;
