package com.coe.engine.service;

import com.coe.engine.model.LoginModel;
import com.coe.engine.model.ProfileDataModel;
import com.coe.engine.repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LoginService {
    @Autowired
    private LoginRepo loginRepo;

    public List<LoginModel> getUserRole(String netId) {
        List<LoginModel> temp = loginRepo.getUserRole(netId);
        System.out.println('b');
        for(LoginModel t : temp)
            System.out.println(t);
        return temp;
    }
}
