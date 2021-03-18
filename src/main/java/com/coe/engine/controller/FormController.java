package com.coe.engine.controller;

import com.coe.engine.model.FormReceivedTravelRequestModel;
import com.coe.engine.service.FormService;
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
public class FormController {
    private static final String TEXT_PLAIN = "text/plain";
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
}
