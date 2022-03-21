package com.napier.sem;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class AppTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        App a = new App();

    }


    @Test
    @Disabled
    void displayCitiesEmpty()
    {
        ArrayList<City> cities = new ArrayList<City>();
        app.displayCities(cities, "checking if display show a empty list");
    }

    @Test
    @Disabled
    void displayCitiesNull()
    {
        ArrayList<City> cities = new ArrayList<City>();
        app.displayCities(cities, "checking if display show a null list");
    }

    @Test
    @Disabled
    void displayCities()
    {
        ArrayList<City> cities = new ArrayList<City>();
        City city = new City();
        city.name = "Edinburgh";
        city.district = "Scotland";
        city.population = 450180;
        city.country = "United Kingdom";
        cities.add(city);

        app.displayCities(cities, "checking if display show a list");
    }

}