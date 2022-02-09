package com.country.country.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties
@Data
public class Awg {
    private String name;
    private String symbol;
}
