package com.coe.engine.service;

import com.coe.engine.model.FormTypeDataModel;
import com.coe.engine.repository.StaticRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StaticService {
    @Autowired
    private StaticRepo staticRepo;

    public List<FormTypeDataModel> getFormTypeData() {
        return staticRepo.getFormTypeData();
    }

    public List<String> getUnitsData() {
        return staticRepo.getUnitsData();
    }

    public List<String> getSubunitsData(String unit) {
        return staticRepo.getSubunitsData(unit);
    }
}
