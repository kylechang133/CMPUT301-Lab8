package com.example.lab8;


import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class CustomListTest {

    private CustomList list;

    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest() {
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * add a city to the list
     * check if the newly added city is in the list
     */
    @Test
    public void hasCityTest() {
        list = MockCityList();
        City city = new City("Calgary", "AB");
        list.addCity(city);

        assertTrue(list.hasCity(city));
    }

    /**
     * add a city to the list
     * delete the city
     */
    @Test
    public void deleteCityTest() {
        list = MockCityList();
        City city = new City("Calgary", "AB");
        list.addCity(city);

        assertTrue(list.hasCity(city));
        list.deleteCity(city);

        assertThrows(NoSuchElementException.class, () -> {
            list.deleteCity(city);
        });
    }

    /**
     *
     */
    @Test
    public void countCitiesTest() {
        list = MockCityList();
        list.addCity(new City("Estevan", "SK"));
        list.addCity(new City("Calgary", "AB"));

        assertEquals(2, list.countCities());
    }
}
