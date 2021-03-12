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
public class TravelFormDataModel {
    @JsonProperty(value = "legal_firstname")
    private String legalFirstName;

    @JsonProperty(value = "legal_lastname")
    private String legalLastName;

}
