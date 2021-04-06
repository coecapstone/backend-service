package com.coe.engine.service;

import com.coe.engine.model.BudgetNumberAmountModel;
import com.coe.engine.model.DetailTravelRequestModel;
import com.coe.engine.model.FormAllRequestDataModel;
import com.coe.engine.model.FormBudgetListModel;
import com.coe.engine.model.FormReceivedTravelRequestModel;
import com.coe.engine.model.FormTravelRequestsModel;
import com.coe.engine.model.TableAllRequestDataModel;
import com.coe.engine.model.TableTravelRequestDetailModel;
import com.coe.engine.repository.FormRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FormService {
    private static final ZoneId z = ZoneId.of( "America/Los_Angeles" );
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy-HH:mm");

    @Autowired
    private FormRepo formRepo;

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

    public void saveTravelRequestFormData(FormReceivedTravelRequestModel form) {
        String creatorNetId = form.getCreatorNetId();
        String type = form.getFormToSubmitType();
        String legalFirstName = form.getLegalFirstName();
        String legalLastName = form.getLegalLastName();
        String departure = form.getDeparture();
        String destination = form.getDestination();
        String departingDate = form.getDepartingDate();
        String returningDate = form.getReturningDate();
        String reason = form.getReason();
        BudgetNumberAmountModel[] budgetNumberAndAmounts = form.getBudgetNumberAmountModel();

        // FormBudgetListModel budgetList = new FormBudgetListModel(Id, budgetNumberAndAmount.getBudget_number(), budgetNumberAndAmount.getAmount());
        // formRepo.insertBudgetListData(budgetList);
        String unitName = form.getFormToSubmitUnit();
        String subunitName = form.getFormToSubmitSubunit();

        long unixTime = System.currentTimeMillis();
        String Id = type+"@"+creatorNetId+"@"+unixTime;
        System.out.println(Id);
//        Date currentTime = new Timestamp(unixTime);
//        System.out.println(unixTime);
//        System.out.println(currentTime);
        for (BudgetNumberAmountModel budgetNumber_amount : budgetNumberAndAmounts) {
            FormBudgetListModel oneBudgetLine = new FormBudgetListModel(Id, budgetNumber_amount.getBudget_number(), budgetNumber_amount.getAmount());
            formRepo.insertBudgetListData(oneBudgetLine);
        }

        FormTravelRequestsModel travelRequest = new FormTravelRequestsModel(Id, type, legalFirstName, legalLastName,
                departure, destination, departingDate, returningDate, reason);
        formRepo.insertTravelRequestData(travelRequest);

        FormAllRequestDataModel requestData = new FormAllRequestDataModel(Id, creatorNetId, type, unitName, subunitName, new Timestamp(unixTime), "Pending Review");
        System.out.println(requestData.toString());
        formRepo.insertAllRequestData(requestData);
    }

    public List<TableAllRequestDataModel> getUserRequests(String netId) {
        List<FormAllRequestDataModel> formAllRequestDataModels = formRepo.getUserRequests(netId);
        List<TableAllRequestDataModel> tableAllRequestDataModels = new ArrayList<>();
        for (FormAllRequestDataModel request : formAllRequestDataModels) {
            String formTypeName = getFormName(request.getFormType());
            String createdTimePST = getCreatedTimePST(request.getCreatedTimeUTC());
            TableAllRequestDataModel allUserRequests = new TableAllRequestDataModel(request.getId(),
                    formTypeName , request.getUnitName(), request.getSubunitName(), createdTimePST, request.getApprovalStatus());
            tableAllRequestDataModels.add(allUserRequests);
        }
        return tableAllRequestDataModels;
    }

    public List<Object> getTravelRequestDetail(String requestId) {
        List<DetailTravelRequestModel> detailTravelRequests = formRepo.getTravelRequestDetail(requestId);
        List<Object> details = new ArrayList<>();
        for (DetailTravelRequestModel detail : detailTravelRequests) {
            String formTypeName = getFormName(detail.getFormType());
            String createdTimePST = getCreatedTimePST(detail.getCreatedTimeUTC());
            details.add(new TableTravelRequestDetailModel(formTypeName, detail.getLegalFirstName(), detail.getLegalLastName(),
                    detail.getDeparture(), detail.getDestination(), detail.getDepartingDate(), detail.getReturningDate(),
                    detail.getReason(), detail.getUnitName(), detail.getSubunitName(),
                    createdTimePST, detail.getApprovalStatus(), detail.getDeclinedReason()));
        }
        return details;
    }

    public List<BudgetNumberAmountModel> getTravelBudgetDetail(String requestId) {
        return formRepo.getTravelBudgetDetail(requestId);
    }
}
