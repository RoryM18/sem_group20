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

    void displayCountriesEmpty()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.displayCountries(countries, "tests displaying empty");
    }

    @Test

    void displayCountriesNull()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(null);
        app.displayCountries(countries, "tests displaying null");
    }

    @Test

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
        app.displayCountries(countries, "tests displaying  countrie");
    }


}