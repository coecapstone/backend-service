INSERT INTO form_whether_to_pay_flight
(form_id, going_to, whether_to_pay_amount, whether_to_pay_returning_date, whether_to_pay_departing_date,
flight_number, flight_from, flight_reference, birthday, airline)
VALUES
(:form_id, :going_to, :whether_to_pay_amount, :whether_to_pay_returning_date, :whether_to_pay_departing_date,
:flight_number, :flight_from, :flight_reference, :birthday, :airline);
