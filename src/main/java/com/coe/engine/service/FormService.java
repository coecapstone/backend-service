package com.coe.engine.service;

import com.coe.engine.model.Form;
import com.coe.engine.model.FormData;
import com.coe.engine.repository.FormRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FormService {
    @Autowired
    private FormRepo formRepo;

    public List<Form> getFormData() {
        return formRepo.getFormData();
    }

    public String saveFormData(FormData form) {
        String legalFirstName = form.getLegalFirstName();
        String legalLastName = form.getLegalLastName();
        FormData formdata = new FormData(legalFirstName, legalLastName);
        formRepo.insertFormData(formdata);
        return "";
    }
}
