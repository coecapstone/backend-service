package com.coe.engine.controller;

import com.coe.engine.model.Form;
import com.coe.engine.model.FormData;
import com.coe.engine.service.FormService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FormController {
    private static final String APPLICATION_JSON = "application/json";
    private static final String TEXT_PLAIN = "text/plain";

    @Autowired
    private FormService formService;

    @ApiOperation(
            value = "Get Form info",
            notes = "6 forms total",
            tags = "Form",
            httpMethod = "GET",
            produces = APPLICATION_JSON
    )
    @RequestMapping(value = "/api/getAllForms", method = RequestMethod.GET, produces = APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public final List<Form> getAllForm() {
        return formService.getFormData();
    }

    @ApiOperation(
            value = "Submit Form info",
            notes = "record submit form info",
            tags = "Form",
            httpMethod = "POST",
            produces = TEXT_PLAIN
    )
    @RequestMapping(value = "/api/saveFormData", method = RequestMethod.POST, produces = TEXT_PLAIN)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public final String saveFormData(@RequestBody FormData form) throws Exception {
        return formService.saveFormData(form);
    }
}
