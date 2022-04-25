package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;
import java.math.*;

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


        /**Name: getCities / Query 7
         *description: To return an arraylist of the cities within the world database
         *@param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return an arraylist of the City class      */
        ArrayList<City> cities = a.getCities();
        a.displayCities(cities, "Query 7: return an arraylist of the cities within the world");



        /**Name: getCitiesByAContinent / Query 8
         *description: To return an arraylist of the cities within a Continent
         * @param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return an arraylist of the city class      */
        cities = a.getCitiesByAContinent();
        // Invoke a function to display the results of the query to the user
        a.displayCities(cities, "Query 8: return an arraylist of the cities within a continent");


        /**Name: getCitiesByRegion / Query 9
         *description: To return an arraylist of the cities within a region
         * @param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return an arraylist of the city class      */
        cities = a.getCitiesByRegion();
        // Invoke a function to display the results of the query to the user
        a.displayCities(cities, "Query 9: return an arraylist of the cities within a region");


        /**Name: getCitiesByCountry / Query 10
         *description: To return an arraylist of the cities within a Country
         * @param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return an arraylist of the city class      */
        cities = a.getCitiesByACountry();
        // Invoke a function to display the results of the query to the user
        a.displayCities(cities, "Query 10: return an arraylist of the cities within a Country");


        /**Name: getCitiesByDistrict / Query 11
         *description: To return an arraylist of the cities within a distric
         * @param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return an arraylist of the city class      */
        cities = a.getCitiesByADistrict();
        // Invoke a function to display the results of the query to the user
        a.displayCities(cities, "Query 11: return an arraylist of the cities within a District");

        /**Name: getLargestPopulatedCitiesFromWorld / Query 12
         *description: To return an arraylist of the selected number of cities within world
         * @param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return an arraylist of the city class      */
        cities = a.getLargestPopulatedCitiesFromWorld();
        // Invoke a function to display the results of the query to the user
        a.displayCities(cities, "Query 12: return an arraylist of the selected number of cities within world");

        /**Name: getLargestPopulatedCitiesFromAContinent / Query 13
         *description: To return an arraylist of the selected number of cities within world of a selected continent
         * @param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return an arraylist of the city class      */
        cities = a.getLargestPopulatedCitiesFromAContinent();
        // Invoke a function to display the results of the query to the user
        a.displayCities(cities, "Query 13: return an arraylist of the selected number of cities within world of a selected continent");

        /**Name: getLargestPopulatedCitiesFromARegion / Query 14
         *description: To return an arraylist of the selected number of cities within world of a selected Region
         * @param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return an arraylist of the city class      */
        cities = a.getLargestPopulatedCitiesFromARegion();
        // Invoke a function to display the results of the query to the user
        a.displayCities(cities, "Query 14: return an arraylist of the selected number of cities within world of a selected Region");

        /**Name: getLargestPopulatedCitiesFromACountry / Query 15
         *description: To return an arraylist of the selected number of cities within world of a selected Country
         * @param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return an arraylist of the city class      */
        cities = a.getLargestPopulatedCitiesFromACountry();
        // Invoke a function to display the results of the query to the user
        a.displayCities(cities, "Query 15: return an arraylist of the selected number of cities within world of a selected Country");

        /**Name: getLargestPopulatedCitiesFromADistrict / Query 16
         *description: To return an arraylist of the selected number of cities within world of a selected District
         * @param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return an arraylist of the city class      */
        cities = a.getLargestPopulatedCitiesFromADistrict();
        // Invoke a function to display the results of the query to the user
        a.displayCities(cities, "Query 16: return an arraylist of the selected number of cities within world of a selected District");


        //Query 17: All the countries in the world organised by largest population to smallest.
        // invoke a functinon to get the countris as an arraylist
        ArrayList<Country> countries = a.getCountries();
        // invoke a function to display the results of the query to the user
        a.displayCountries(countries, "Query 17: All the countries in the world organised by largest population to smallest. ");
        countries.clear();


        //Query 18: All the countries in a continent organised by largest population to smallest.
        // invoke a function to get the countries as an arraylist
        countries = a.getCountriesFromContinent();
        a.displayCountries(countries, "Query 18: All the countries in a continent organised by largest population to smallest.");


        //Query 19: All the countries in a region organised by largest population to smallest.
        // invoke a function to get the countries as an arraylist
        countries = a.getCountriesFromRegion();
        a.displayCountries(countries, "Query 19: All countries in a region by largest population to smallest.");


        //Query 20: Show X number of countries in the world with the largest population
        // invoke a function to get the countries as an arraylist
        countries = a.getLargestPopulatedCountriesFromWorld();
        a.displayCountries(countries, "Query 20: Show X number of countries in the world with the largest population");

        //Query 21: Show X number of countries in the Continent with the largest population
        // invoke a function to get the countries as an arraylist
        countries = a.getLargestPopulatedCountriesFromContinent();
        a.displayCountries(countries, "Query 21: Show X number of countries in the Continent with the largest population");

        //Query 22: Show X number of countries in the Region with the largest population
        // invoke a function to get the countries as an arraylist
        countries = a.getLargestPopulatedCountriesFromRegion();
        a.displayCountries(countries, "Query 22 : Show X number of countries in the Region with the largest population");





        String details ="";

        /**Name: getWolrdPopulation / Query 23
         *description: To return the report on the population the world
         *@param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return a string on the report    */
        details = a.getWorldPopulation();
        a.displayPopulation(details, "Query 23: return the report on the population of the world");


        /**Name: getContinentPopulation / Query 24
         *description: To return the report on the population a continent
         *@param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return a string on the report    */
        details = a.getContinentPopulation();
        a.displayPopulation(details, "Query 24: return the report on the population of a continent");



        /**Name: getRegionPopulation / Query 25
         *description: To return the report on the population a Region
         *@param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return a string on the report    */
        details = a.getRegionPopulation();
        a.displayPopulation(details, "Query 25: return the report on the population of a region");


        /**Name: getCountryPopulation / Query 26
         *description: To return the report on the population a country
         *@param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return a string on the report    */
        details = a.getCountryPopulation();
        a.displayPopulation(details, "Query 26: return the report on the population of a country");

        /**Name: getDistrictPopulation / Query 27
         *description: To return the report on the population a district
         *@param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return a string on the report    */
        details = a.getDistrictPopulation();
        a.displayPopulation(details, "Query 27: return the report on the population of a district");



        /**Name: getOnlyWorldPopulation/ Query 28
         *description: To return the world population
         *@param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return a string on population   */
        details =  a.getOnlyWorldPopulation();
        a.displayPopulation(details, "Query 28: return the population of the world");


        /**Name: getOnlyContinentPopulation/ Query 29
         *description: To return a continents population
         *@param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return a string on population   */
        details =  a.getOnlyContinentPopulation();
        a.displayPopulation(details, "Query 29: return the population of a continent");

        /**Name: getOnlyRegionPopulation/ Query 30
         *description: To return a region population
         *@param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return a string on population   */
        details =  a.getOnlyRegionPopulation();
        a.displayPopulation(details, "Query 30: return the population of a region");


        /**Name: getOnlyCountryPopulation/ Query 31
         *description: To return a country population
         *@param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return a string on population   */
        details =  a.getOnlyCountryPopulation();
        a.displayPopulation(details, "Query 31: return the population of a country");



