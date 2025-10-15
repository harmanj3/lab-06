package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Keeps track of a list of City objects.
 */
public class CityList {
    private final List<City> cities = new ArrayList<>();

    /**
     * Adds a city if it does not already exist.
     * @param city the city to add
     * @throws IllegalArgumentException if the city already exists
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException("City already exists: " + city.getCityName());
        }
        cities.add(city);
    }

    /**
     * Returns a sorted copy of the city list.
     * @return sorted list of cities
     */
    public List<City> getCities() {
        List<City> copy = new ArrayList<>(cities);
        Collections.sort(copy);
        return copy;
    }

    /**
     * Checks whether a city exists in the list.
     * @param city the city to check
     * @return true if the city exists
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Deletes a city if it exists; otherwise throws an exception.
     * @param city the city to remove
     * @throws IllegalArgumentException if the city is not in the list
     */
    public void delete(City city) {
        if (!cities.remove(city)) {
            throw new IllegalArgumentException("City not found: " + city.getCityName());
        }
    }

    /**
     * Returns the number of cities currently in the list.
     * @return number of cities
     */
    public int countCities() {
        return cities.size();
    }
}
