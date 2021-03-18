//package com.coe.engine.mapper;
//
//import com.coe.engine.model.FormAllRequestDataModel;
//import org.springframework.jdbc.core.RowMapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class AllRequestsMapper implements RowMapper {
//    @Override
//    public FormAllRequestTableModel mapRow(ResultSet rs, int rowNum) throws SQLException {
//        return new FormAllRequestDataModel(rs.getString("id"), rs.getString("form_type"),
//                rs.getString("unit_name"), rs.getString("subunit_name"),
//                rs.getTimestamp("created_time_UTC"), rs.getInt("approval_status"));
//    }
//}
