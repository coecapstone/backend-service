package com.coe.engine.service;

import com.coe.engine.model.FormAllRequestDataModel;
import com.coe.engine.model.FormReceivedTravelRequestModel;
import com.coe.engine.model.FormTravelRequestsModel;
import com.coe.engine.repository.FormRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.Date;

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

        String unitName = form.getFormToSubmitUnit();
        String subunitName = form.getFormToSubmitSubunit();

        long unixTime = System.currentTimeMillis();
        String Id = type+"@"+creatorNetId+"@"+unixTime;
        System.out.println(Id);
//        Date currentTime = new Timestamp(unixTime);
//        System.out.println(unixTime);
//        System.out.println(currentTime);

        FormTravelRequestsModel travelRequest = new FormTravelRequestsModel(Id, type, legalFirstName, legalLastName, departure, destination);
        formRepo.insertTravelRequestData(travelRequest);

        FormAllRequestDataModel requestData = new FormAllRequestDataModel(Id, creatorNetId, type, unitName, subunitName, unixTime);
        System.out.println(requestData.toString());
        formRepo.insertAllRequestData(requestData);

       // formRepo.getTravelRequestId();
//        public List<LoginModel> getUserRole(String netId) {
//            return loginRepo.getUserRole(netId);
//        }
        //AllRequestDataModel travelRequest = new AllRequestDataModel(type, legalFirstName, legalLastName, departure, destination);
        //staticRepo.insertFormData(formData);
    }
}
