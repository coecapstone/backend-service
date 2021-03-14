package com.coe.engine.service;

import com.coe.engine.model.LoginModel;
import com.coe.engine.model.ProfileDataModel;
import com.coe.engine.repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LoginService {
    @Autowired
    private LoginRepo loginRepo;

    public List<Integer> getUserRole(String netId) {
        return loginRepo.getUserRole(netId);
    }
}
