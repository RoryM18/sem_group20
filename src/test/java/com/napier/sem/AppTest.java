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
    @Disabled
    static void init()
    {
        app = new App();
    }

    @Disabled
    @Test
    void DisplayCapitalsEmpty()
    {
        ArrayList<Capital> capitals = new ArrayList<>();
        app.displayCapitals(capitals, "Unit test for Display the capitals array when is empty");
    }

    void DisplayCapitalsNull()
    {

        app.displayCapitals(null, "Unit test for Display the capitals array when is has null values");
    }

    void DisplayCapitals()
    {
        ArrayList<Capital> capitals = new ArrayList<>();

        Capital capital = new Capital();

        capital.name = "lima";

        capital.country = "Peru";

        capital.population = 6320174;

        capitals.add(capital);

        app.displayCapitals(capitals , "Unit test for Display the capitals array");
    }

    void createNullCapital()
    {
        Capital c = new Capital();

        c.id = Integer.parseInt(null);

        c.name = null;

        c.country = null;

        c.population = Integer.parseInt(null);

        c.countryCode = null;

    }

    void createEmptyCapital()
    {
        Capital c = new Capital();

        c.id = Integer.parseInt("");

        c.name = "";

        c.country = "";

        c.population = Integer.parseInt("");

        c.countryCode = "";

    }

    void createCapital()
    {
        Capital c = new Capital();

        Capital capital = new Capital();

        capital.id = 12345;

        capital.name = "Bilbao";

        capital.country = "Basque Country";

        capital.population = 3452671;

        c.countryCode = "54321";
    }

}