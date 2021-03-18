package com.coe.engine.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.coe.engine.model.FormTypeDataModel;
import org.springframework.jdbc.core.RowMapper;

public class FormMapper implements RowMapper {
    @Override
    public FormTypeDataModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new FormTypeDataModel(rs.getString("key"), rs.getString("text"), rs.getString("value"));
    }
}
