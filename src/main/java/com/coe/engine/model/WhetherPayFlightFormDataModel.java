package com.coe.engine.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class WhetherPayFlightFormDataModel {
    @JsonProperty(value="goingTo")
    private String goingTo;

    @JsonProperty(value="whetherToPayAmount")
    private String whetherToPayAmount;

    @JsonProperty(value="whetherToPayReturningDate")
    private String whetherToPayReturningDate;

    @JsonProperty(value="whetherToPayDepartingDate")
    private String whetherToPayDepartingDate;

    @JsonProperty(value="flightNumber")
    private String flightNumber;

    @JsonProperty(value="flightFrom")
    private String flightFrom;

    @JsonProperty(value="flightReference")
    private String flightReference;

    @JsonProperty(value="birthday")
    private String birthday;

    @JsonProperty(value="airline")
    private String airline;
}
