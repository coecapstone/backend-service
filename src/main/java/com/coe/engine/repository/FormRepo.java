package com.coe.engine.repository;

import com.coe.engine.mapper.AllRequestsMapper;
import com.coe.engine.mapper.DetailBudgetMapper;
import com.coe.engine.mapper.DetailTravelRequestMapper;
import com.coe.engine.mapper.DetailWhetherPayFlightMapper;
import com.coe.engine.model.BudgetNumberAmountModel;
import com.coe.engine.model.DetailTravelRequestModel;
import com.coe.engine.model.FormAllRequestDataModel;
import com.coe.engine.model.FormBudgetListModel;
import com.coe.engine.model.FormTravelRequestsModel;
import com.coe.engine.model.FormWhetherPayFlightModel;
import com.coe.engine.model.WhetherPayFlightFormDataModel;
import com.coe.engine.util.GeneridHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormRepo {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void insertBudgetListData(final FormBudgetListModel budgetList) {
        Map<String, String> parameterMap = new HashMap<>();
        parameterMap.put("form_id", budgetList.getId());
        parameterMap.put("budget_number", budgetList.getBudget_number());
        parameterMap.put("amount", budgetList.getAmount());
        namedParameterJdbcTemplate.update(GeneridHelper.loadSql("sql/insertBudgetList.sql"), parameterMap);
    }

    public void insertWhetherToPayFlightData(final FormWhetherPayFlightModel whetherPayFlight) {
        Map<String, String> parameterMap = new HashMap<>();
        parameterMap.put("form_id", whetherPayFlight.getId());
        parameterMap.put("going_to", whetherPayFlight.getGoingTo());
        parameterMap.put("whether_to_pay_amount", whetherPayFlight.getWhetherToPayAmount());
        parameterMap.put("whether_to_pay_returning_date", whetherPayFlight.getWhetherToPayReturningDate());
        parameterMap.put("whether_to_pay_departing_date", whetherPayFlight.getWhetherToPayDepartingDate());
        parameterMap.put("flight_number", whetherPayFlight.getFlightNumber());
        parameterMap.put("flight_from", whetherPayFlight.getFlightFrom());
        parameterMap.put("flight_reference", whetherPayFlight.getFlightReference());
        parameterMap.put("birthday", whetherPayFlight.getBirthday());
        parameterMap.put("airline", whetherPayFlight.getAirline());
        namedParameterJdbcTemplate.update(GeneridHelper.loadSql("sql/insertWhetherPayFlight.sql"), parameterMap);
    }

    public void insertTravelRequestData(final FormTravelRequestsModel travelRequest) {
        Map<String, String> parameterMap = new HashMap<>();
        parameterMap.put("id", travelRequest.getId());
        parameterMap.put("form_type", travelRequest.getFormType());
        parameterMap.put("legal_firstname", travelRequest.getLegalFirstName());
        parameterMap.put("legal_lastname", travelRequest.getLegalLastName());
        parameterMap.put("departure", travelRequest.getDeparture());
        parameterMap.put("destination", travelRequest.getDestination());
        parameterMap.put("departing_date", travelRequest.getDepartingDate());
        parameterMap.put("returning_date", travelRequest.getReturningDate());
        parameterMap.put("reason", travelRequest.getReason());
        namedParameterJdbcTemplate.update(GeneridHelper.loadSql("sql/insertTravelRequestData.sql"), parameterMap);
    }

    public void insertAllRequestData(final FormAllRequestDataModel requestData) {
        Map<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("id", requestData.getId());
        parameterMap.put("form_creator", requestData.getFormCreator());
        parameterMap.put("form_type", requestData.getFormType());
        parameterMap.put("unit_name", requestData.getUnitName());
        parameterMap.put("subunit_name", requestData.getSubunitName());
        parameterMap.put("created_time_UTC", requestData.getCreatedTimeUTC());
        namedParameterJdbcTemplate.update(GeneridHelper.loadSql("sql/insertAllRequestData.sql"), parameterMap);
    }

    public List<FormAllRequestDataModel> getUserRequests(final String netId) {
        MapSqlParameterSource pathInfo = new MapSqlParameterSource();
        pathInfo.addValue("form_creator", netId, Types.VARCHAR);
        return namedParameterJdbcTemplate.query(GeneridHelper.loadSql("sql/getUserRequestsViaNetId.sql"),
                pathInfo, new AllRequestsMapper());
    }

    public List<DetailTravelRequestModel> getTravelRequestDetail(final String requestId) {
        MapSqlParameterSource pathInfo = new MapSqlParameterSource();
        pathInfo.addValue("id", requestId, Types.VARCHAR);
        System.out.println(requestId);
        return namedParameterJdbcTemplate.query(GeneridHelper.loadSql("sql/getRequestDetail.sql"),
                pathInfo, new DetailTravelRequestMapper());
    }

    public List<BudgetNumberAmountModel> getTravelBudgetDetail(final String requestId) {
        MapSqlParameterSource pathInfo = new MapSqlParameterSource();
        pathInfo.addValue("form_id", requestId, Types.VARCHAR);
        return namedParameterJdbcTemplate.query(GeneridHelper.loadSql("sql/getBudgetDetail.sql"),
                pathInfo, new DetailBudgetMapper());
    }

    public List<WhetherPayFlightFormDataModel> getWhetherPayFlight(final String requestId) {
        MapSqlParameterSource pathInfo = new MapSqlParameterSource();
        pathInfo.addValue("form_id", requestId, Types.VARCHAR);
        return namedParameterJdbcTemplate.query(GeneridHelper.loadSql("sql/getWhetherPayFlight.sql"),
                pathInfo, new DetailWhetherPayFlightMapper());
    }
}
