package com.coe.engine.controller;

import com.coe.engine.model.BudgetNumberTableModel;
import com.coe.engine.model.DropdownDataModel;
import com.coe.engine.model.FormReceivedTravelRequestModel;
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
    public final List<DropdownDataModel> getAllForms() {
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
            value = "Get all system administrators",
            notes = "Get all system administrators",
            tags = "Static",
            httpMethod = "GET",
            produces = APPLICATION_JSON
    )
    @RequestMapping(value = "/api/getAllSystemAdministrators", method = RequestMethod.GET, produces = APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public final List<String> getAllSystemAdministrators() throws Exception {
        return staticService.getAllSystemAdministrators();
    }

    @ApiOperation(
            value = "Get all budget list",
            notes = "Get all the budgets list",
            tags = "Budget",
            httpMethod = "GET",
            produces = APPLICATION_JSON
    )
    @RequestMapping(value = "/api/getAllBudgetsList", method = RequestMethod.GET, produces = APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public final List<BudgetNumberTableModel> getAllBudgetsList() throws Exception {
        return staticService.getAllBudgetsList();
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

    @ApiOperation(
            value = "Get subunit's budget list given unit",
            notes = "Get all the subunits",
            tags = "Budget",
            httpMethod = "GET",
            produces = APPLICATION_JSON
    )
    @RequestMapping(value = "/api/getBudgets/{unit}/{subunit}", method = RequestMethod.GET, produces = APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public final List<DropdownDataModel> getBudgetofSubunit(
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
        return staticService.getBudgetOfSubunit(unit, subunitStr);
    }

    @ApiOperation(
            value = "Add Unit Name to the unit table",
            notes = "Add Unit Name to the unit table",
            tags = "Static",
            httpMethod = "POST",
            produces = APPLICATION_JSON
    )
    @RequestMapping(value = "/api/appendUnitName/{unit}", method = RequestMethod.POST, produces = APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public final void appendUnitName(
            @ApiParam(name = "unit",
                    value = "unit",
                    example = "Electrical & Computer Engineering",
                    required = true)
            @PathVariable("unit") String unit) {
        staticService.appendUnitName(unit);
    }

    @ApiOperation(
            value = "Append Budget to Budget Table",
            notes = "append budget to budget table",
            tags = "Budget",
            httpMethod = "POST",
            produces = APPLICATION_JSON
    )
    @RequestMapping(value = "/api/appendBudget", method = RequestMethod.POST, produces = APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public final void appendBudget(@RequestBody BudgetNumberTableModel budget) throws Exception {
        staticService.appendBudget(budget);
    }

    @ApiOperation(
            value = "Remove Budget to Budget Table",
            notes = "Remove budget to budget table",
            tags = "Budget",
            httpMethod = "POST",
            produces = APPLICATION_JSON
    )
    @RequestMapping(value = "/api/removeBudget", method = RequestMethod.POST, produces = APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public final void removeBudget(@RequestBody BudgetNumberTableModel budget) throws Exception {
        staticService.removeBudget(budget);
    }

    @ApiOperation(
            value = "Remove the unit from the unit table",
            notes = "Remove the unit from the unit table",
            tags = "Static",
            httpMethod = "POST",
            produces = APPLICATION_JSON
    )
    @RequestMapping(value = "/api/removeUnitName/{unit}", method = RequestMethod.POST, produces = APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public final void removeUnitName(
            @ApiParam(name = "unit",
                    value = "unit",
                    example = "Electrical & Computer Engineering",
                    required = true)
            @PathVariable("unit") String unit) {
        staticService.removeUnitName(unit);
    }

    @ApiOperation(
            value = "Add Unit Name to the unit table",
            notes = "Add Unit Name to the unit table",
            tags = "Static",
            httpMethod = "POST",
            produces = APPLICATION_JSON
    )
    @RequestMapping(value = "/api/appendSubunitName/{unit}/{subunit}", method = RequestMethod.POST, produces = APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public final void appendSubunitName(
            @ApiParam(name = "unit",
                    value = "unit",
                    example = "ECE",
                    required = true)
            @PathVariable("unit") String unit,
            @ApiParam(name = "subunit",
                    value = "subunit",
                    example = "Electrical & Computer Engineering Subunit",
                    required = true)
            @PathVariable("subunit") String subunit) {
        staticService.appendSubunitName(unit, subunit);
    }

    @ApiOperation(
            value = "Remove Unit Name to the unit table",
            notes = "Remove Unit Name to the unit table",
            tags = "Static",
            httpMethod = "POST",
            produces = APPLICATION_JSON
    )
    @RequestMapping(value = "/api/removeSubunitName/{unit}/{subunit}", method = RequestMethod.POST, produces = APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public final void removeSubunitName(
            @ApiParam(name = "unit",
                    value = "unit",
                    example = "ECE",
                    required = true)
            @PathVariable("unit") String unit,
            @ApiParam(name = "subunit",
                    value = "subunit",
                    example = "Electrical & Computer Engineering Subunit",
                    required = true)
            @PathVariable("subunit") String subunit) {
        staticService.removeSubunitName(unit, subunit);
    }

    @ApiOperation(
            value = "Add NetID to the system administrator table",
            notes = "Add NetID to the system administrator table",
            tags = "Static",
            httpMethod = "POST",
            produces = APPLICATION_JSON
    )
    @RequestMapping(value = "/api/appendSystemAdministrator/{systemAdministratorNetID}", method = RequestMethod.POST, produces = APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public final void appendSystemAdministrator(
            @ApiParam(name = "systemAdministratorNetID",
                    value = "systemAdministratorNetID",
                    example = "yangx38",
                    required = true)
            @PathVariable("systemAdministratorNetID") String systemAdministratorNetID) {
        staticService.appendSystemAdministrator(systemAdministratorNetID);
    }

    @ApiOperation(
            value = "Remove NetID to the system administrator table",
            notes = "Remove NetID to the system administrator table",
            tags = "Static",
            httpMethod = "POST",
            produces = APPLICATION_JSON
    )
    @RequestMapping(value = "/api/removeSystemAdministrator/{systemAdministratorNetID}", method = RequestMethod.POST, produces = APPLICATION_JSON)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public final void removeSystemAdministrator(
            @ApiParam(name = "systemAdministratorNetID",
                    value = "systemAdministratorNetID",
                    example = "yangx38",
                    required = true)
            @PathVariable("systemAdministratorNetID") String systemAdministratorNetID) {
        staticService.removeSystemAdministrator(systemAdministratorNetID);
    }
}
