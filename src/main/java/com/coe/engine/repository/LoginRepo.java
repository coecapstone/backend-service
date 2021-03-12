package com.coe.engine.repository;

import com.coe.engine.mapper.FormMapper;
import com.coe.engine.model.FormTypeDataModel;
import com.coe.engine.model.ProfileDataModel;
import com.coe.engine.util.GeneridHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginRepo {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<FormTypeDataModel> getFormData() {
        MapSqlParameterSource pathtoInfo = new MapSqlParameterSource();
        return namedParameterJdbcTemplate.query(GeneridHelper.loadSql("sql/getFormData.sql"), pathtoInfo,
                new FormMapper());
    }

    public void insertProfileData(final ProfileDataModel profileData) {
        Map<String, String> parameterMap = new HashMap<>();
        parameterMap.put("email", profileData.getEmail());
        parameterMap.put("imageUrl", profileData.getImageUrl());
        parameterMap.put("name", profileData.getName());
        System.out.println(profileData.getEmail());
        System.out.println(profileData.getImageUrl());
        System.out.println(profileData.getName());
        namedParameterJdbcTemplate.update(GeneridHelper.loadSql("sql/insertProfileData.sql"), parameterMap);
    }
}
