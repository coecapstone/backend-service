package com.coe.engine.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.coe.engine.model.DropdownDataModel;
import org.springframework.jdbc.core.RowMapper;

public class FormMapper implements RowMapper {
    @Override
    public DropdownDataModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new DropdownDataModel(rs.getString("key"), rs.getString("text"), rs.getString("value"));
    }
}
