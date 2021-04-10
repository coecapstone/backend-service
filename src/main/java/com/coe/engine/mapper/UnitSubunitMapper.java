package com.coe.engine.mapper;

import com.coe.engine.model.LoginUnitSubunitModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UnitSubunitMapper implements RowMapper {
    @Override
    public LoginUnitSubunitModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new LoginUnitSubunitModel(rs.getString("unit_name"), rs.getString("subunit_name"));
    }
}

