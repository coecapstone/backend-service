UPDATE form_all_requests
SET approval_status='Declined by approver', declined_reason=:declined_reason
WHERE id=:id;
