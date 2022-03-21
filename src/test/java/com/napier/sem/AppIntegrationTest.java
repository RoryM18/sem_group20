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


    }

    @Test
    void getCitiesByAContinent()
    {
        ArrayList<City> cities = app.getCities();
        cities = app.getCitiesByAContinent();

        int i = 0;

        for (City city: cities) {

            i++;

            if (i == 7)
            {
                assertEquals(city.name, "");
                assertEquals(city.population, "");
                break;
            }
        }
    }

    @Test
    void getCitiesByARegion()
    {

    }

    @Test
    void getCitiesByACountrie()
    {

    }

    @Test
    void getCitiesByADisctrict()
    {

    }


}