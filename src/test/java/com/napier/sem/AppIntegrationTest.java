package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
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
    @Disabled
    void getCountries()
    {
        ArrayList<Country> countries = app.getCountries();
        countries = app.getCountries();

        int i = 0;
        /* we are going to check if the number 7 in the list is correct */
        for (Country country: countries) {

            i++;

            if (i == 7)
            {
                assertEquals(country.name, "Russian Federation");
                assertEquals(country.population, "146934000");
                break;
            }
        }



    }

    @Test
    @Disabled
    void getCountriesFromContinent()
    {
        ArrayList<Country> countries = app.getCountries();
        countries = app.getCountriesFromContinent();

        int i = 0;
        /* we are going to check if the number 7 in the list is correct (for South America) */
        for (Country country: countries) {

            i++;

            if (i == 7)
            {
                assertEquals(country.name, "Algeria");
                assertEquals(country.population, "31471000");
                break;
            }
        }
    }

    @Test
    @Disabled
    void getCountriesFromRegion()
    {
        ArrayList<Country> countries = app.getCountries();
        countries = app.getCountriesFromRegion();

        int i = 0;
        /* we are going to check if the number 7 in the list is correct */
        for (Country country: countries) {

            i++;

            if (i == 7)
            {
                assertEquals(country.name, "Ecuador");
                assertEquals(country.population, "12646000");
                break;
            }
        }
    }

    @Test
    @Disabled
    void getLargestPopulatedCountriesFromWorld()
    {
        ArrayList<Country> countries = app.getCountries();
        countries = app.getLargestPopulatedCountriesFromWorld();

        int i = 0;
        /* we are going to check if the number 10 in the list is correct (for number 10) */
        for (Country country: countries) {

            i++;

            if (i == 10)
            {
                assertEquals(country.name, "Nigeria");
                assertEquals(country.population, "111506000");
                break;

            }
        }
    }

    @Test
    @Disabled
    void getLargestPopulatedCountriesFromContinent()
    {
        ArrayList<Country> countries = app.getCountries();
        countries = app.getLargestPopulatedCountriesFromContinent();

        int i = 0;
        /* we are going to check if the number 10 in the list is correct (for number 10 in Asia) */
        for (Country country: countries) {

            i++;

            if (i == 10)
            {
                assertEquals(country.name, "Turkey");
                assertEquals(country.population, "66591000");
                break;

            }
        }
    }

    @Test
    @Disabled
    void getLargestPopulatedCountriesFromRegion()
    {
        ArrayList<Country> countries = app.getCountries();
        countries = app.getLargestPopulatedCountriesFromRegion();

        int i = 0;
        /* we are going to check if the number 5 in the list is correct (for number 5 in the Caribbean) */
        for (Country country: countries) {

            i++;

            if (i == 10)
            {
                assertEquals(country.name, "Jamaica");
                assertEquals(country.population, "2583000");
                break;

            }
        }
    }
}