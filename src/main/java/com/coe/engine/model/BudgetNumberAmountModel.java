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
public class BudgetNumberAmountModel {

    @JsonProperty(value="budget_number")
    private String budget_number;

    @JsonProperty(value="amount")
    private String amount;
}
