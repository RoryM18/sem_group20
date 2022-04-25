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
    void getLanguageReport() {
        String details = app.getLanguageReport();

        //This is cheating a bit but idk another way of doing it :(

        String[] detailsArray = details.split("%\n");

        assertEquals(detailsArray[1], "language: Hindi, 405633070.00000, Percentage of World Population: 6.67300");




    }

}