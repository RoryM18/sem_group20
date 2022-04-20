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
        ArrayList<Capital> capitals = a.getCapitals();
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


        /**Name: getCities / Query 1
         *description: To return an arraylist of the cities within the world database
         *@param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return an arraylist of the City class      */
        ArrayList<City> cities = a.getCities();
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


        //Query 1: All the countries in the world organised by largest population to smallest.
        // invoke a functinon to get the countris as an arraylist
        ArrayList<Country> countries = a.getCountries();
        // invoke a function to display the results of the query to the user
        a.displayCountries(countries, "Query 1: All the countries in the world organised by largest population to smallest. ");
        countries.clear();


        //Query 2: All the countries in a continent organised by largest population to smallest.
        // invoke a function to get the countries as an arraylist
        countries = a.getCountriesFromContinent();
        a.displayCountries(countries, "Query 2: All the countries in a continent organised by largest population to smallest.");


        //Query 3: All the countries in a region organised by largest population to smallest.
        // invoke a function to get the countries as an arraylist
        countries = a.getCountriesFromRegion();
        a.displayCountries(countries, "Query 3: All countries in a region by largest population to smallest.");


        //Query 4: Show X number of countries in the world with the largest population
        // invoke a function to get the countries as an arraylist
        countries = a.getLargestPopulatedCountriesFromWorld();
        a.displayCountries(countries, "Query 4: Show X number of countries in the world with the largest population");

        //Query 5: Show X number of countries in the Continent with the largest population
        // invoke a function to get the countries as an arraylist
        countries = a.getLargestPopulatedCountriesFromContinent();
        a.displayCountries(countries, "Query 5: Show X number of countries in the Continent with the largest population");

        //Query 6: Show X number of countries in the Region with the largest population
        // invoke a function to get the countries as an arraylist
        countries = a.getLargestPopulatedCountriesFromRegion();
        a.displayCountries(countries, "Query 6: Show X number of countries in the Region with the largest population");

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
            ArrayList capitals = new ArrayList<Capital>();
            while (rset.next())
            {
                Capital capital = new Capital();
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
            ArrayList capitals = new ArrayList<Capital>();
            while (rset.next())
            {
                Capital capital = new Capital();
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
            ArrayList capitals = new ArrayList<Capital>();
            while (rset.next())
            {
                Capital capital = new Capital();
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
            ArrayList capitals = new ArrayList<Capital>();
            while (rset.next())
            {
                Capital capital = new Capital();
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
            ArrayList capitals = new ArrayList<Capital>();
            while (rset.next())
            {
                Capital capital = new Capital();
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
            ArrayList capitals = new ArrayList<Capital>();
            while (rset.next())
            {
                Capital capital = new Capital();
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

    public void displayCapitals(ArrayList<Capital> capitals, String query)
    {
        // Check cities is not null
        if (capitals == null)
        {
            System.out.println("No capital cities in arrayList");
            return;
        }
        System.out.println("\n\n\n" + query);

        for (Capital capital: capitals) {

            if (capital == null)
                continue;
            String details = (
                    capital.name + ", " +
                    capital.country + ", "
                    + capital.population);

            System.out.println(details);
        }
    }

    /**
     * Name: getCities
     * description: To return an arraylist of the cities within the world database
     * and intellij / the program.
     * @return an arraylist of the City class
     */
    public ArrayList getCities()
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



    public void displayCities(ArrayList<City> cities, String query)
    {
        // Check cities is not null
        if (cities == null)
        {
            System.out.println("No cities is arrayList");
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





    public ArrayList getCountries()
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
            while (rs.next())
            {
                Country country = new Country();
                country.code = rs.getString("Code");
                country.name = rs.getString("Name");
                country.continent = rs.getString("Continent");
                country.region = rs.getString("Region");
                country.population = rs.getInt("Population");
                country.capital = rs.getInt("Capital");
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
     * Name: getCountriesFromContinent / Query 2
     * description: To return an arraylist of the countries within a continent
     * and intellij / the program.
     * @return an arraylist of the Country class
     */
    public ArrayList getCountriesFromContinent()
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
     * and intellij / the program.
     * @return an arraylist of the Country class
     */
    public ArrayList getCountriesFromRegion()
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
     * and intellij / the program.
     * @return an arraylist of the Country class
     */
    public ArrayList getLargestPopulatedCountriesFromWorld()
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
     * and intellij / the program.
     * @return an arraylist of the Country class
     */
    public ArrayList getLargestPopulatedCountriesFromContinent()
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
     * and intellij / the program.
     * @return an arraylist of the Country class
     */
    public ArrayList getLargestPopulatedCountriesFromRegion()
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
        if (countries == null)
        {
            System.out.println("No Countries in the arrayList");
            return;
        }
        // Print out query name
        System.out.println(queryName);


        // Print out the queries in the arraylist
        for (Country country: countries) {

            if (country == null)
                continue;
            String details = ("" + country.name + ", " + country.code +
                    ", " + country.continent + ", " + country.region +
                    ", " + country.population + ", " + country.capital);

            System.out.println(details);
        }

        System.out.println("\n\n\n");
    }

    /**
     * Name: displayCountries
     * description: Print the details to do with every country and their population in descending order
     * @param countries Arraylist of the Country class
     */

    public void displayCountries2(ArrayList<Country> countries, String queryName)
    {
        if (countries == null)
        {
            System.out.println("No Countries could be found");
            return;
        }
        // Print out query name
        System.out.println(queryName);


        // Print out the queries in the arraylist
        for (Country country: countries) {

            String details = ("" + country.name + ", " + country.code +
                    ", " + country.continent + ", " + country.region +
                    ", " + country.population + ", " + country.capital +
                    ", " + country.surfaceArea + ", " + country.indepYear +
                    ", " + country.lifeExpectancy + ", "+ country.gnp +
                    ", " + country.gnpOld + ", " + country.localName +
                    ", " + country.govermentForm + ", " + country.HeadOfState +
                    ", " + country.code2);

            System.out.println(details);
        }

        System.out.println("\n\n\n");
    }



    public void displayCountryLanguage(ArrayList<CountryLanguage> countrylanguages, String query)
    {
        // Check cities is not null
        if (countrylanguages == null)
        {
            System.out.println("No Country Languages is arrayList");
            return;
        }
        System.out.println("\n\n\n" + query);

        for (CountryLanguage countrylanguage: countrylanguages) {

            if (countrylanguage == null)
                continue;
            String details = (
                    countrylanguage.countryCode + ", " +
                            countrylanguage.Language + ", " +
                            countrylanguage.isOfficial + ", " +
                            countrylanguage.percentage );

            System.out.println(details);
        }
    }
}