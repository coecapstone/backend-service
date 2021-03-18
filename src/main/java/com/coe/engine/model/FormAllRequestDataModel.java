package com.coe.engine.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FormAllRequestDataModel {
    private String Id;
    private String formCreator;
    private String formType;
    private String unitName;
    private String subunitName;
    private Timestamp createdTime;
    private String approvalStatus;
}
