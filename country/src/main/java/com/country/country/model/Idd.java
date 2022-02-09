package com.country.country.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties
@Data
public class Idd {
    private String root;
    private List<String> suffixes;
}
