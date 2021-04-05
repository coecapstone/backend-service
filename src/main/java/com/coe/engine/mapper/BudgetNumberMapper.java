package com.coe.engine.mapper;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BudgetNumberMapper implements RowMapper {
    @Override
    public String mapRow(ResultSet rs, int rowNum) throws SQLException {
        return rs.getString("budget_number");
    }
}
