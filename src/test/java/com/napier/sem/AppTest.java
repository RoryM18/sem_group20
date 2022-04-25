package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    @Test
    void DisplayCapitalsEmpty()
    {
        ArrayList<Capital> capitals = new ArrayList<>();
        app.displayCapitals(capitals, "Unit test for Display the capitals array when is empty");
    }

    @Test
    void DisplayCapitalsNull()
    {

        app.displayCapitals(null, "Unit test for Display the capitals array when is has null values");
    }

    {
        ArrayList<Capital> capitals = new ArrayList<>();

        Capital capital = new Capital();

        capital.name = "lima";

        capital.country = "Peru";

        capital.population = 6320174;

        capitals.add(capital);

        app.displayCapitals(capitals , "Unit test for Display the capitals array");
    }

    @Test
    void createNullCapital()
    {
        Capital c = new Capital();

        c.id = -1;

        c.name = null;

        c.country = null;

        c.population = -1;

        c.countryCode = null;

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

        app.displayCountries2(null, "tests displaying null");

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
        country.surfaceArea = -1;
        country.indepYear = -1;
        country.population = -1;
        country.lifeExpectancy = -1;
        country.gnp = -1;
        country.gnpOld = -1;
        country.localName = null;
        country.govermentForm = null;
        country.HeadOfState = null;
        country.capital = -1;
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
        country.surfaceArea = -1;
        country.indepYear = -1;
        country.population = -1;
        country.lifeExpectancy = -1;
        country.gnp = -1;
        country.gnpOld = -1;
        country.localName = "";
        country.govermentForm = "";
        country.HeadOfState = "";
        country.capital = -1;
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



    @Test
    void displayCitiesDetailsEmpty() {
        String details = "";
        app.displayLanguage(details, "tests displaying empty");
    }

    @Test
    void displayCitiesDetailsNull() {
        String details = null;
        app.displayLanguage(details, "tests displaying null");
    }

    @Test
    void displayCitiesDetails() {
        String details = app.getLanguageReport();

        app.displayLanguage(details, "tests displaying a test city");
    }

    @Test
    void createNullCountryLanguage()
    {
        CountryLanguage language = new CountryLanguage();

        language.countryCode = null;

        language.Language = null;


        language.isOfficial = null;

        language.percentage = -1;

    }

    @Test
    void createEmptyCountryLanguage()
    {

        CountryLanguage language = new CountryLanguage();

        language.countryCode = "";

        language.Language = "";


        language.isOfficial = "";

        language.percentage = -1;


    }

    @Test
    void createCapitalLanguage()
    {
        CountryLanguage language = new CountryLanguage();

        language.countryCode = "EH";

        language.Language = "Basque";

        language.isOfficial = "Yes";

        language.percentage = 10;
    }




    @Test
    void displayPopulationEmpty() {
        String details = "";
        String info = "";
        app.displayPopulation(details,info);
    }

    @Test
    void displayPopulationNull() {
        String details = null;
        String info = null;
        app.displayPopulation(details,info);
    }

    @Test
    void displayPopulation() {
        String detail = "Caribbean, 38140000, 29%, 71%";
        String info = "";
        app.displayPopulation(detail, info);
    }
}
