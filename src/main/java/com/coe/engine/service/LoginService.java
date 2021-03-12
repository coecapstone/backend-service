package com.coe.engine.service;

import com.coe.engine.model.ProfileDataModel;
import com.coe.engine.repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginService {
    @Autowired
    private LoginRepo loginRepo;

    public String loadUserProfile(ProfileDataModel profile) {
        String email = profile.getEmail();
        String name = profile.getName();
        String imageUrl = profile.getImageUrl();
        ProfileDataModel profileData = new ProfileDataModel(email, name, imageUrl);
        loginRepo.insertProfileData(profileData);
        return "";
    }
}
