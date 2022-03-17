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

        // invoke a functinon to get the countris as an arraylist
        ArrayList<Country> countries = a.getCountries(con);

        ArrayList<City> cities = a.getCities(con);

        // invoke a function to display the results of the query to the user
        //a.displayCountries(countries);

        a.displayCities(cities);

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
     * Name: getCountries
     * description: To return an arraylist of the countries within the world database
     * @param con - A variable of type 'Connection' called con which uses the connection between the database
     * and intellij / the program.
     * @return an arraylist of the Country class
     */
    public ArrayList getCountries(Connection con)
    {
        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Name, Population"
                            + " FROM country "
                           // + "WHERE emp_no = " + ID;
                            + "ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries
            ArrayList countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country country = new Country();
                country.name = rset.getString("Name");
                country.population = rset.getInt("Population");
                countries.add(country);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Country details");
            return null;
        }
    }


    /**
     * Name: displayCountries
     * description: Print the details to do with every country and their population in descending order
     * @param countries Arraylist of the Country class
     */
    public void displayCountries(ArrayList<Country> countries)
    {
        for (Country country: countries) {

            String details = ("\nName: " +
                    country.name + "\nPopulation: "
                            + country.population);

            System.out.println(details);
        }
    }

    public ArrayList getCities(Connection con)
    {
        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.Population "
                            + " FROM City "
                            + "ORDER BY Population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries
            ArrayList cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                city.name = rset.getString("Name");
                city.population = rset.getInt("Population");
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

    public void displayCities(ArrayList<City> cities)
    {
        for (City city: cities) {

            String details = ("\nName: " +
                    city.name + "\nPopulation: "
                    + city.population);

            System.out.println(details);
        }
    }
}