/**Name: getOnlyDistrictPopulation/ Query 32
 *description: To return a distrcits population
 *@param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
 * @return a string on population   */
        details =  a.getOnlyDistrictPopulation();
        a.displayPopulation(details, "Query 32: return the population of a district");





/**Name: getLanguageReport //Query 33
 *description: return number of people who speak the following the following languages ('Chinese','Hindi','English','Spanish','Arabic') from greatest number to smallest, including the percentage of the world population
 *@param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
 * @return a string on the report    */
      details = a.getLanguageReport();
        a.displayLanguage(details, "Query 33 :return number of people who speak the following the following languages ('Chinese','Hindi','English','Spanish','Arabic') from greatest number to smallest, including the percentage of the world population:");









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






    /**
     * Name: getWorldPopulation
     * description: To return the population report on the world
     * and intellij / the program.
     * @return
     */
    public String getWorldPopulation()
    {
        String details = "";
        long totalPopulation = -1;
        long cityPopulation = -1;
        //name of the area
        String area ="World";
        BigDecimal tp = new BigDecimal(0);
        BigDecimal cp = new BigDecimal(0);

        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(country.Population) FROM country";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries


            while (rset.next())
            {
                //population of the wolrd
                tp = rset.getBigDecimal("SUM(country.Population)");
            }


            details = area + ", "+ tp + ", ";


        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get total Population details");
            return details;
        }
        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(Population) FROM city";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries



            while (rset.next())
            {
                //population of the wolrd
                cp = rset.getBigDecimal("SUM(Population)");
            }


            BigDecimal ncp = tp;
            ncp = ncp.subtract(cp);
            ncp = ncp.multiply(new BigDecimal(100));
            ncp = ncp.divide(tp, 2, RoundingMode.HALF_UP);


            cp = cp.multiply(new BigDecimal(100));
            cp = cp.divide(tp, 2, RoundingMode.HALF_UP);



            details = details +  cp + "%, " + ncp+ "%";




            return details;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city Population details");
            return details;
        }

    }





    /**
     * Name: getContinentPopulation
     * description: To return the population report on a continent
     * and intellij / the program.
     * @return
     */
    public String getContinentPopulation()
    {
        String details = "";

        //name of the area
        String area ="";
        BigDecimal tp = new BigDecimal(0);
        BigDecimal cp = new BigDecimal(0);

        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Continent, SUM(country.Population) FROM country WHERE Continent = 'Asia'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries


            while (rset.next())
            {
                //population of the wolrd
                tp = rset.getBigDecimal("SUM(country.Population)");
                area = rset.getString("Continent");
            }


            details = area + ", "+ tp + ", ";


        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get total Population details");
            return details;
        }
        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(city.Population) FROM country JOIN city ON (country.Code = city.countryCode) WHERE Continent = 'Asia'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries


            while (rset.next())
            {
                //population of the wolrd
                cp = rset.getBigDecimal("SUM(city.Population)");
            }


            BigDecimal ncp = tp;
            ncp = ncp.subtract(cp);
            ncp = ncp.multiply(new BigDecimal(100));
            ncp = ncp.divide(tp, 2, RoundingMode.HALF_UP);


            cp = cp.multiply(new BigDecimal(100));
            cp = cp.divide(tp, 2, RoundingMode.HALF_UP);



            details = details +  cp + "%, " + ncp+ "%";




            return details;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city Population details");
            return details;
        }

    }


    /**
     * Name: getRegionPopulation
     * description: To return the population report on a region
     * and intellij / the program.
     * @return
     */
    public String getRegionPopulation()
    {
        String details = "";

        //name of the area
        String area ="";
        BigDecimal tp = new BigDecimal(0);
        BigDecimal cp = new BigDecimal(0);

        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Region, SUM(country.Population) FROM country WHERE Region = 'Caribbean'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries


            while (rset.next())
            {
                //population of the wolrd
                tp = rset.getBigDecimal("SUM(country.Population)");
                area = rset.getString("Region");
            }


            details = area + ", "+ tp + ", ";


        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get total Population details");
            return details;
        }
        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT SUM(city.Population) FROM country JOIN city ON (country.Code = city.countryCode) WHERE Region = 'Caribbean'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries



            while (rset.next())
            {
                //population of the wolrd
                cp = rset.getBigDecimal("SUM(city.Population)");
            }


            BigDecimal ncp = tp;
            ncp = ncp.subtract(cp);
            ncp = ncp.multiply(new BigDecimal(100));
            ncp = ncp.divide(tp, 2, RoundingMode.HALF_UP);


            cp = cp.multiply(new BigDecimal(100));
            cp = cp.divide(tp, 2, RoundingMode.HALF_UP);



            details = details +  cp + "%, " + ncp+ "%";




            return details;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city Population details");
            return details;
        }

    }




    /**
     * Name: getCountryPopulation
     * description: To return the population report on a country
     * and intellij / the program.
     * @return
     */
    public String getCountryPopulation()
    {
        String details = "";

        //name of the area
        String area ="";
        BigDecimal tp = new BigDecimal(0);
        BigDecimal cp = new BigDecimal(0);

        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Name, SUM(country.Population) FROM country WHERE Name = 'India'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries


            while (rset.next())
            {
                //population of the wolrd
                tp = rset.getBigDecimal("SUM(country.Population)");
                area = rset.getString("Name");
            }


            details = area + ", "+ tp + ", ";


        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get total Population details");
            return details;
        }
        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(city.Population) FROM country JOIN city ON (country.Code = city.countryCode) WHERE country.Name = 'India'";
            // Execute SQL statement

            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries



            while (rset.next())
            {
                //population of the wolrd
                cp = rset.getBigDecimal("SUM(city.Population)");
            }


            BigDecimal ncp = tp;
            ncp = ncp.subtract(cp);
            ncp = ncp.multiply(new BigDecimal(100));
            ncp = ncp.divide(tp, 2, RoundingMode.HALF_UP);


            cp = cp.multiply(new BigDecimal(100));
            cp = cp.divide(tp, 2, RoundingMode.HALF_UP);



            details = details +  cp + "%, " + ncp+ "%";




            return details;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city Population details");
            return details;
        }

    }


    /**
     * Name: getDistrictPopulation
     * description: To return the population report on a district
     * and intellij / the program.
     * @return
     */
    public String getDistrictPopulation()
    {
        String details = "";

        //name of the area
        String area ="New York";
        BigDecimal tp = new BigDecimal(0);
        BigDecimal cp = new BigDecimal(0);

        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT SUM(city.Population) FROM country JOIN city ON (country.Code = city.countryCode) WHERE District = 'New York'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries



            while (rset.next())
            {
                //population of the wolrd
                tp = rset.getBigDecimal("SUM(city.Population)");
                cp = rset.getBigDecimal("SUM(city.Population)");
            }


            BigDecimal ncp = tp;
            ncp = ncp.subtract(cp);
            ncp = ncp.multiply(new BigDecimal(100));
            ncp = ncp.divide(tp, 2, RoundingMode.HALF_UP);


            cp = cp.multiply(new BigDecimal(100));
            cp = cp.divide(tp, 2, RoundingMode.HALF_UP);



            details = details + area + ",  " + tp + ", " + cp + "%, " + ncp+ "%";




            return details;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city Population details");
            return details;
        }

    }







    /**
     * Name: getOnlyWorldPopulation
     * description: To return the population of the world
     * and intellij / the program.
     * @return
     */
    public String getOnlyWorldPopulation()
    {
        String details = "World, ";
        BigDecimal tp = new BigDecimal(0);

        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(country.Population) FROM country";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries


            while (rset.next())
            {
                //population of the wolrd
                tp = rset.getBigDecimal("SUM(country.Population)");
            }


            details = details + tp;

            return details;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get total Population details");
            return details;
        }

    }




    /**
     * Name: getOnlyContinentPopulation
     * description: To return the population of a continent
     * and intellij / the program.
     * @return
     */
    public String getOnlyContinentPopulation()
    {
        String details = "Asia, ";
        BigDecimal tp = new BigDecimal(0);

        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(country.Population) FROM country WHERE Continent = 'Asia'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries


            while (rset.next())
            {
                //population of the wolrd
                tp = rset.getBigDecimal("SUM(country.Population)");
            }


            details = details + tp;

            return details;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get total Population details");
            return details;
        }

    }


    /**
     * Name: getOnlyRegionPopulation
     * description: To return the population of a region
     * and intellij / the program.
     * @return
     */
    public String getOnlyRegionPopulation()
    {
        String details = "Carribean, ";
        BigDecimal tp = new BigDecimal(0);

        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(country.Population) FROM country WHERE Region = 'Caribbean'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries


            while (rset.next())
            {
                //population of the wolrd
                tp = rset.getBigDecimal("SUM(country.Population)");
            }


            details = details + tp;

            return details;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get total Population details");
            return details;
        }

    }


    /**
     * Name: getOnlyCountryPopulation
     * description: To return the population of the world
     * and intellij / the program.
     * @return
     */
    public String getOnlyCountryPopulation()
    {
        String details = "India, ";
        BigDecimal tp = new BigDecimal(0);

        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(country.Population) FROM country WHERE Name = 'India'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries


            while (rset.next())
            {
                //population of the wolrd
                tp = rset.getBigDecimal("SUM(country.Population)");
            }


            details = details + tp;

            return details;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get total Population details");
            return details;
        }

    }

    /**
     * Name: getOnlyWorldPopulation
     * description: To return the population of the world
     * and intellij / the program.
     * @return
     */
    public String getOnlyDistrictPopulation()
    {
        String details = "New York, ";
        BigDecimal tp = new BigDecimal(0);

        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(city.Population) FROM city WHERE District = 'New York'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries


            while (rset.next())
            {
                //population of the wolrd
                tp = rset.getBigDecimal("SUM(city.Population)");
            }


            details = details + tp;

            return details;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get total Population details");
            return details;
        }

    }



    public void displayPopulation(String details, String info)
    {
        if (info != null) {
            System.out.println(info);

            if (details.contains("%")) {
                System.out.println("Area, Total Population, % living in cities, % not living in cities");
            }
            System.out.println(details + " \n");
        }

    }


    /**
     * Name: getLanguageReport
     * description: To return the report on languages
     * and intellij / the program.
     * @return String of the report on languages
     */
    public String getLanguageReport()
    {
        String details = "";
        String language = "";
        BigDecimal tp = new BigDecimal(0);

        BigDecimal languageSpeakers = new BigDecimal(0);
        BigDecimal languagePercentage = new BigDecimal(0);

        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(country.Population) FROM country";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries


            while (rset.next())
            {
                //population of the wolrd
                tp = rset.getBigDecimal("SUM(country.Population)");
            }


            details = "World Population: " + tp + "\n";


        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get total Population details");
            return details;
        }
        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Language, SUM(Population*Percentage/100) FROM country JOIN countrylanguage ON (country.Code = countrylanguage.CountryCode) WHERE Language IN ('Chinese','Hindi','English','Spanish','Arabic')\n" +
                            "GROUP BY Language ORDER BY SUM(Population*Percentage/100) DESC;";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries



            while (rset.next())
            {

                languageSpeakers = rset.getBigDecimal("SUM(Population*Percentage/100)");
                languagePercentage = rset.getBigDecimal("SUM(Population*Percentage/100)");
                language = rset.getString("Language");


                languagePercentage = languageSpeakers.divide(tp, RoundingMode.HALF_UP);
                languagePercentage = languagePercentage.multiply(new BigDecimal(100));

                details = details + "language: "+ language  + ", " + languageSpeakers + ", Percentage of World Population: " + languagePercentage + "%\n";

            }





            return details;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city Population details");
            return details;
        }

    }




    public void displayLanguage(String details, String info) {
        System.out.println(info);
        System.out.println(details);
    }


}