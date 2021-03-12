package com.coe.engine.controller;

import com.coe.engine.model.ProfileDataModel;
import com.coe.engine.service.LoginService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private static final String TEXT_PLAIN = "text/plain";

    @Autowired
    private LoginService loginService;

    @ApiOperation(
            value = "User profile load",
            notes = "record user profile info",
            tags = "Login",
            httpMethod = "POST",
            produces = TEXT_PLAIN
    )
    @RequestMapping(value = "/api/login", method = RequestMethod.POST, produces = TEXT_PLAIN)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public final String loadUserProfile(@RequestBody ProfileDataModel profile) {
        return loginService.loadUserProfile(profile);
    }
}
