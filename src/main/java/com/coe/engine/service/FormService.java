package com.coe.engine.service;

import com.coe.engine.model.FormAllRequestDataModel;
import com.coe.engine.model.FormReceivedTravelRequestModel;
import com.coe.engine.model.FormTravelRequestsModel;
import com.coe.engine.model.LoginModel;
import com.coe.engine.repository.FormRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class FormService {
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

//    public List<FormAllRequestDataModel> getUserRequests(String netId) {
//        return formRepo.getUserRequests(netId);
//    }
}
