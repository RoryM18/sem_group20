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
}
