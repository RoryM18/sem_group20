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
}