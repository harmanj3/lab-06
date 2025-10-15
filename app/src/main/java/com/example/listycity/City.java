package com.example.listycity;

import java.util.Objects;

/**
 * This class defines a City with a name and a province.
 */
public class City implements Comparable<City> {

    /** City name. */
    private final String city;

    /** Province name. */
    private final String province;

    /**
     * Creates a new City.
     * @param city city name
     * @param province province name
     */
    public City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * Gets the city name.
     * @return city name
     */
    public String getCityName() {
        return city;
    }

    /**
     * Gets the province name.
     * @return province name
     */
    public String getProvinceName() {
        return province;
    }

    /**
     * Compares cities alphabetically by name.
     * If equal, compares by province.
     */
    @Override
    public int compareTo(City other) {
        int result = city.compareTo(other.getCityName());
        return result == 0 ? province.compareTo(other.getProvinceName()) : result;
    }

    /** Two cities are equal if both city and province are equal. */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City other = (City) o;
        return Objects.equals(city, other.city) && Objects.equals(province, other.province);
    }

    /** Generates a hash code consistent with equals. */
    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }
}
