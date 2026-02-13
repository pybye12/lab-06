package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {
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
        assertEquals(1, cityList.countCities());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.countCities());
        assertTrue(cityList.hasCity(city));
    }
    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = mockCity();
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }
    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        City city = new City("Calgary", "Alberta");
        cityList.add(city);

        // making sure alphabeticallty first
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }
    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        City city = new City("Regina", "Saskatchewan");
        assertFalse(cityList.hasCity(city));
        cityList.add(city);
        assertTrue(cityList.hasCity(city));
    }

    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.countCities());

        cityList.delete(city);
        assertEquals(1, cityList.countCities());
        assertFalse(cityList.hasCity(city));
    }
    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        City city = new City("Regina", "Saskatchewan");
        // in the case we delete one which isnt to be delete
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }
    @Test
    void testCountCities() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());
    }
}