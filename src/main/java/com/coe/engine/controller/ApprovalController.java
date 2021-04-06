package com.coe.engine.controller;

import com.coe.engine.model.TableAllApprovalDataModel;
import com.coe.engine.service.ApprovalService;
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
public class ApprovalController {
    private static final String TEXT_PLAIN = "text/plain";
    private static final String APPLICATION_JSON = "application/json";

    @Autowired
    private ApprovalService approvalService;

    @ApiOperation(
            value = "Get All Subunit' Requests",
            notes = "get all of the subunit's requests",
            tags = "Approval",
            httpMethod = "GET",
            produces = APPLICATION_JSON
    )
    @RequestMapping(value = "/api/getSubunitRequests/{unit}/{subunit}", method = RequestMethod.GET, produces = APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public final List<TableAllApprovalDataModel> getSubunitRequests(
            @ApiParam(name = "unit",
                    value = "unit",
                    example = "ECE",
                    required = true)
            @PathVariable("unit") String unit,
            @ApiParam(name = "subunit",
                    value = "subunit",
                    example = "Info-theory",
                    required = true)
            @PathVariable("subunit") String subunit) {
        String[] splitSubunit = subunit.split("-");
        StringBuilder subunitName = new StringBuilder();
        for (String sub : splitSubunit) {
            subunitName.append(sub);
            subunitName.append(" ");
        }
        String subunitStr = subunitName.deleteCharAt(subunitName.length()-1).toString();
        return approvalService.getSubunitRequests(unit, subunitStr);
    }

    @ApiOperation(
            value = "Approve one request",
            notes = "approve one request",
            tags = "Approval",
            httpMethod = "POST",
            produces = APPLICATION_JSON
    )
    @RequestMapping(value = "/api/approvalRequest/{id}", method = RequestMethod.POST, produces = APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public final void approveRequest(
            @ApiParam(name = "id",
                    value = "id",
                    example = "tra@yangx38@1616078966426",
                    required = true)
            @PathVariable("id") String id) {
        approvalService.approveRequest(id);
    }

    @ApiOperation(
            value = "Decline one request",
            notes = "decline one request",
            tags = "Approval",
            httpMethod = "POST",
            produces = APPLICATION_JSON
    )
    @RequestMapping(value = "/api/sendDeclineMessage/{id}", method = RequestMethod.POST, produces = APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public final void declineRequest(
            @ApiParam(name = "id",
                    value = "id",
                    example = "tra@yangx38@1616078966426",
                    required = true)
            @PathVariable("id") String id,
            @RequestBody String reason) {
        approvalService.declineRequest(id, reason);
    }
}
