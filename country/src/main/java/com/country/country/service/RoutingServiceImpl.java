package com.country.country.service;

import com.country.country.Exception.NoPathException;
import com.country.country.Graph.BreadthFirstSearch;
import com.country.country.model.Country;
import com.country.country.model.Route;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class RoutingServiceImpl implements RoutingService {


    private final CountryService countryService;

    @Override
    public Route route(String origin, String destination) {

        var countries = countryService.countries().stream()
                .collect(Collectors.toMap(Country::getCca3, Function.identity()));

        var originCountry = Optional.ofNullable(countries.get(origin))
                .orElseThrow(() -> new NoPathException(String.format("Unknown origin country %s", origin)));

        var destinationCountry = Optional.ofNullable(countries.get(destination))
                .orElseThrow(() -> new NoPathException(String.format("Unknown destination country %s", destination)));

        if (!origin.equals(destination)) {
            if (originCountry.getBorders().isEmpty()) {
                throw new NoPathException(String.format("Origin %s is isolated", origin));
            }

            if (destinationCountry.getBorders().isEmpty()) {
                throw new NoPathException(String.format("Destination %s is isolated", destination));
            }
        }

        var routes = new BreadthFirstSearch(countries, originCountry, destinationCountry).paths();

        var route = new Route();
        route.setRoutes(routes);
        return route;
    }
}
