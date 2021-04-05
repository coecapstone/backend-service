package com.coe.engine.mapper;

import com.coe.engine.model.LoginModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UnitSubunitMapper implements RowMapper {
    @Override
    public LoginModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new LoginModel(rs.getString("unit_name"), rs.getString("subunit_name"));
    }
}

