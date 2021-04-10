package com.coe.engine.controller;

import com.coe.engine.model.LoginUnitSubunitModel;
import com.coe.engine.service.LoginService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
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
            value = "Endpoint to get user's subunit list as approver",
            notes = "get user's subunit list as approver",
            tags = "Login",
            httpMethod = "GET",
            produces = APPLICATION_JSON
    )
    @RequestMapping(value = "/api/getSubunitListAsApprover/{netId}", method = RequestMethod.GET, produces = APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public final List<LoginUnitSubunitModel> getSubunitListAsApprover(
            @ApiParam(name = "netId",
                value = "NetID",
                example = "johndoe",
                required = true)
            @PathVariable("netId") String netId) {
        return loginService.getSubunitListAsApprover(netId);
    }

    @ApiOperation(
            value = "Endpoint to get user's subunit list as fiscal staff",
            notes = "get user's subunit list as fiscal staff",
            tags = "Login",
            httpMethod = "GET",
            produces = APPLICATION_JSON
    )
    @RequestMapping(value = "/api/getSubunitListAsFiscalStaff/{netId}", method = RequestMethod.GET, produces = APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public final List<LoginUnitSubunitModel> getSubunitListAsFiscalStaff(
            @ApiParam(name = "netId",
                    value = "NetID",
                    example = "johndoe",
                    required = true)
            @PathVariable("netId") String netId) {
        return loginService.getSubunitListAsFiscalStaff(netId);
    }

    @ApiOperation(
            value = "Endpoint to check whether user is system administrator",
            notes = "check whether user is system administrator",
            tags = "Login",
            httpMethod = "GET",
            produces = APPLICATION_JSON
    )
    @RequestMapping(value = "/api/checkWhetherUserIsSystemAdministrator/{netId}", method = RequestMethod.GET, produces = APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public final Integer checkWhetherUserIsSystemAdministrator(
            @ApiParam(name = "netId",
                    value = "NetID",
                    example = "johndoe",
                    required = true)
            @PathVariable("netId") String netId) {
        return loginService.getWhetherUserIsSystemAdministrator(netId);
    }
}
