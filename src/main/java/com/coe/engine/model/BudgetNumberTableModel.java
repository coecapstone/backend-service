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
public class BudgetNumberTableModel {
    @JsonProperty(value="budget_number")
    private String budget_number;

    @JsonProperty(value="budget_name")
    private String budget_name;
}
