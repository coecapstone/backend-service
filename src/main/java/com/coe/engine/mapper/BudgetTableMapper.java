package com.coe.engine.mapper;

import com.coe.engine.model.BudgetNumberTableModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BudgetTableMapper implements RowMapper {
    @Override
    public BudgetNumberTableModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new BudgetNumberTableModel(rs.getString("budget_number"), rs.getString("budget_name"));
    }
}
