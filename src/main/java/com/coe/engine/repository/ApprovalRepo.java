package com.coe.engine.repository;

import com.coe.engine.mapper.SubunitRequestsMapper;
import com.coe.engine.model.FormAllApprovalDataModel;
import com.coe.engine.util.GeneridHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApprovalRepo {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<FormAllApprovalDataModel> getSubunitRequests(final String unitName, final String subunitName) {
        MapSqlParameterSource pathInfo = new MapSqlParameterSource();
        pathInfo.addValue("unit_name", unitName, Types.VARCHAR);
        pathInfo.addValue("subunit_name", subunitName, Types.VARCHAR);
        return namedParameterJdbcTemplate.query(GeneridHelper.loadSql("sql/getSubunitRequestsViaUnitnameSubunitName.sql"),
                pathInfo, new SubunitRequestsMapper());
    }

    public void approveRequest(final String id) {
        Map<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("id", id);
        namedParameterJdbcTemplate.update(GeneridHelper.loadSql("sql/approveRequest.sql"), parameterMap);
    }
}
