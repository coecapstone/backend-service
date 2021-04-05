INSERT INTO form_travel_requests
(id, form_type, legal_firstname, legal_lastname, departure, destination, departing_date,
returning_date, reason)
VALUES
(:id, :form_type, :legal_firstname, :legal_lastname, :departure, :destination, :departing_date,
:returning_date, :reason);

