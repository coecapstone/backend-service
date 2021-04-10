package com.coe.engine.repository;

import com.coe.engine.mapper.FormMapper;
import com.coe.engine.mapper.SystemAdministratorMapper;
import com.coe.engine.mapper.UnitSubunitMapper;
import com.coe.engine.model.DropdownDataModel;
import com.coe.engine.model.LoginUnitSubunitModel;
import com.coe.engine.util.GeneridHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.Types;
import java.util.List;

public class LoginRepo {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<DropdownDataModel> getFormData() {
        MapSqlParameterSource pathtoInfo = new MapSqlParameterSource();
        return namedParameterJdbcTemplate.query(GeneridHelper.loadSql("sql/getFormTypeData.sql"), pathtoInfo,
                new FormMapper());
    }

    public List<LoginUnitSubunitModel> getSubunitListAsApprover(final String netId) {
        MapSqlParameterSource pathInfo = new MapSqlParameterSource();
        pathInfo.addValue("approver_netId", netId, Types.VARCHAR);
        return namedParameterJdbcTemplate.query(GeneridHelper.loadSql("sql/getSubunitListAsApprover.sql"),
                pathInfo, new UnitSubunitMapper());
    }

    public List<LoginUnitSubunitModel> getSubunitListAsFiscalStaff(final String netId) {
        MapSqlParameterSource pathInfo = new MapSqlParameterSource();
        pathInfo.addValue("fiscal_staff_netId", netId, Types.VARCHAR);
        return namedParameterJdbcTemplate.query(GeneridHelper.loadSql("sql/getSubunitListAsFiscalStaff.sql"),
                pathInfo, new UnitSubunitMapper());
    }

    public List<String> getWhetherUserIsSystemAdministrator(final String netId) {
        MapSqlParameterSource pathInfo = new MapSqlParameterSource();
        pathInfo.addValue("system_administrator_netId", netId, Types.VARCHAR);
        return namedParameterJdbcTemplate.query(GeneridHelper.loadSql("sql/getWhetherUserIsSystemAdministrator.sql"),
                pathInfo, new SystemAdministratorMapper());
    }
}
