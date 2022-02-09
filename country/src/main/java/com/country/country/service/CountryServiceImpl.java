package com.country.country.service;


import com.country.country.model.Country;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService {

    @Autowired
    public RestTemplate restTemplate;
    @Override
    public List<Country> countries(){
        //use RestTemplate for consuming external API
        Country[] country = restTemplate.getForObject("https://raw.githubusercontent.com/mledoze/countries/master/countries.json", Country[].class);
        return Arrays.asList(country);
    }
}
