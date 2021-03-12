package com.coe.engine.service;

import com.coe.engine.model.FormTypeDataModel;
import com.coe.engine.model.TravelFormDataModel;
import com.coe.engine.repository.FormRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FormService {
    @Autowired
    private FormRepo formRepo;

    public List<FormTypeDataModel> getFormData() {
        return formRepo.getFormData();
    }

    public String saveFormData(TravelFormDataModel form) {
        String legalFirstName = form.getLegalFirstName();
        String legalLastName = form.getLegalLastName();
        TravelFormDataModel formdata = new TravelFormDataModel(legalFirstName, legalLastName);
        formRepo.insertFormData(formdata);
        return "";
    }
}
