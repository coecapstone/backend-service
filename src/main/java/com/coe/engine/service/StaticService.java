package com.coe.engine.service;

import com.coe.engine.model.BudgetNumberTableModel;
import com.coe.engine.model.DropdownDataModel;
import com.coe.engine.repository.StaticRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class StaticService {
    @Autowired
    private StaticRepo staticRepo;

    public List<DropdownDataModel> getFormTypeData() {
        return staticRepo.getFormTypeData();
    }

    public List<String> getUnitsData() { return staticRepo.getUnitsData(); }

    public List<String> getAllSystemAdministrators() { return staticRepo.getAllSystemAdministrators(); }

    public List<BudgetNumberTableModel> getAllBudgetsList() { return staticRepo.getAllBudgetsList(); }

    public List<String> getSubunitsData(String unit) {
        return staticRepo.getSubunitsData(unit);
    }

    public List<DropdownDataModel> getBudgetOfSubunit(String unit, String subunit) {
        List<Integer> subunitId = staticRepo.getSubunitId(unit, subunit);
        List<String> budgetNumbers;
        List<DropdownDataModel> resBudgetNumbers = new ArrayList<>();
        if(subunitId.size() > 0) {
            budgetNumbers = staticRepo.getBudgetsubunitId(subunitId.get(0));
            for (String budgetNumber : budgetNumbers) {
                System.out.println(budgetNumber);
                resBudgetNumbers.add(new DropdownDataModel(budgetNumber, budgetNumber, budgetNumber));
            }
        }
        return resBudgetNumbers;
    }

    public void appendUnitName(String unit) { staticRepo.appendUnitName(unit); }

    public void removeUnitName(String unit) { staticRepo.removeUnitName(unit); }

    public void appendSubunitName(String unit, String subunit) { staticRepo.appendSubunitName(unit, subunit); }

    public void removeSubunitName(String unit, String subunit) { staticRepo.removeSubunitName(unit, subunit); }

    public void appendSystemAdministrator(String netID) { staticRepo.appendSystemAdministrator(netID); }

    public void removeSystemAdministrator(String netID) { staticRepo.removeSystemAdministrator(netID); }
}
