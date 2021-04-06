package com.coe.engine.mapper;

import com.coe.engine.model.BudgetNumberAmountModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DetailBudgetMapper implements RowMapper {
    @Override
    public BudgetNumberAmountModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new BudgetNumberAmountModel(rs.getString("budget_number"), rs.getString("amount"));
    }
}
