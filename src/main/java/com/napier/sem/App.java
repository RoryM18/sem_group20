package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Purpose: To connect to the world database setup on my local mysql server, perform query and display results
 * @author Group20
 * @since  28/02/22
 */
public class App
{

    /**
     * Name: main
     * Purpose: To connect to the world database setup on my local mysql server, invoke functions display results and close the connection
     * @param args are the input argurments
     */
    public static void main(String[] args)
    {

        App a = new App();

        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        // Connection to the database
        Connection con = null;
        int retries = 100;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                // Wait a bit
                Thread.sleep(10000);
                // Exit for loop
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }


        //Query 1: All the cities in the world organised by largest population to smallest.
        // invoke a function to get the cities as an arraylist
        ArrayList<City> cities = a.getCities(con);
        // invoke a function to display the results of the query to the user
        a.displayCountries(cities, "Query 1: All the cities in the world organised by largest population to smallest. ");
        cities.clear();



        //Query 2: All the cities in a continent organised by largest population to smallest.
        // invoke a function to get the cities as an arraylist
        cities = a.getCitiesFromContinent(con);
        // invoke a function to display the results of the query to the user
        a.displayCountries(cities, "Query 2: All the cities in a continent organised by largest population to smallest. ");
        cities.clear();

        //Query 3: All the cities in a region organised by largest population to smallest.
        // invoke a function to get the cities as an arraylist
        cities = a.getCitiesFromRegion(con);
        // invoke a function to display the results of the query to the user
        a.displayCountries(cities, "Query 2: All the cities in a region organised by largest population to smallest. ");
        cities.clear();






        // invoke a function to close the connection between the database and this program
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }





    /**
     * Name: getCities / Query 1
     * description: Generate a report of all cities in the world by largest population to smallest.
     * @param con - A variable of type 'Connection' called con which uses the connection between the database
     * and intellij / the program.
     * @return an arraylist of the Cities class
     */
    public ArrayList getCities(Connection con)
    {

        try
        {

            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city JOIN country ON (country.Code = city.CountryCode) "
                            + "ORDER BY Population DESC";
            // Execute SQL statement
            // Return countries


            PreparedStatement stmt1 = con.prepareStatement(strSelect);
            ResultSet rs = stmt1.executeQuery();

            ArrayList cities = new ArrayList<City>();
            while (rs.next())
            {

                City city = new City();
                city.name = rs.getString("city.Name");
                city.country = rs.getString("Country.Name");
                city.district = rs.getString("District");
                city.population = rs.getInt("Population");

                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Country details");
            return null;
        }
    }




    /**
     * Name: getCitiesFromCities / Query 2
     * description: Generate a report of all cities in a continent by largest population to smallest.
     * @param con - A variable of type 'Connection' called con which uses the connection between the database
     * and intellij / the program.
     * @return an arraylist of the Cities class
     */
    public ArrayList getCitiesFromContinent(Connection con)
    {

        try
        {

            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city JOIN country ON (country.Code = city.CountryCode) "
                            + "WHERE country.Continent = 'Oceania' "
                            + "ORDER BY city.Population DESC";
            // Execute SQL statement
            // Return countries

            PreparedStatement stmt1 = con.prepareStatement(strSelect);
            ResultSet rs = stmt1.executeQuery();

            ArrayList cities = new ArrayList<City>();
            while (rs.next())
            {

                City city = new City();
                city.name = rs.getString("city.Name");
                city.country = rs.getString("Country.Name");
                city.district = rs.getString("District");
                city.population = rs.getInt("Population");

                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Country details");
            return null;
        }
    }




    /**
     * Name: getCitiesFromCities / Query 3
     * description: Generate a report of all cities in a region by largest population to smallest.
     * @param con - A variable of type 'Connection' called con which uses the connection between the database
     * and intellij / the program.
     * @return an arraylist of the Cities class
     */
    public ArrayList getCitiesFromRegion(Connection con)
    {

        try
        {

            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city JOIN country ON (country.Code = city.CountryCode) "
                            + "WHERE country.Region = 'British Islands' "
                            + "ORDER BY city.Population DESC";
            // Execute SQL statement
            // Return countries

            PreparedStatement stmt1 = con.prepareStatement(strSelect);
            ResultSet rs = stmt1.executeQuery();

            ArrayList cities = new ArrayList<City>();
            while (rs.next())
            {

                City city = new City();
                city.name = rs.getString("city.Name");
                city.country = rs.getString("Country.Name");
                city.district = rs.getString("District");
                city.population = rs.getInt("Population");

                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Country details");
            return null;
        }
    }



    /**
     * Name: displayCities
     * description: Print the details to do with every city in the arraylist
     * @param cities Arraylist of the City class
     */
    public void displayCountries(ArrayList<City> cities, String queryName)
    {
        // Print out query name
        System.out.println(queryName);


        // Print out the queries in the arraylist
        for (City city: cities) {

            String details = ("" + city.name + ", " + city.country +
                    ", " + city.district + ", " + city.population);

            System.out.println(details);
        }

        System.out.println("\n\n\n");
    }



}