package com.country.country.Graph;

import com.country.country.Exception.NoPathException;
import com.country.country.model.Country;
import com.country.country.model.Name;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

@Slf4j
@AllArgsConstructor
public class BreadthFirstSearch {
    private final Map<String, Country> countries;
    private final Country origin;
    private final Country destination;

    private final Map<Country, Boolean> visited = new HashMap<>();
    private final Map<Country, Country> previous = new HashMap<>();

    public final List<String> paths() {
        var currentCountry = origin;

        Queue<Country> pivot = new ArrayDeque<>();
        pivot.add(currentCountry);

        visited.put(currentCountry, true);

        OUTER: while (!pivot.isEmpty()) {
            currentCountry = pivot.remove();
            log.debug("Visiting " + currentCountry.getCca3());
            if (currentCountry.equals(destination)) {
                log.debug("Origin and destination are equal");
                break;
            } else {
                for (var neighbour : currentCountry.getBorders()) {
                    var neighbourCountry = countries.get(neighbour);
                    if(!visited.containsKey(neighbourCountry)){
                        log.debug("... registering neighbour " + neighbourCountry.getCca3());
                        pivot.add(neighbourCountry);
                        visited.put(neighbourCountry, true);
                        previous.put(neighbourCountry, currentCountry);
                        if (neighbourCountry.equals(destination)) {
                            log.debug("Shortest path found");
                            currentCountry = neighbourCountry;
                            break OUTER;
                        }
                    } else {
                        log.debug("... skipping neighbour " + neighbourCountry.getCca3());
                    }
                }
            }
        }

        if (!currentCountry.equals(destination)){
            throw new NoPathException("Cannot reach the path");
        }

        List<Country> path = new ArrayList<>();
        for (Country node = destination; node != null; node = previous.get(node)) {
            path.add(node);
        }

        return path.stream()
                .map(Country::getCca3)
                .collect(MyCollectors.reversing());
    }
}
