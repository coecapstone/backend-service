package com.coe.engine.mapper;

import com.coe.engine.model.WhetherPayFlightFormDataModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DetailWhetherPayFlightMapper implements RowMapper {
    @Override
    public WhetherPayFlightFormDataModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new WhetherPayFlightFormDataModel(rs.getString("going_to"), rs.getString("whether_to_pay_amount"),
                rs.getString("whether_to_pay_returning_date"), rs.getString("whether_to_pay_departing_date"),
                rs.getString("flight_number"), rs.getString("flight_from"),
                rs.getString("flight_reference"), rs.getString("birthday"),
                rs.getString("airline"));
    }
}
