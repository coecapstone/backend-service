package com.coe.engine.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.coe.engine.model.Form;
import org.springframework.jdbc.core.RowMapper;

public class FormMapper implements RowMapper {
    @Override
    public Form mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Form(rs.getString("key"), rs.getString("text"), rs.getString("value"));
    }
}
