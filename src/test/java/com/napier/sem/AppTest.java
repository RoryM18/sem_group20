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
         app = new App();

    }


    @Test

    void displayCitiesEmpty()
    {
        ArrayList<City> cities = new ArrayList<City>();
        app.displayCities(cities, "checking if display show a empty list");
    }

    @Test

    void displayCitiesNull()
    {
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(null);
        app.displayCities(cities, "checking if display show a null list");
    }

    @Test

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

    @Test
    void createNullCity()
    {
        City c = new City();

        c.id = -1;

        c.name = null;

        c.country = null;

        c.population = -1;

        c.countryCode = null;

    }

    @Test
    void createEmptyCity()
    {
        City c = new City();

        c.id = -1;

        c.name = "";

        c.country = "";

        c.population = -1;

        c.countryCode = "";

    }

    @Test
    void createCapitalCity()
    {
        City c = new City();


        c.id = 12345;

        c.name = "Bilbao";

        c.country = "Basque Country";

        c.population = 3452671;

        c.countryCode = "54321";

        c.district = "Bizkaia";

    }

}
