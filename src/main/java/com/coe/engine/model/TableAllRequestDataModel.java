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
public class TableAllRequestDataModel {
    private String Id;
    private String formType;
    private String unitName;
    private String subunitName;
    private String createdTimePST;
    private String approvalStatus;
}
