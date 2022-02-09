package com.country.country.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties
@Data
public class Native {
    private Nld nld;
    private Pap pap;
}
