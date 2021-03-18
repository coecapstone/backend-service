UPDATE form_all_requests
SET approval_status = 'Approved by approver'
WHERE id=:id;
