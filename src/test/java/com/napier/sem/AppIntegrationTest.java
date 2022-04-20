package com.napier.sem;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
public class AppIntegrationTest {
    // Set up App
    static App app;


    @BeforeAll
    static void init() {

        app = new App();
        app.connect("localhost:33060", 30000);

    }


    @Test
    void getCapitals() {

        ArrayList<Capital> capitals = app.getCapitals();
        capitals = app.getCapitals();

        int i = 0;
        // checking the tenth line in the list of is correct (for the world)
        for (Capital capital: capitals) {

            i++;

            if (i == 10)
            {
                assertEquals(capital.name, "Lima");
                assertEquals(capital.population, 6464693);
                break;
            }
        }

    }


    @Test
    void getCapitalsByAContinent() {
        ArrayList<Capital> capitals = app.getCapitalsByAContinent();

        capitals = app.getCapitalsByAContinent();

        int i = 0;
        // checking the tenth line in the list of is correct (for Oceania)
        for (Capital capital: capitals) {

            i++;

            if (i == 10)
            {
                assertEquals(capital.name, "Papeete");
                assertEquals(capital.population, 25553);
                break;
            }
        }
    }


    @Test
    void getCapitalsByARegion() {
        ArrayList<Capital> capitals = app.getCapitalsByARegion();
        capitals = app.getCapitalsByARegion();

        int i = 0;
        // checking the fifth line in the list of is correct (for British Islands)
        for (Capital capital: capitals) {

            i++;

            if (i == 1)
            {
                assertEquals(capital.name, "London");
                assertEquals(capital.population, 7285000);
                break;
            }
        }
    }


    @Test
    void getLargestPopulatedCapitalCitiesFromWorld() {
        ArrayList<Capital> capitals = app.getLargestPopulatedCapitalCitiesFromWorld();
        capitals = app.getLargestPopulatedCapitalCitiesFromWorld();

        int i = 0;
        // checking the fifth line in the list of is correct (for British Islands)
        for (Capital capital: capitals) {

            i++;

            if (i == 5)
            {
                assertEquals(capital.name, "Tokyo");
                assertEquals(capital.population, 7980230);
                break;
            }
        }
    }



    @Test
    void getLargestPopulatedCapitalCitiesFromWorldByContinent() {
        ArrayList<Capital> capitals = app.getLargestPopulatedCapitalCitiesFromWorldBYContinent();
        capitals = app.getLargestPopulatedCapitalCitiesFromWorldBYContinent();

        int i = 0;
        // checking the fifth line in the list of is correct (for British Islands)
        for (Capital capital: capitals) {

            i++;

            if (i == 6)
            {
                assertEquals(capital.name, "Honiara");
                assertEquals(capital.population, 50100);
                break;
            }
        }
    }



    @Test
    void getLargestPopulatedCapitalCitiesFromARegion() {
        ArrayList<Capital> capitals = app.getLargestPopulatedCapitalCitiesFromARegion();
        capitals = app.getLargestPopulatedCapitalCitiesFromARegion();

        int i = 0;
        // checking the fifth line in the list of is correct (for British Islands)
        for (Capital capital: capitals) {

            i++;

            if (i == 5)
            {
                assertEquals(capital.name, "Colombo");
                assertEquals(capital.population, 645000);
                break;
            }
        }
    }





    
    @Test
    void getCities()
    {
        ArrayList<City> cities = app.getCities();
        cities = app.getCities();

        int i = 0;
        // checking the tenth line in the list of is correct (for the world)
        for (City city: cities) {

            i++;

            if (i == 10)
            {
                assertEquals(city.name, "New York");
                assertEquals(city.population, 8008278);
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
        // checking the tenth line in the list of is correct (for Oceania)
        for (City city: cities) {

            i++;

            if (i == 10)
            {
                assertEquals(city.name, "Manukau");
                assertEquals(city.population, 281800);
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
                assertEquals(city.population, 461000);
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
                assertEquals(city.population, 619680);
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
        // checking the tenth line in the list of is correct (for Scotland)
        for (City city: cities) {

            i++;

            if (i == 10)
            {
                assertEquals(city.name, "Aberdeen");
                assertEquals(city.population, 213070);
                break;
            }
        }
    }

    @Test
    void getLargestPopulatedCitiesFromWorld()
    {
        ArrayList<City> cities = app.getCities();
        cities = app.getLargestPopulatedCitiesFromWorld();

        int i = 0;
        // checking the tenth line in the list of is correct (for the world)
        for (City city: cities) {

            i++;

            if (i == 10)
            {
                assertEquals(city.name,"New York");
                assertEquals(city.population,8008278);
                break;
            }
        }
    }



    @Test
    void getLargestPopulatedCitiesFromAContinent()
    {
        ArrayList<City> cities = app.getCities();
        cities = app.getLargestPopulatedCitiesFromAContinent();

        int i = 0;
        // checking the tenth line in the list of is correct (for Oceania)
        for (City city: cities) {

            i++;

            if (i == 10)
            {
                assertEquals(city.name,"Manukau");
                assertEquals(city.population,281800);
                break;
            }
        }
    }

    @Test
    void getLargestPopulatedCitiesFromARegion()
    {
        ArrayList<City> cities = app.getCities();
        cities = app.getLargestPopulatedCitiesFromARegion();

        int i = 0;
        // checking the tenth line in the list of is correct (for British islands)
        for (City city: cities) {

            i++;

            if (i == 10)
            {
                assertEquals(city.name,"Bristol");
                assertEquals(city.population,402000);
                break;
            }
        }
    }

    @Test
    void getLargestPopulatedCitiesFromACountry()
    {
        ArrayList<City> cities = app.getCities();
        cities = app.getLargestPopulatedCitiesFromACountry();

        int i = 0;
        // checking the tenth in the list of is correct (for United Kingdom)
        for (City city: cities) {

            i++;



            if (i == 10)
            {
                assertEquals(city.name,"Cardiff");
                assertEquals(city.population,321000);
                break;
            }
        }
    }

    @Test
    void getLargestPopulatedCitiesFromADistrict()
    {
        ArrayList<City> cities = app.getCities();
        cities = app.getLargestPopulatedCitiesFromADistrict();

        int i = 0;
        // checking the tenth line in the list of is correct (for Scotland)
        for (City city: cities) {

            i++;

            if (i == 10)
            {
                assertEquals(city.name,"Dundee");
                assertEquals(city.population,146690);
                break;
            }
        }
    }






    @Test
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
                assertEquals(country.population, 146934000);
                break;
            }
        }



    }

    @Test
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
                assertEquals(country.population, 31471000);
                break;
            }
        }
    }

    @Test
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
                assertEquals(country.population, 12646000);
                break;
            }
        }
    }

    @Test
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
                assertEquals(country.population, 111506000);
                break;

            }
        }
    }

    @Test
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
                assertEquals(country.population, 66591000);
                break;

            }
        }
    }

    @Test
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
                assertEquals(country.population, 2583000);
                break;

            }
        }
    }
}