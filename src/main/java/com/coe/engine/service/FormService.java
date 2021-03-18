package com.coe.engine.service;

import com.coe.engine.model.FormAllRequestDataModel;
import com.coe.engine.model.FormReceivedTravelRequestModel;
import com.coe.engine.model.FormTravelRequestsModel;
import com.coe.engine.model.TableAllRequestDataModel;
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

    public void saveTravelRequestFormData(FormReceivedTravelRequestModel form) {
        String creatorNetId = form.getCreatorNetId();
        String type = form.getFormToSubmitType();
        String legalFirstName = form.getLegalFirstName();
        String legalLastName = form.getLegalLastName();
        String departure = form.getDeparture();
        String destination = form.getDestination();
        String reason = form.getReason();

        String unitName = form.getFormToSubmitUnit();
        String subunitName = form.getFormToSubmitSubunit();

        long unixTime = System.currentTimeMillis();
        String Id = type+"@"+creatorNetId+"@"+unixTime;
        System.out.println(Id);
//        Date currentTime = new Timestamp(unixTime);
//        System.out.println(unixTime);
//        System.out.println(currentTime);

        FormTravelRequestsModel travelRequest = new FormTravelRequestsModel(Id, type, legalFirstName, legalLastName,
                departure, destination, reason);
        formRepo.insertTravelRequestData(travelRequest);

        FormAllRequestDataModel requestData = new FormAllRequestDataModel(Id, creatorNetId, type, unitName, subunitName, new Timestamp(unixTime), "Pending Review");
        System.out.println(requestData.toString());
        formRepo.insertAllRequestData(requestData);
    }

    public List<TableAllRequestDataModel> getUserRequests(String netId) {
        List<FormAllRequestDataModel> formAllRequestDataModels = formRepo.getUserRequests(netId);
        List<TableAllRequestDataModel> tableAllRequestDataModels = new ArrayList<>();
        for (FormAllRequestDataModel request : formAllRequestDataModels) {
            String formType = request.getFormType();
            String formTypeName = "";
            if (formType.equals("rei")) formTypeName = "Reimbursement";
            else if (formType.equals("trarei")) formTypeName = "Traval Reimbursement";
            else if (formType.equals("pur")) formTypeName = "Purchase Request";
            else if (formType.equals("in")) formTypeName = "Pay an Invoice";
            else if (formType.equals("pro")) formTypeName = "Procard Receipt";
            else formTypeName = "Travel Request";
            Date createdTime = request.getCreatedTimeUTC();
            ZonedDateTime zdt = createdTime.toInstant().atZone(z);
            String createdTimePST = zdt.format(formatter);

            TableAllRequestDataModel allUserRequests = new TableAllRequestDataModel(request.getId(),
                    formTypeName , request.getUnitName(), request.getSubunitName(), createdTimePST, request.getApprovalStatus());
            tableAllRequestDataModels.add(allUserRequests);
        }
        return tableAllRequestDataModels;
    }
}
