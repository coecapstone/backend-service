package com.coe.engine.repository;

import com.coe.engine.mapper.BudgetNumberMapper;
import com.coe.engine.mapper.FormMapper;
import com.coe.engine.mapper.SubunitIdMapper;
import com.coe.engine.mapper.SubunitMapper;
import com.coe.engine.mapper.SystemAdministratorMapper;
import com.coe.engine.mapper.UnitMapper;
import com.coe.engine.model.DropdownDataModel;
import com.coe.engine.util.GeneridHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaticRepo {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<DropdownDataModel> getFormTypeData() {
        MapSqlParameterSource pathtoInfo = new MapSqlParameterSource();
        return namedParameterJdbcTemplate.query(GeneridHelper.loadSql("sql/getFormTypeData.sql"), pathtoInfo,
                new FormMapper());
    }

    public List<String> getUnitsData() {
        MapSqlParameterSource pathtoInfo = new MapSqlParameterSource();
        return namedParameterJdbcTemplate.query(GeneridHelper.loadSql("sql/getUnitsData.sql"), pathtoInfo,
                new UnitMapper());
    }

    public List<String> getAllSystemAdministrators() {
        MapSqlParameterSource pathtoInfo = new MapSqlParameterSource();
        return namedParameterJdbcTemplate.query(GeneridHelper.loadSql("sql/getAllSystemAdministrators.sql"), pathtoInfo,
                new SystemAdministratorMapper());
    }

    public List<String> getSubunitsData(String unit_name) {
        MapSqlParameterSource pathtoInfo = new MapSqlParameterSource();
        pathtoInfo.addValue("unit_name", unit_name, Types.VARCHAR);
        return namedParameterJdbcTemplate.query(GeneridHelper.loadSql("sql/getSubunitsData.sql"), pathtoInfo,
                new SubunitMapper());
    }

    public List<Integer> getSubunitId(String unit_name, String subunit_name) {
        MapSqlParameterSource pathtoInfo = new MapSqlParameterSource();
        pathtoInfo.addValue("unit_name", unit_name, Types.VARCHAR);
        pathtoInfo.addValue("subunit_name", subunit_name, Types.VARCHAR);
        return namedParameterJdbcTemplate.query(GeneridHelper.loadSql("sql/getSubunitId.sql"), pathtoInfo,
                new SubunitIdMapper());
    }

    public List<String> getBudgetsubunitId(Integer subunit_id) {
        MapSqlParameterSource pathtoInfo = new MapSqlParameterSource();
        pathtoInfo.addValue("subunit_id", subunit_id, Types.VARCHAR);
        return namedParameterJdbcTemplate.query(GeneridHelper.loadSql("sql/getBudgetNumbers.sql"), pathtoInfo,
                new BudgetNumberMapper());
    }

    public void appendUnitName(String unit_name) {
        Map<String, String> parameterMap = new HashMap<>();
        parameterMap.put("unit_name", unit_name);
        namedParameterJdbcTemplate.update(GeneridHelper.loadSql("sql/insertUnitName.sql"), parameterMap);
    }

    public void removeUnitName(String unit_name) {
        Map<String, String> parameterMap = new HashMap<>();
        parameterMap.put("unit_name", unit_name);
        namedParameterJdbcTemplate.update(GeneridHelper.loadSql("sql/removeUnitName.sql"), parameterMap);
    }

    public void appendSystemAdministrator(String netID) {
        Map<String, String> parameterMap = new HashMap<>();
        parameterMap.put("system_administrator_netId", netID);
        namedParameterJdbcTemplate.update(GeneridHelper.loadSql("sql/insertSystemAdministratorNetId.sql"), parameterMap);
    }

    public void removeSystemAdministrator(String netID) {
        Map<String, String> parameterMap = new HashMap<>();
        parameterMap.put("system_administrator_netId", netID);
        namedParameterJdbcTemplate.update(GeneridHelper.loadSql("sql/removeSystemAdministrator.sql"), parameterMap);
    }
}
