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
public class ProfileDataModel {

    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "imageUrl")
    private String imageUrl;
}

