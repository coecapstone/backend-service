UPDATE form_all_requests
SET approval_status = 'Approved by approver', declined_reason=null
WHERE id=:id;
