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



        /**Name: getCities / Query 1
         *description: To return an arraylist of the cities within the world database
         *@param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return an arraylist of the City class      */
        ArrayList<City> cities = a.getCapitals();
        a.displayCities(cities, "Query 1: return an arraylist of the cities within the world");



        /**Name: getCitiesByAContinent / Query 2
         *description: To return an arraylist of the cities within a Continent
         * @param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return an arraylist of the city class      */
        cities = a.getCitiesByAContinent();
        // Invoke a function to display the results of the query to the user
        a.displayCities(cities, "Query 2: return an arraylist of the cities within a continent");


        /**Name: getCitiesByRegion / Query 3
         *description: To return an arraylist of the cities within a region
         * @param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return an arraylist of the city class      */
        cities = a.getCitiesByRegion();
        // Invoke a function to display the results of the query to the user
        a.displayCities(cities, "Query 3: return an arraylist of the cities within a region");


        /**Name: getCitiesByCountry / Query 4
         *description: To return an arraylist of the cities within a Country
         * @param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return an arraylist of the city class      */
        cities = a.getCitiesByACountry();
        // Invoke a function to display the results of the query to the user
        a.displayCities(cities, "Query 4: return an arraylist of the cities within a Country");


        /**Name: getCitiesByDistrict / Query 5
         *description: To return an arraylist of the cities within a distric
         * @param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return an arraylist of the city class      */
        cities = a.getCitiesByADistrict();
        // Invoke a function to display the results of the query to the user
        a.displayCities(cities, "Query 5: return an arraylist of the cities within a District");

        /**Name: getLargestPopulatedCitiesFromWorld / Query 6
         *description: To return an arraylist of the selected number of cities within world
         * @param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return an arraylist of the city class      */
        cities = a.getLargestPopulatedCitiesFromWorld();
        // Invoke a function to display the results of the query to the user
        a.displayCities(cities, "Query 6: return an arraylist of the selected number of cities within world");

        /**Name: getLargestPopulatedCitiesFromAContinent / Query 7
         *description: To return an arraylist of the selected number of cities within world of a selected continent
         * @param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return an arraylist of the city class      */
        cities = a.getLargestPopulatedCitiesFromAContinent();
        // Invoke a function to display the results of the query to the user
        a.displayCities(cities, "Query 7: return an arraylist of the selected number of cities within world of a selected continent");

        /**Name: getLargestPopulatedCitiesFromARegion / Query 8
         *description: To return an arraylist of the selected number of cities within world of a selected Region
         * @param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return an arraylist of the city class      */
        cities = a.getLargestPopulatedCitiesFromARegion();
        // Invoke a function to display the results of the query to the user
        a.displayCities(cities, "Query 8: return an arraylist of the selected number of cities within world of a selected Region");

        /**Name: getLargestPopulatedCitiesFromACountry / Query 9
         *description: To return an arraylist of the selected number of cities within world of a selected Country
         * @param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return an arraylist of the city class      */
        cities = a.getLargestPopulatedCitiesFromACountry();
        // Invoke a function to display the results of the query to the user
        a.displayCities(cities, "Query 9: return an arraylist of the selected number of cities within world of a selected Country");

        /**Name: getLargestPopulatedCitiesFromADistrict / Query 10
         *description: To return an arraylist of the selected number of cities within world of a selected District
         * @param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return an arraylist of the city class      */
        cities = a.getLargestPopulatedCitiesFromADistrict();
        // Invoke a function to display the results of the query to the user
        a.displayCities(cities, "Query 10: return an arraylist of the selected number of cities within world of a selected District");


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
     * Name: getCities
     * description: To return an arraylist of the cities within the world database
     * and intellij / the program.
     * @return an arraylist of the City class
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
                            + " FROM city JOIN country ON (city.CountryCode = country.Code) "
                            + " ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries
            ArrayList capitals = new ArrayList<Capitals>();
            while (rset.next())
            {
                Capitals capital = new Capitals();
                capital.name = rset.getString("capital.Name");
                capital.country = rset.getString("country.Name");
                capital.population = rset.getInt("capital.Population");
                capitals.add(capital);
            }
            return capitals;
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
     * and intellij / the program.
     * @return an arraylist of the City class
     */
    public ArrayList getCitiesByAContinent()
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
     * @return an arraylist of the city class      */
    public ArrayList getCitiesByRegion()
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
     * @return an arraylist of the city class      */
    public ArrayList getCitiesByACountry()
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
     * @return an arraylist of the city class      */
    public ArrayList getCitiesByADistrict()
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
     * and intellij / the program.
     * @return an arraylist of the City class
     */
    public ArrayList getLargestPopulatedCitiesFromWorld()
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

    /**
     * Name: getLargestPopulatedCitiesFromAContinent
     * description: To return an arraylist of the cities within the world database from a specific continent
     * and intellij / the program.
     * @return an arraylist of the City class
     */
    public ArrayList getLargestPopulatedCitiesFromAContinent()
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
            System.out.println("Failed to get City details");
            return null;
        }
    }

    public void displayCities(ArrayList<City> cities, String query)
    {
        // Check cities is not null
        if (cities == null)
        {
            System.out.println("No cities in arrayList");
            return;
        }
        System.out.println("\n\n\n" + query);

        for (City city: cities) {

            if (city == null)
                continue;
            String details = (
                    city.name + ", " +
                    city.country + ", "
                    + city.district + ", "
                    + city.population);

            System.out.println(details);
        }
    }
}