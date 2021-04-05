package com.coe.engine.repository;

import com.coe.engine.mapper.FormMapper;
import com.coe.engine.mapper.UnitSubunitMapper;
import com.coe.engine.model.DropdownDataModel;
import com.coe.engine.model.LoginModel;
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

    public List<LoginModel> getUserRole(final String approver_netId) {
        MapSqlParameterSource pathInfo = new MapSqlParameterSource();
        pathInfo.addValue("approver_netId", approver_netId, Types.VARCHAR);
        return namedParameterJdbcTemplate.query(GeneridHelper.loadSql("sql/getUserRoleViaNetId.sql"),
                pathInfo, new UnitSubunitMapper());
//        Map<String, String> parameterMap = new HashMap<>();
//        parameterMap.put("email", profileData.getEmail());
//        parameterMap.put("imageUrl", profileData.getImageUrl());
//        parameterMap.put("name", profileData.getName());
//        System.out.println(profileData.getEmail());
//        System.out.println(profileData.getImageUrl());
//        System.out.println(profileData.getName());
//        namedParameterJdbcTemplate.update(GeneridHelper.loadSql("sql/getUserRoleViaNetId.sql"), parameterMap);
    }
}
