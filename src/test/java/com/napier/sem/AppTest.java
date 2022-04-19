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
        app = new App();

    }


    @Test
    void displayCountriesEmpty() {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.displayCountries(countries, "tests displaying empty list of countries");
    }

    @Test
    void displayCountriesNull() {
        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(null);
        app.displayCountries(countries, "tests displaying null");
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
        app.displayCountries(countries, "tests displaying  country");
    }

    @Test
    void displayCountries2Empty() {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.displayCountries2(countries, "tests displaying empty list of countries");
    }

    @Test
    void displayCountries2Null() {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(null);
        app.displayCountries2(countries, "tests displaying null");

        //app.displayCountries2(null, "tests displaying null");
        // displayCountries2 can display "null" , but not an array with a null value

    }

    @Test
    void displayCountries2() {
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

    @Test
    void displayCitiesNull() {
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(null);
        app.displayCities(cities, "tests displaying null");
    }

    @Test
    void displayCities() {
        ArrayList<City> cities = new ArrayList<City>();
        City city = new City();
        city.id = 1;
        city.name = "Kabul";
        city.countryCode = "AFG";
        city.district = "Kabol";
        city.population = 1780000;

        cities.add(city);
        app.displayCities(cities, "tests displaying a test city");
    }

    @Test
    void displayLanguageEmpty() {
        ArrayList<CountryLanguage> countrylanguages = new ArrayList<CountryLanguage>();
        app.displayCountryLanguage(countrylanguages, "tests displaying empty");
    }

    @Test
    void displayLanguageNull() {
        ArrayList<CountryLanguage> countrylanguages = new ArrayList<CountryLanguage>();
        countrylanguages.add(null);
        app.displayCountryLanguage(countrylanguages, "tests displaying null");
    }

    @Test
    void displayLanguage() {
        ArrayList<CountryLanguage> countrylanguages = new ArrayList<CountryLanguage>();
        CountryLanguage countrylanguage = new CountryLanguage();
        countrylanguage.countryCode = "ABW";
        countrylanguage.Language = "Dutch";
        countrylanguage.isOfficial = "T";
        countrylanguage.percentage = (float) 5.3;

        countrylanguages.add(countrylanguage);
        app.displayCountryLanguage(countrylanguages, "tests displaying a test city");
    }

    @Test
    void createNullCountry()
    {
        Country country = new Country();
        country.code = null;
        country.name = null;
        country.continent = null;
        country.region = null;
        country.surfaceArea = Double.parseDouble(null);
        //country.indepYear = Integer.parseInt(null);
        //country.population = Integer.parseInt(null);
        //country.lifeExpectancy = Double.parseDouble(null);
        //country.gnp = Double.parseDouble(null);
        //country.gnpOld = Double.parseDouble(null);
        country.localName = null;
        country.govermentForm = null;
        country.HeadOfState = null;
       // country.capital = Integer.parseInt(null);
        country.code2 = null;


    }

    @Test
    void createEmptyCountry()
    {

        Country country = new Country();
        country.code = "";
        country.name = "";
        country.continent = "";
        country.region = "";
        country.surfaceArea = Double.parseDouble("");
       // country.indepYear = Integer.parseInt("");
       // country.population = Integer.parseInt("");
       // country.lifeExpectancy = Double.parseDouble("");
        // country.gnp = Double.parseDouble("");
        //country.gnpOld = Double.parseDouble("");
        country.localName = "";
        country.govermentForm = "";
        country.HeadOfState = "";
        // country.capital = Integer.parseInt("");
        country.code2 = "";


    }

    @Test
    void createCapital()
    {
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
    }

}