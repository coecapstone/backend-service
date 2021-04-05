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
public class FormTravelRequestsModel {
    private String Id;
    private String formType;
    private String legalFirstName;
    private String legalLastName;
    private String departure;
    private String destination;
    private String departingDate;
    private String returningDate;
    private String reason;
}
