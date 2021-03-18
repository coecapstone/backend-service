package com.coe.engine.repository;

import com.coe.engine.model.FormAllRequestDataModel;
import com.coe.engine.model.FormTravelRequestsModel;
import com.coe.engine.util.GeneridHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.Map;

public class FormRepo {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void insertTravelRequestData(final FormTravelRequestsModel travelRequest) {
        Map<String, String> parameterMap = new HashMap<>();
        parameterMap.put("id", travelRequest.getId());
        parameterMap.put("form_type", travelRequest.getFormType());
        parameterMap.put("legal_firstname", travelRequest.getLegalFirstName());
        parameterMap.put("legal_lastname", travelRequest.getLegalLastName());
        parameterMap.put("departure", travelRequest.getDeparture());
        parameterMap.put("destination", travelRequest.getDestination());
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
        parameterMap.put("created_time_UTC", requestData.getCreatedTime());
        namedParameterJdbcTemplate.update(GeneridHelper.loadSql("sql/insertAllRequestData.sql"), parameterMap);
    }

//    public List<FormAllRequestTableModel> getUserRequests(final String netId) {
//        MapSqlParameterSource pathInfo = new MapSqlParameterSource();
//        pathInfo.addValue("netId", netId, Types.VARCHAR);
//        return namedParameterJdbcTemplate.query(GeneridHelper.loadSql("sql/getUserRequestsViaNetId.sql"),
//                pathInfo, new AllRequestsMapper());
//    }
}
