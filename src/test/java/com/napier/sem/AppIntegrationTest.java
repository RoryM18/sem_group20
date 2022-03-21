package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);

    }

    @Test
    void getCities()
    {
        ArrayList<City> cities = app.getCities();
        cities = app.getCitiesByAContinent();

        int i = 0;
        // checking the tenth line in the list of is correct (for the world)
        for (City city: cities) {

            i++;

            if (i == 10)
            {
                assertEquals(city.name, "Tokyo");
                assertEquals(city.population, "7980230");
                break;
            }
        }

    }

    @Test
    void getCitiesByAContinent()
    {
        ArrayList<City> cities = app.getCities();
        cities = app.getCitiesByAContinent();

        int i = 0;
        // checking the seventh line in the list of is correct (for Oceania)
        for (City city: cities) {

            i++;

            if (i == 7)
            {
                assertEquals(city.name, "Manukau");
                assertEquals(city.population, "281800");
                break;
            }
        }
    }

    @Test
    void getCitiesByARegion()
    {
        ArrayList<City> cities = app.getCities();
        cities = app.getCitiesByRegion();

        int i = 0;
        // checking the fifth line in the list of is correct (for British Islands)
        for (City city: cities) {

            i++;

            if (i == 5)
            {
                assertEquals(city.name, "Liverpool");
                assertEquals(city.population, "461000");
                break;
            }
        }
    }

    @Test
    void getCitiesByACountry()
    {
        ArrayList<City> cities = app.getCities();
        cities = app.getCitiesByACountry();

        int i = 0;
        // checking the third line in the list of is correct (for British Islands)
        for (City city: cities) {

            i++;

            if (i == 3)
            {
                assertEquals(city.name, "Glasgow");
                assertEquals(city.population, "619680");
                break;
            }
        }
    }

    @Test
    void getCitiesByADisctrict()
    {
        ArrayList<City> cities = app.getCities();
        cities = app.getCitiesByADistrict();

        int i = 0;
        // checking the third line in the list of is correct (for Scotland)
        for (City city: cities) {

            i++;

            if (i == 3)
            {
                assertEquals(city.name, "Aberdeen");
                assertEquals(city.population, "213070");
                break;
            }
        }
    }


}