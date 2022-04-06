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

    private Connection con = null;

    public static void main(String[] args)
    {
        // Create new Application and connect to database
        App a = new App();

        if(args.length < 1){
            a.connect("localhost:33060", 30000);
        }else{
            a.connect(args[0], Integer.parseInt(args[1]));
        }


        // invoke a function to get the Cities as an arraylist



        /**Name: getCapitals / Query 1
         *description: To return an arraylist of the capital cities within the world database
         *@param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return an arraylist of the Capital class      */
        ArrayList<Capitals> capitals = a.getCapitals();
        a.displayCapitals(capitals, "Query 1: return an arraylist of the cities within the world");

        /**Name: getCapitalsByAContinent / Query 2
         *description: To return an arraylist of the capital cities within the world database by a continent
         *@param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return an arraylist of the Capital class      */
        capitals = a.getCapitalsByAContinent();
        a.displayCapitals(capitals, "Query 2: return an arraylist of the capital cities within the world by a Continent");

        /**Name: getCapitalsByARegion / Query 3
         *description: To return an arraylist of the capital cities within the world database by a Region
         *@param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return an arraylist of the Capital class      */
        capitals = a.getCapitalsByARegion();
        a.displayCapitals(capitals, "Query 3: return an arraylist of the capital cities within the world by a Region");

        /**Name: getCapitalsByARegion / Query 4
         *description: To return an arraylist of the capital cities within the world database
         *@param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return an arraylist of the Capital class      */
        capitals = a.getLargestPopulatedCapitalCitiesFromWorld();
        a.displayCapitals(capitals, "Query 4: return an arraylist of the capital cities within the world");

        /**Name: getCapitalsByARegion / Query 5
         *description: To return an arraylist of the capital cities within the world database
         *@param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return an arraylist of the Capital class      */
        capitals = a.getLargestPopulatedCapitalCitiesFromWorldBYContinent();
        a.displayCapitals(capitals, "Query 5: return an arraylist of the capital cities within the world by a continent");

        /**Name: getLargestPopulatedCapitalCitiesFromARegion / Query 6
         *description: To return an arraylist of the capital cities within the world database by a Region
         *@param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return an arraylist of the Capital class      */
        capitals = a.getLargestPopulatedCapitalCitiesFromARegion();
        a.displayCapitals(capitals, "Query 6: return an arraylist of the capital cities within the world by a region");



        a.disconnect();

    }

    public void connect(String location, int delay) {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(delay);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql:// " + location + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    public void disconnect() {
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
     * Name: getCapitals
     * description: To return an arraylist of the capital cities within the world database
     * and intellij / the program.
     * @return an arraylist of the Capitals class
     */
    public ArrayList getCapitals()
    {
        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.Population "
                            + " FROM city JOIN country ON (city.id = country.capital) "
                            + "WHERE city.id = country.capital "
                            + " ORDER BY Population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries
            ArrayList capitals = new ArrayList<Capitals>();
            while (rset.next())
            {
                Capitals capital = new Capitals();
                capital.name = rset.getString("city.Name");
                capital.country = rset.getString("country.Name");
                capital.population = rset.getInt("city.Population");
                capitals.add(capital);
            }
            return capitals;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Capital City details");
            return null;
        }
    }


    /**
     * Name: getCapitalsByAContinent
     * description: To return an arraylist of the capital cities within the world database by a continent
     * and intellij / the program.
     * @return an arraylist of the Capital class
     */
    public ArrayList getCapitalsByAContinent()
    {
        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.Population "
                            + " FROM city JOIN country ON (city.id = country.capital) "
                            + "WHERE city.id = country.capital AND continent = 'Oceania'"
                            + " ORDER BY Population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries
            ArrayList capitals = new ArrayList<Capitals>();
            while (rset.next())
            {
                Capitals capital = new Capitals();
                capital.name = rset.getString("city.Name");
                capital.country = rset.getString("country.Name");
                capital.population = rset.getInt("city.Population");
                capitals.add(capital);
            }
            return capitals;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Capital City details");
            return null;
        }
    }





    /**
     * Name: getCapitalsByARegion
     * description: To return an arraylist of the capital cities within the world database by a region
     * and intellij / the program.
     * @return an arraylist of the Capital class
     */
    public ArrayList getCapitalsByARegion()
    {
        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.Population "
                            + " FROM city JOIN country ON (city.id = country.capital) "
                            + "WHERE city.id = country.capital AND region = 'British Islands'"
                            + " ORDER BY Population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries
            ArrayList capitals = new ArrayList<Capitals>();
            while (rset.next())
            {
                Capitals capital = new Capitals();
                capital.name = rset.getString("city.Name");
                capital.country = rset.getString("country.Name");
                capital.population = rset.getInt("city.Population");
                capitals.add(capital);
            }
            return capitals;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Capital City details");
            return null;
        }
    }


    /**Name: getCitiesByCountry
     *description: To return an arraylist of the cities within a City
     * @return an arraylist of the city class      */
    public ArrayList getLargestPopulatedCapitalCitiesFromWorld()
    {
        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.Population "
                            + " FROM city JOIN country ON (city.id = country.capital) "
                            + " ORDER BY Population DESC "
                            + " LIMIT 10 ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries
            ArrayList capitals = new ArrayList<Capitals>();
            while (rset.next())
            {
                Capitals capital = new Capitals();
                capital.name = rset.getString("city.Name");
                capital.country = rset.getString("country.Name");
                capital.population = rset.getInt("city.Population");
                capitals.add(capital);
            }
            return capitals;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Capital City details");
            return null;
        }
    }

    /**
     * Name: getLargestPopulatedCitiesFromWorldBYContinent
     * description: To return an arraylist of the capital cities within the world database by a continent
     * and intellij / the program.
     * @return an arraylist of the City class
     */
    public ArrayList getLargestPopulatedCapitalCitiesFromWorldBYContinent()
    {
        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.Population "
                            + " FROM city JOIN country ON (city.id = country.capital) "
                            + "WHERE city.id = country.capital AND continent = 'Oceania'"
                            + " ORDER BY Population DESC "
                            + "LIMIT 10 ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries
            ArrayList capitals = new ArrayList<Capitals>();
            while (rset.next())
            {
                Capitals capital = new Capitals();
                capital.name = rset.getString("city.Name");
                capital.country = rset.getString("country.Name");
                capital.population = rset.getInt("city.Population");
                capitals.add(capital);
            }
            return capitals;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Capital City details");
            return null;
        }
    }

    /**
     * Name: getLargestPopulatedCitiesFromARegion
     * description: To return an arraylist of the cities within the world database from a specific Region
     * and intellij / the program.
     * @return an arraylist of the City class
     */
    public ArrayList getLargestPopulatedCapitalCitiesFromARegion()
    {
        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.Population "
                            + " FROM city JOIN country ON (city.id = country.capital) "
                            + "WHERE city.id = country.capital AND region = 'Southern and Central Asia'"
                            + " ORDER BY Population DESC "
                            + "LIMIT 10 ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries
            ArrayList capitals = new ArrayList<Capitals>();
            while (rset.next())
            {
                Capitals capital = new Capitals();
                capital.name = rset.getString("city.Name");
                capital.country = rset.getString("country.Name");
                capital.population = rset.getInt("city.Population");
                capitals.add(capital);
            }
            return capitals;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Capital City details");
            return null;
        }
    }

    /**
     * Name: getLargestPopulatedCitiesFromARegion
     * description: To return an arraylist of the cities within the world database from a specific Region
     * and intellij / the program.
     * @return an arraylist of the City class
     */
    public ArrayList getLargestPopulatedCitiesFromARegion()
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
                            + " ORDER BY Population DESC "
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

    /**
     * Name: getLargestPopulatedCitiesFromACountry
     * description: To return an arraylist of the cities within the world database from a specific country
     * and intellij / the program.
     * @return an arraylist of the City class
     */
    public ArrayList getLargestPopulatedCitiesFromACountry()
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
                            + " ORDER BY city.Population DESC "
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

    /**
     * Name: getLargestPopulatedCitiesFromADistrict
     * description: To return an arraylist of the cities within the world database from a specific District
     * and intellij / the program.
     * @return an arraylist of the City class
     */
    public ArrayList getLargestPopulatedCitiesFromADistrict()
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
                            + " ORDER BY Population DESC "
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
            System.out.println("Failed to get Capital City details");
            return null;
        }
    }

    public void displayCapitals(ArrayList<Capitals> capitals, String query)
    {
        // Check cities is not null
        if (capitals == null)
        {
            System.out.println("No capital cities in arrayList");
            return;
        }
        System.out.println("\n\n\n" + query);

        for (Capitals capital: capitals) {

            if (capital == null)
                continue;
            String details = (
                    capital.name + ", " +
                    capital.country + ", "
                    + capital.population);

            System.out.println(details);
        }
    }
}