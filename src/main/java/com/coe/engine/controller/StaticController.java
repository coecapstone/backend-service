package com.coe.engine.controller;

import com.coe.engine.model.FormTypeDataModel;
import com.coe.engine.service.StaticService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StaticController {
    private static final String APPLICATION_JSON = "application/json";

    @Autowired
    private StaticService staticService;

    @ApiOperation(
            value = "Get all forms info",
            notes = "6 forms total",
            tags = "Static",
            httpMethod = "GET",
            produces = APPLICATION_JSON
    )
    @RequestMapping(value = "/api/getAllForms", method = RequestMethod.GET, produces = APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public final List<FormTypeDataModel> getAllForms() {
        return staticService.getFormTypeData();
    }

    @ApiOperation(
            value = "Get all unit info",
            notes = "Get all the units",
            tags = "Static",
            httpMethod = "GET",
            produces = APPLICATION_JSON
    )
    @RequestMapping(value = "/api/getAllUnits", method = RequestMethod.GET, produces = APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public final List<String> getAllUnits() throws Exception {
        return staticService.getUnitsData();
    }

    @ApiOperation(
            value = "Get subunit list given unit",
            notes = "Get all the subunits",
            tags = "Static",
            httpMethod = "GET",
            produces = APPLICATION_JSON
    )
    @RequestMapping(value = "/api/getSubunits/{unit}", method = RequestMethod.GET, produces = APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public final List<String> getSubunitsOfUnit(
            @ApiParam(name = "unit",
                    value = "unit",
                    example = "ECE",
                    required = true)
            @PathVariable("unit") String unit) {
        return staticService.getSubunitsData(unit);
    }
}
