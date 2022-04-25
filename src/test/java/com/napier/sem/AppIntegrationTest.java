package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;
public class AppIntegrationTest {
    // Set up App
    static App app;

    @BeforeAll
    static void init() {
        app = new App();
        app.connect("localhost:33060", 30000);

    }

    @Test
    void getWorldPopulation()
    {
       String details = app.getWorldPopulation();
       assertEquals(details, "world, 6078749450, 24%, 76%");
    }

    @Test
    void getContinentPopulation()
    {
        String details = app.getContinentPopulation();
        assertEquals(details, "Asia, 3705025700, 19%, 81%");
    }
    @Test
    void getRegionPopulation()
    {
        String details = app.getRegionPopulation();
        assertEquals(details, "Caribbean, 38140000, 29%, 71%");
    }

    @Test
    void getCountryPopulation()
    {
        String details = app.getCountryPopulation();
        assertEquals(details, "India, 1013662000, 12%, 88%");
    }

    @Test
    void getDistrictPopulation()
    {
        String details = app.getDistrictPopulation();
        assertEquals(details, "New York, 8958085, 100%, 0%");
    }

    @Test
    void getOnlyWorldPopulation()
    {
        String details = app.getOnlyWorldPopulation();
        assertEquals(details, "World, 6078749450");
    }

    @Test
    void getOnlyContinentPopulation()
    {
        String details = app.getOnlyContinentPopulation();
        assertEquals(details, "Asia, 3705025700");
    }

    @Test
    void getOnlyRegionPopulation()
    {
        String details = app.getOnlyRegionPopulation();
        assertEquals(details, "Carribean, 38140000");
    }

    @Test
    void getOnlyCountryPopulation()
    {
        String details = app.getOnlyCountryPopulation();
        assertEquals(details, "India, 1013662000");
    }

    @Test
    void getOnlyDistrictPopulation()
    {
        String details = app.getOnlyDistrictPopulation();
        assertEquals(details, "New York, 8958085");
    }
    
    @Test
    void getOnlyCityPopulation()
    {
        String details = app.getOnlyCityPopulation();
        assertEquals(details, "Amsterdam, 731200");
    }
}
