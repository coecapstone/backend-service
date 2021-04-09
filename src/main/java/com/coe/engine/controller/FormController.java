package com.coe.engine.controller;

import com.coe.engine.model.BudgetNumberAmountModel;
import com.coe.engine.model.FormReceivedTravelRequestModel;
import com.coe.engine.model.TableAllRequestDataModel;
import com.coe.engine.model.WhetherPayFlightFormDataModel;
import com.coe.engine.service.FormService;
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
public class FormController {
    private static final String TEXT_PLAIN = "text/plain";
    private static final String APPLICATION_JSON = "application/json";

    @Autowired
    private FormService formService;

    @ApiOperation(
            value = "Submit Travel Request Form Data",
            notes = "record travel request form data",
            tags = "Form",
            httpMethod = "POST",
            produces = TEXT_PLAIN
    )
    @RequestMapping(value = "/api/saveTravelRequestForm", method = RequestMethod.POST, produces = TEXT_PLAIN)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public final void saveFormData(@RequestBody FormReceivedTravelRequestModel form) throws Exception {
        formService.saveTravelRequestFormData(form);
    }

    @ApiOperation(
            value = "Get All Users' Requests",
            notes = "get all of the User's requests",
            tags = "Form",
            httpMethod = "GET",
            produces = APPLICATION_JSON
    )
    @RequestMapping(value = "/api/getUserRequests/{netId}", method = RequestMethod.GET, produces = APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public final List<TableAllRequestDataModel> getUserRequests(
            @ApiParam(name = "netId",
                    value = "NetID",
                    example = "johndoe",
                    required = true)
            @PathVariable("netId") String netId) {
        return formService.getUserRequests(netId);
    }

    @ApiOperation(
            value = "Get One Request's Detail",
            notes = "get one request's detail",
            tags = "Form",
            httpMethod = "GET",
            produces = APPLICATION_JSON
    )
    @RequestMapping(value = "/api/getRequestDetail/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public final List<Object> getRequestDetail(
            @ApiParam(name = "id",
                    value = "id",
                    example = "tra@yangx38@1616062760892",
                    required = true)
            @PathVariable("id") String id) {
        String[] split = id.split("@");
        if(split[0].equals("tra")) {
            return formService.getTravelRequestDetail(id);
        }
        return null;
    }

    @ApiOperation(
            value = "Get One Budget's Detail",
            notes = "get one budget's detail",
            tags = "Form",
            httpMethod = "GET",
            produces = APPLICATION_JSON
    )
    @RequestMapping(value = "/api/getBudgetDetail/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public final List<BudgetNumberAmountModel> getBudgetDetail(
            @ApiParam(name = "id",
                    value = "id",
                    example = "tra@yangx38@1616062760892",
                    required = true)
            @PathVariable("id") String id) {
        String[] split = id.split("@");
        if(split[0].equals("tra")) {
            return formService.getTravelBudgetDetail(id);
        }
        return null;
    }

    @ApiOperation(
            value = "Get One Whether To Pay Flight's Detail",
            notes = "get one whether to pay flight's detail",
            tags = "Form",
            httpMethod = "GET",
            produces = APPLICATION_JSON
    )
    @RequestMapping(value = "/api/getWhetherPayFlight/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public final List<WhetherPayFlightFormDataModel> getWhetherPayFlight(
            @ApiParam(name = "id",
                    value = "id",
                    example = "tra@yangx38@1616062760892",
                    required = true)
            @PathVariable("id") String id) {
        String[] split = id.split("@");
        if(split[0].equals("tra")) {
            return formService.getWhetherPayFlight(id);
        }
        return null;
    }
}
