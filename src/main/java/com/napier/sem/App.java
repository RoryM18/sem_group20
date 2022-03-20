package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;


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


        // invoke a function to get the Cities as an arraylist



        /**Name: getCities / Query 1
         *description: To return an arraylist of the cities within the world database
         *@param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return an arraylist of the City class      */
        ArrayList<City> cities = a.getCities(con);
        a.displayCities(cities, "Query 1: return an arraylist of the cities within the world");



        /**Name: getCitiesByAContinent / Query 2
         *description: To return an arraylist of the cities within a Continent
         * @param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return an arraylist of the city class      */
        cities = a.getCitiesByAContinent(con);
        // Invoke a function to display the results of the query to the user
        a.displayCities(cities, "Query 2: return an arraylist of the cities within a continent");


        /**Name: getCitiesByRegion / Query 3
         *description: To return an arraylist of the cities within a region
         * @param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return an arraylist of the city class      */
        cities = a.getCitiesByRegion(con);
        // Invoke a function to display the results of the query to the user
        a.displayCities(cities, "Query 3: return an arraylist of the cities within a region");


        /**Name: getCitiesByCountry / Query 4
         *description: To return an arraylist of the cities within a Country
         * @param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return an arraylist of the city class      */
        cities = a.getCitiesByACountry(con);
        // Invoke a function to display the results of the query to the user
        a.displayCities(cities, "Query 4: return an arraylist of the cities within a Country");


        /**Name: getCitiesByDistrict / Query 5
         *description: To return an arraylist of the cities within a distric
         * @param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return an arraylist of the city class      */
        cities = a.getCitiesByADistrict(con);
        // Invoke a function to display the results of the query to the user
        a.displayCities(cities, "Query 5: return an arraylist of the cities within a District");

        /**Name: getLargestPopulatedCitiesFromWorld / Query 6
         *description: To return an arraylist of the selected number of cities within world
         * @param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return an arraylist of the city class      */
        cities = a.getLargestPopulatedCitiesFromWorld(con);
        // Invoke a function to display the results of the query to the user
        a.displayCities(cities, "Query 6: return an arraylist of the selected number of cities within world");



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
     * Name: getCities
     * description: To return an arraylist of the cities within the world database
     * @param con - A variable of type 'Connection' called con which uses the connection between the database
     * and intellij / the program.
     * @return an arraylist of the City class
     */
    public ArrayList getCities(Connection con)
    {
        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + " FROM city JOIN country ON (city.CountryCode = country.Code) "
                            + " ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries
            ArrayList cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                city.name = rset.getString("city.Name");
                city.district = rset.getString("District");
                city.population = rset.getInt("city.Population");
                city.country = rset.getString("country.Name");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get City details");
            return null;
        }
    }


    /**
     * Name: getCitiesInAContinent
     * description: To return an arraylist of the cities within the world database
     * @param con - A variable of type 'Connection' called con which uses the connection between the database
     * and intellij / the program.
     * @return an arraylist of the City class
     */
    public ArrayList getCitiesByAContinent(Connection con)
    {
        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + " FROM city JOIN country ON (city.CountryCode = country.Code) "
                            + " WHERE Continent = 'Oceania' "
                            + " ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries
            ArrayList cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                city.name = rset.getString("city.Name");
                city.district = rset.getString("District");
                city.population = rset.getInt("city.Population");
                city.country = rset.getString("country.Name");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get City details");
            return null;
        }
    }





    /**Name: getCitiesByRegion / Query 3
     *description: To return an arraylist of the cities within a region
     * @param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
     * @return an arraylist of the city class      */
    public ArrayList getCitiesByRegion(Connection con)
    {
        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + " FROM city JOIN country ON (city.CountryCode = country.Code) "
                            + " WHERE Region = 'British Islands' "
                            + " ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries
            ArrayList cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                city.name = rset.getString("city.Name");
                city.district = rset.getString("District");
                city.population = rset.getInt("city.Population");
                city.country = rset.getString("country.Name");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get City details");
            return null;
        }
    }


    /**Name: getCitiesByCountry / Query 4
     *description: To return an arraylist of the cities within a City
     * @param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
     * @return an arraylist of the city class      */
    public ArrayList getCitiesByACountry(Connection con)
    {
        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + " FROM city JOIN country ON (city.CountryCode = country.Code) "
                            + " WHERE country.Name = 'United Kingdom' "
                            + " ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries
            ArrayList cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                city.name = rset.getString("city.Name");
                city.district = rset.getString("District");
                city.population = rset.getInt("city.Population");
                city.country = rset.getString("country.Name");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get City details");
            return null;
        }
    }





    /**Name: getCitiesByDistrict / Query 5
     *description: To return an arraylist of the cities within a district
     * @param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
     * @return an arraylist of the city class      */
    public ArrayList getCitiesByADistrict(Connection con)
    {
        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + " FROM city JOIN country ON (city.CountryCode = country.Code) "
                            + " WHERE District = 'Scotland' "
                            + " ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries
            ArrayList cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                city.name = rset.getString("city.Name");
                city.district = rset.getString("District");
                city.population = rset.getInt("city.Population");
                city.country = rset.getString("country.Name");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get City details");
            return null;
        }
    }

    /**
     * Name: getCities
     * description: To return an arraylist of the cities within the world database
     * @param con - A variable of type 'Connection' called con which uses the connection between the database
     * and intellij / the program.
     * @return an arraylist of the City class
     */
    public ArrayList getLargestPopulatedCitiesFromWorld(Connection con)
    {
        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + " FROM city JOIN country ON (city.CountryCode = country.Code) "
                            + " ORDER BY Population DESC"
                            + " LIMIT 10 ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries
            ArrayList cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                city.name = rset.getString("city.Name");
                city.district = rset.getString("District");
                city.population = rset.getInt("city.Population");
                city.country = rset.getString("country.Name");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get City details");
            return null;
        }
    }


    public void displayCities(ArrayList<City> cities, String query)
    {

        System.out.println("\n\n\n" + query);

        for (City city: cities) {

            String details = (
                    city.name + ", " +
                    city.country + ", "
                    + city.district + ", "
                    + city.population);

            System.out.println(details);
        }
    }
}