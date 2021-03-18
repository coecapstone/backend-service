package com.coe.engine.mapper;

import com.coe.engine.model.FormAllApprovalDataModel;
import com.coe.engine.model.FormAllRequestDataModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubunitRequestsMapper implements RowMapper  {
    @Override
    public FormAllApprovalDataModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new FormAllApprovalDataModel(rs.getString("id"), rs.getString("form_creator"),
                rs.getString("form_type"), rs.getTimestamp("created_time_UTC"), rs.getString("approval_status"));
    }
}
