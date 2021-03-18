package com.coe.engine.repository;

import com.coe.engine.mapper.FormMapper;
import com.coe.engine.mapper.SubunitMapper;
import com.coe.engine.mapper.UnitMapper;
import com.coe.engine.model.FormTypeDataModel;
import com.coe.engine.util.GeneridHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.Types;
import java.util.List;

public class StaticRepo {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<FormTypeDataModel> getFormTypeData() {
        MapSqlParameterSource pathtoInfo = new MapSqlParameterSource();
        return namedParameterJdbcTemplate.query(GeneridHelper.loadSql("sql/getFormTypeData.sql"), pathtoInfo,
                new FormMapper());
    }

    public List<String> getUnitsData() {
        MapSqlParameterSource pathtoInfo = new MapSqlParameterSource();
        return namedParameterJdbcTemplate.query(GeneridHelper.loadSql("sql/getUnitsData.sql"), pathtoInfo,
                new UnitMapper());
    }

    public List<String> getSubunitsData(String unit_name) {
        MapSqlParameterSource pathtoInfo = new MapSqlParameterSource();
        pathtoInfo.addValue("unit_name", unit_name, Types.VARCHAR);
        return namedParameterJdbcTemplate.query(GeneridHelper.loadSql("sql/getSubunitsData.sql"), pathtoInfo,
                new SubunitMapper());
    }
}
