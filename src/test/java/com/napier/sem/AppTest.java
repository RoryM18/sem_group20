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
    void displayCountriesEmpty()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.displayCountries(countries, "Query 1: All the countries in the world organised by largest population to smallest. ");
    }

    @Test
    @Disabled
    void displayCountriesNull()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(null);
        app.displayCountries(countries, "Query 1: All the countries in the world organised by largest population to smallest. ");
    }

    @Test
    @Disabled
    void displayCountries()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        Country country = new Country();
        country.code = "ABW";
        country.name = "Aruba";
        country.continent = "North America";
        country.region = "Caribbean";
        country.population = 103000;
        country.capital = 129;

        countries.add(country);
        app.displayCountries(countries, "Query 1: All the countries in the world organised by largest population to smallest. ");
    }


}