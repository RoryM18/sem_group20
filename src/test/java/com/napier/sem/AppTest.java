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
    void displayCitiesEmpty() {
        String details = "";
        String info = "";
        app.displayCities(details,info);
    }

    @Test
    void displayCitiesNull() {
        String details = null;
        String info = null;
        app.displayCities(details,info);
    }

    @Test
    void displayCities() {
        String detail = "Caribbean, 38140000, 29%, 71%";
        String info = "";
        app.displayCities(detail, info);
    }
}