SELECT subunit_info.unit_name as unit_name, subunit_info.subunit_name as subunit_name
FROM approvers_info
LEFT JOIN subunit_info
ON approvers_info.subunit_id = subunit_info.subunit_id
where approvers_info.approver_netId=:approver_netId;
