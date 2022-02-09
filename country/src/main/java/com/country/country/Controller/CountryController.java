package com.country.country.Controller;

import com.country.country.model.Country;
import com.country.country.model.Route;
import com.country.country.service.CountryService;
import com.country.country.service.RoutingService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/routing")
public class CountryController {

    @Autowired
    public RoutingService routingService;

    @GetMapping(value="/{origin}/{destination}")
    public Route  findRoute(@PathVariable String origin, @PathVariable String destination){
        var route = routingService.route(origin, destination);
        return route;
    }
}
