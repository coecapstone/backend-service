package com.coe.engine.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TableAllApprovalDataModel {
    private String Id;
    private String formCreator;
    private String formType;
    private String createdTimePST;
    private String approvalStatus;
}
