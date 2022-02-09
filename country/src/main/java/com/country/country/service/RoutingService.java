package com.country.country.service;

import com.country.country.model.Route;
import org.springframework.util.RouteMatcher;

public interface RoutingService {
    Route route(String origin, String destination);
}
