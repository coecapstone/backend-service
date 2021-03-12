package com.coe.engine.repository;

import com.coe.engine.mapper.FormMapper;
import com.coe.engine.model.Form;
import com.coe.engine.model.FormData;
import com.coe.engine.util.GeneridHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormRepo {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Form> getFormData() {
        MapSqlParameterSource pathtoInfo = new MapSqlParameterSource();
        return namedParameterJdbcTemplate.query(GeneridHelper.loadSql("sql/getFormData.sql"), pathtoInfo,
                new FormMapper());
    }

    public void insertFormData(final FormData formData) {
        Map<String, String> parameterMap = new HashMap<>();
        parameterMap.put("legal_firstname", formData.getLegalFirstName());
        parameterMap.put("legal_lastname", formData.getLegalLastName());
        namedParameterJdbcTemplate.update(GeneridHelper.loadSql("sql/insertFormData.sql"), parameterMap);
    }
}
