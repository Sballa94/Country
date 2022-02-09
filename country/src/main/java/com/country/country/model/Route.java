package com.country.country.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Route {

    private List<String> routes;

    public Route() {
    }
}
