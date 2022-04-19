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
    void displayCitiesDetailsEmpty() {
        String details = "";
        app.displayCitiesDetails(details, "tests displaying empty");
    }

    @Test
    void displayCitiesDetailsNull() {
        String details = null;
        app.displayCitiesDetails(details, "tests displaying null");
    }

    @Test
    void displayCitiesDetails() {
        String details = app.getLanguageReport();

        app.displayCitiesDetails(details, "tests displaying a test city");
    }


    void createNullCountryLanguage()
    {
        CountryLanguage language = new CountryLanguage();

        language.countryCode = null;

        language.Language = null;


        language.isOfficial = null;

        language.percentage = Float.parseFloat(null);

    }

    void createEmptyCountryLanguage()
    {

        CountryLanguage language = new CountryLanguage();

        language.countryCode = "";

        language.Language = "";


        language.isOfficial = "";

        language.percentage = Float.parseFloat("");


    }

    void createCapitalLanguage()
    {
        CountryLanguage language = new CountryLanguage();

        language.countryCode = "EH";

        language.Language = "Basque";

        language.isOfficial = "Yes";

        language.percentage = Float.parseFloat("10");
    }

}