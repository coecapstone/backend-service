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
public class FormWhetherPayFlightModel {
    private String Id;
    private String goingTo;
    private String whetherToPayAmount;
    private String whetherToPayReturningDate;
    private String whetherToPayDepartingDate;
    private String flightNumber;
    private String flightFrom;
    private String flightReference;
    private String birthday;
    private String airline;
}
