package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for CityList.
 */
class CityListTest {

    /** Helper to create a list with one default city. */
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }


    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> cityList.add(city));
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }


    @Test
    void testHasCity() {
        CityList list = mockCityList();
        assertTrue(list.hasCity(new City("Edmonton", "Alberta")));
        assertFalse(list.hasCity(new City("Calgary", "Alberta")));
    }

    @Test
    void testDeleteRemovesCity() {
        CityList list = mockCityList();
        City target = new City("Edmonton", "Alberta");

        assertTrue(list.hasCity(target));
        list.delete(target);
        assertFalse(list.hasCity(target));
        assertEquals(0, list.countCities());
    }

    @Test
    void testDeleteThrowsIfMissing() {
        CityList list = mockCityList();
        City missing = new City("Calgary", "Alberta");
        assertThrows(IllegalArgumentException.class, () -> list.delete(missing));
    }

    @Test
    void testCountCities() {
        CityList list = new CityList();
        assertEquals(0, list.countCities());

        list.add(new City("Banff", "Alberta"));
        list.add(new City("Calgary", "Alberta"));

        assertEquals(2, list.countCities());
    }
}
