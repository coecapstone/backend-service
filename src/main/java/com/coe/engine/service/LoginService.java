package com.coe.engine.service;

import com.coe.engine.model.LoginUnitSubunitModel;
import com.coe.engine.repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LoginService {
    @Autowired
    private LoginRepo loginRepo;

    public List<LoginUnitSubunitModel> getSubunitListAsApprover(String netId) {
        return loginRepo.getSubunitListAsApprover(netId);
    }

    public List<LoginUnitSubunitModel> getSubunitListAsFiscalStaff(String netId) {
        return loginRepo.getSubunitListAsFiscalStaff(netId);
    }

    public Integer getWhetherUserIsSystemAdministrator(String netId) {
        List<String> list = loginRepo.getWhetherUserIsSystemAdministrator(netId);
        if (list.size() > 0) {
            return 1;
        }
        return 0;
    }
}
