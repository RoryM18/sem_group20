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


        //Query 1: All the countries in the world organised by largest population to smallest.
        // invoke a functinon to get the countris as an arraylist
        ArrayList<Country> countries = a.getCountries(con);
        // invoke a function to display the results of the query to the user
        a.displayCountries(countries, "Query 1: All the countries in the world organised by largest population to smallest. ");
        countries.clear();


        //Query 2: All the countries in a continent organised by largest population to smallest.
        // invoke a function to get the countries as an arraylist
        countries = a.getCountriesFromContinent(con);
        a.displayCountries(countries, "Query 2: All the countries in a continent organised by largest population to smallest.");


        //Query 3: All the countries in a region organised by largest population to smallest.
        // invoke a function to get the countries as an arraylist
        countries = a.getCountriesFromRegion(con);
        a.displayCountries(countries, "Query 3: All countries in a region by largest population to smallest.");


        //Query 4: Show X number of countries in the world with the largest population
        // invoke a function to get the countries as an arraylist
        countries = a.getLargestPopulatedCountriesFromWorld(con);
        a.displayCountries(countries, "Query 4: Show X number of countries in the world with the largest population");

        //Query 5: Show X number of countries in the Continent with the largest population
        // invoke a function to get the countries as an arraylist
        countries = a.getLargestPopulatedCountriesFromContinent(con);
        a.displayCountries(countries, "Query 5: Show X number of countries in the Continent with the largest population");

        //Query 6: Show X number of countries in the Region with the largest population
        // invoke a function to get the countries as an arraylist
        countries = a.getLargestPopulatedCountriesFromRegion(con);
        a.displayCountries(countries, "Query 6: Show X number of countries in the Region with the largest population");




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
     * Name: getCountries / Query 1
     * description: To return an arraylist of the countries within the world database
     * @param con - A variable of type 'Connection' called con which uses the connection between the database
     * and intellij / the program.
     * @return an arraylist of the Country class
     */
    public ArrayList getCountries(Connection con)
    {

        try
        {

            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital"
                            + " FROM country "
                            + "ORDER BY Population DESC";
            // Execute SQL statement
            // Return countries


            PreparedStatement stmt1 = con.prepareStatement(strSelect);
            ResultSet rs = stmt1.executeQuery();

            ArrayList countries = new ArrayList<Country>();
            if (rs.next())
            {
                Country country = new Country();
                country.code = rs.getString("Code");
                country.name = rs.getString("Name");
                country.continent = rs.getString("Continent");
                country.region = rs.getString("Region");
                country.population = rs.getInt("Population");
                country.capital = rs.getInt("Capital");;

                return countries;
            }
            else return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Country details");
            return null;
        }
    }





    /**
     * Name: getCountriesFromContinent / Query 2
     * description: To return an arraylist of the countries within a continent
     * @param con - A variable of type 'Connection' called con which uses the connection between the database
     * and intellij / the program.
     * @return an arraylist of the Country class
     */
    public ArrayList getCountriesFromContinent(Connection con)
    {
       // Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        //System.out.println("Enter Continent For Query: ");

        //myObj.useDelimiter(System.lineSeparator());
        //String continent = myObj.next();  // Read user input
        //continent.trim();

        //System.out.println("Username is: " + continent);  // Output user input

        try
        {

            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital"
                            + " FROM country "
                            +  " WHERE Continent = 'Africa' "
                            + "ORDER BY Population DESC";
            // Execute SQL statement
            // Return countries


            PreparedStatement stmt = con.prepareStatement(strSelect);
            ResultSet rs = stmt.executeQuery();

            ArrayList countries = new ArrayList<Country>();
            while (rs.next())
            {
                Country country = new Country();
                country.code = rs.getString("Code");
                country.name = rs.getString("Name");
                country.continent = rs.getString("Continent");
                country.region = rs.getString("Region");
                country.population = rs.getInt("Population");
                country.capital = rs.getInt("Capital");;

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
     * Name: getCountriesFromRegion / Query 3
     * description: To return an arraylist of the countries within a Region
     * @param con - A variable of type 'Connection' called con which uses the connection between the database
     * and intellij / the program.
     * @return an arraylist of the Country class
     */
    public ArrayList getCountriesFromRegion(Connection con)
    {
        try
        {

            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital"
                            + " FROM country "
                            +  " WHERE Region = 'South America' "
                            + "ORDER BY Population DESC";
            // Execute SQL statement
            // Return countries


            PreparedStatement stmt = con.prepareStatement(strSelect);
            ResultSet rs = stmt.executeQuery();

            ArrayList countries = new ArrayList<Country>();
            while (rs.next())
            {
                Country country = new Country();
                country.code = rs.getString("Code");
                country.name = rs.getString("Name");
                country.continent = rs.getString("Continent");
                country.region = rs.getString("Region");
                country.population = rs.getInt("Population");
                country.capital = rs.getInt("Capital");;

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
     * Name: getLargestPopulatedCountriesdFromWolrd / Query 4
     * description: To return an arraylist of the countries within the world
     * @param con - A variable of type 'Connection' called con which uses the connection between the database
     * and intellij / the program.
     * @return an arraylist of the Country class
     */
    public ArrayList getLargestPopulatedCountriesFromWorld(Connection con)
    {
        try
        {

            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital"
                            + " FROM country "
                            + "ORDER BY Population DESC "
                            + "LIMIT 10 ";
            // Execute SQL statement
            // Return countries


            PreparedStatement stmt = con.prepareStatement(strSelect);
            ResultSet rs = stmt.executeQuery();

            ArrayList countries = new ArrayList<Country>();
            while (rs.next())
            {
                Country country = new Country();
                country.code = rs.getString("Code");
                country.name = rs.getString("Name");
                country.continent = rs.getString("Continent");
                country.region = rs.getString("Region");
                country.population = rs.getInt("Population");
                country.capital = rs.getInt("Capital");;

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
     * Name: getLargestPopulatedCountriesFromContinent / Query 5
     * description: To return an arraylist of the countries within a continent
     * @param con - A variable of type 'Connection' called con which uses the connection between the database
     * and intellij / the program.
     * @return an arraylist of the Country class
     */
    public ArrayList getLargestPopulatedCountriesFromContinent(Connection con)
    {
        try
        {

            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital"
                            + " FROM country "
                            + "WHERE Continent = 'Asia'"
                            + "ORDER BY Population DESC "
                            + "LIMIT 10;";
            // Execute SQL statement
            // Return countries


            PreparedStatement stmt = con.prepareStatement(strSelect);
            ResultSet rs = stmt.executeQuery();

            ArrayList countries = new ArrayList<Country>();
            while (rs.next())
            {
                Country country = new Country();
                country.code = rs.getString("Code");
                country.name = rs.getString("Name");
                country.continent = rs.getString("Continent");
                country.region = rs.getString("Region");
                country.population = rs.getInt("Population");
                country.capital = rs.getInt("Capital");;

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
     * Name: getLargestPopulatedCountriesFromRegion / Query 6
     * description: To return an arraylist of the countries within Region
     * @param con - A variable of type 'Connection' called con which uses the connection between the database
     * and intellij / the program.
     * @return an arraylist of the Country class
     */
    public ArrayList getLargestPopulatedCountriesFromRegion(Connection con)
    {
        try
        {

            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital"
                            + " FROM country "
                            + "WHERE Region = 'Caribbean'"
                            + "ORDER BY Population DESC "
                            + "LIMIT 5 ";
            // Execute SQL statement
            // Return countries


            PreparedStatement stmt = con.prepareStatement(strSelect);
            ResultSet rs = stmt.executeQuery();

            ArrayList countries = new ArrayList<Country>();
            while (rs.next())
            {
                Country country = new Country();
                country.code = rs.getString("Code");
                country.name = rs.getString("Name");
                country.continent = rs.getString("Continent");
                country.region = rs.getString("Region");
                country.population = rs.getInt("Population");
                country.capital = rs.getInt("Capital");;

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
    public void displayCountries(ArrayList<Country> countries, String queryName)
    {
        // Print out query name
        System.out.println(queryName);


        // Print out the queries in the arraylist
        for (Country country: countries) {

            String details = ("" + country.name + ", " + country.code +
                    ", " + country.continent + ", " + country.region +
                    ", " + country.population + ", " + country.capital);

            System.out.println(details);
        }

        System.out.println("\n\n\n");
    }



}