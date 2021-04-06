package com.coe.engine.mapper;

import com.coe.engine.model.DetailTravelRequestModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DetailTravelRequestMapper implements RowMapper {
    @Override
    public DetailTravelRequestModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new DetailTravelRequestModel(rs.getString("form_type"), rs.getString("legal_firstname"),
                rs.getString("legal_lastname"), rs.getString("departure"), rs.getString("destination"),
                rs.getString("departing_date"), rs.getString("returning_date"),
                rs.getString("reason"), rs.getString("unit_name"), rs.getString("subunit_name"),
                rs.getTimestamp("created_time_UTC"), rs.getString("approval_status"), rs.getString("declined_reason"));
    }
}
