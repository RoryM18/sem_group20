package com.napier.sem;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class AppTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        App a = new App();

    }


    @Test
    @Disabled
    void displayCitiesEmpty()
    {
    }

    @Test
    @Disabled
    void displayCitiesNull()
    {
    }

    @Test
    @Disabled
    void displayCities()
    {

    }

}