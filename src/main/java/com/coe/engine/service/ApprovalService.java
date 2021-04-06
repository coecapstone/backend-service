package com.coe.engine.service;

import com.coe.engine.model.FormAllApprovalDataModel;
import com.coe.engine.model.TableAllApprovalDataModel;
import com.coe.engine.repository.ApprovalRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApprovalService {
    private static final ZoneId z = ZoneId.of( "America/Los_Angeles" );
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy-HH:mm");

    @Autowired
    private ApprovalRepo approvalRepo;

    private String getFormName(String formType) {
        String formTypeName = "";
        if (formType.equals("rei")) formTypeName = "Reimbursement";
        else if (formType.equals("trarei")) formTypeName = "Traval Reimbursement";
        else if (formType.equals("pur")) formTypeName = "Purchase Request";
        else if (formType.equals("in")) formTypeName = "Pay an Invoice";
        else if (formType.equals("pro")) formTypeName = "Procard Receipt";
        else formTypeName = "Travel Request";
        return formTypeName;
    }

    private String getCreatedTimePST(Date createdTime) {
        ZonedDateTime zdt = createdTime.toInstant().atZone(z);
        return zdt.format(formatter);
    }

    public List<TableAllApprovalDataModel> getSubunitRequests(String unitName, String subunitName) {
        List<FormAllApprovalDataModel> formAllApprovalDataModels = approvalRepo.getSubunitRequests(unitName, subunitName);
        List<TableAllApprovalDataModel> tableAllApprovalDataModels = new ArrayList<>();
        for (FormAllApprovalDataModel approval : formAllApprovalDataModels) {
            String formTypeName = getFormName(approval.getFormType());
            String createdTimePST = getCreatedTimePST(approval.getCreatedTimeUTC());
            TableAllApprovalDataModel allSubunitRequests = new TableAllApprovalDataModel(approval.getId(),
                    approval.getFormCreator(), formTypeName , createdTimePST, approval.getApprovalStatus());
            tableAllApprovalDataModels.add(allSubunitRequests);
        }
        return tableAllApprovalDataModels;
    }

    public void approveRequest(String id) {
        approvalRepo.approveRequest(id);
    }

    public void declineRequest(String id, String reason) {
        approvalRepo.declineRequest(id, reason);
    }
}
