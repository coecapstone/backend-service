package com.coe.engine.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class FormReceivedTravelRequestModel {
    @JsonProperty(value = "creatorNetId")
    private String creatorNetId;

    @JsonProperty(value = "formToSubmitType")
    private String formToSubmitType;

    @JsonProperty(value = "formToSubmitUnit")
    private String formToSubmitUnit;

    @JsonProperty(value = "formToSubmitSubunit")
    private String formToSubmitSubunit;

    @JsonProperty(value = "legalFirstName")
    private String legalFirstName;

    @JsonProperty(value = "legalLastName")
    private String legalLastName;

    @JsonProperty(value = "departure")
    private String departure;

    @JsonProperty(value = "destination")
    private String destination;

    @JsonProperty(value = "departing_date")
    private String departingDate;

    @JsonProperty(value = "returning_date")
    private String returningDate;

    @JsonProperty(value = "reason")
    private String reason;

    @JsonProperty(value="budget_list_JS")
    private BudgetNumberAmountModel[] budgetNumberAmountModel;

    @JsonProperty(value="whetherPayFlight")
    private String whetherPayFlight;

    @JsonProperty(value="whetherPayFlightFormData")
    private WhetherPayFlightFormDataModel whetherPayFlightFormDataModel;
}
