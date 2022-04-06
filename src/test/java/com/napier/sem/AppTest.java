package com.napier.sem;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class AppTest {
    static App app;

    @BeforeAll
    static void init() {
        App a = new App();

    }


    @Test
    void displayCountriesEmpty() {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.displayCountries2(countries, "tests displaying empty");
    }

    @Test
    void displayCountriesNull() {
        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(null);
        app.displayCountries2(countries, "tests displaying null");
    }

    @Test
    void displayCountries() {
        ArrayList<Country> countries = new ArrayList<Country>();
        Country country = new Country();
        country.code = "ABW";
        country.name = "Aruba";
        country.continent = "North America";
        country.region = "Caribbean";
        country.surfaceArea = 193.00;
        country.indepYear = 0;
        country.population = 103000;
        country.lifeExpectancy = 78.4;
        country.gnp = 828.00;
        country.gnpOld = 793.00;
        country.localName = "Aruba";
        country.govermentForm = "Nonmetropolitan Territory of The Netherlands";
        country.HeadOfState = "Beatrix";
        country.capital = 129;
        country.code2 = "AW";

        countries.add(country);
        app.displayCountries2(countries, "tests displaying  country");
    }

    @Test
    void displayCitiesEmpty() {
        ArrayList<City> cities = new ArrayList<City>();
        app.displayCities(cities, "tests displaying empty");
    }
}