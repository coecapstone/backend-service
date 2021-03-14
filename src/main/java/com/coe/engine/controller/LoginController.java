package com.coe.engine.controller;

import com.coe.engine.model.LoginModel;
import com.coe.engine.model.ProfileDataModel;
import com.coe.engine.service.LoginService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {
    private static final String APPLICATION_JSON = "application/json";

    @Autowired
    private LoginService loginService;

    @ApiOperation(
            value = "Endpoint to get user role",
            notes = "check whether user is approver",
            tags = "Login",
            httpMethod = "GET",
            produces = APPLICATION_JSON
    )
    @RequestMapping(value = "/api/getUserRole/{netId}", method = RequestMethod.GET, produces = APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public final List<LoginModel> getUserRole(
            @ApiParam(name = "netId",
                value = "NetID",
                example = "johndoe",
                required = true)
            @PathVariable("netId") String netId) {
        return loginService.getUserRole(netId);
    }
}
