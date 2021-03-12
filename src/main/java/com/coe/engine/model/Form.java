package com.coe.engine.model;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Form {
    private String key;
    private String text;
    private String value;


    public Form(String key, String text, String value) {
        this.key = key;
        this.text = text;
        this.value = value;
    }
}
