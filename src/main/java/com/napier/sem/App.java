package com.napier.sem;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;



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


        /**Name: getWolrdPopulation / Query 1
         *description: To return the report on the population the world
         *@param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return a string on the report    */
        String details = a.getWorldPopulation();
        a.displayCities(details, "Query 1: return the report on the population of the world");


        /**Name: getContinentPopulation / Query 2
         *description: To return the report on the population a continent
         *@param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return a string on the report    */
         details = a.getContinentPopulation();
        a.displayCities(details, "Query 2: return the report on the population of a continent");



        /**Name: getRegionPopulation / Query 3
         *description: To return the report on the population a Region
         *@param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return a string on the report    */
        details = a.getRegionPopulation();
        a.displayCities(details, "Query 3: return the report on the population of a region");


        /**Name: getCountryPopulation / Query 4
         *description: To return the report on the population a country
         *@param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return a string on the report    */
        details = a.getCountryPopulation();
        a.displayCities(details, "Query 4: return the report on the population of a country");

        /**Name: getDistrictPopulation / Query 5
         *description: To return the report on the population a district
         *@param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return a string on the report    */
        details = a.getDistrictPopulation();
        a.displayCities(details, "Query 5: return the report on the population of a district");



        /**Name: getOnlyWorldPopulation/ Query 6
         *description: To return the world population
         *@param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return a string on population   */
        details =  a.getOnlyWorldPopulation();
        a.displayCities(details, "Query 6: return the population of the world");


        /**Name: getOnlyContinentPopulation/ Query 7
         *description: To return a continents population
         *@param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return a string on population   */
        details =  a.getOnlyContinentPopulation();
        a.displayCities(details, "Query 7: return the population of a continent");

        /**Name: getOnlyRegionPopulation/ Query 8
         *description: To return a region population
         *@param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return a string on population   */
        details =  a.getOnlyRegionPopulation();
        a.displayCities(details, "Query 8: return the population of a region");


        /**Name: getOnlyCountryPopulation/ Query 9
         *description: To return a country population
         *@param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return a string on population   */
        details =  a.getOnlyCountryPopulation();
        a.displayCities(details, "Query 9: return the population of a country");



/**Name: getOnlyDistrictPopulation/ Query 10
 *description: To return a distrcits population
 *@param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
 * @return a string on population   */
        details =  a.getOnlyDistrictPopulation();
        a.displayCities(details, "Query 10: return the population of a district");

/**Name: getOnlyCityPopulation/ Query 34
 *description: To return a city population
 *@param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
 * @return a string on population   */
        details =  a.getOnlyCityPopulation();
        a.displayCities(details, "Query 34: return the population of a city");
        
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

 /**
     * Name: getOnlyCityPopulation
     * description: To return the population of the world
     * and intellij / the program.
     * @return
     */
    public String getOnlyCityPopulation()
    {
        String details = "Amsterdam, ";
        BigDecimal tp = new BigDecimal(0);

        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(city.Population) FROM city WHERE Name = 'Amsterdam'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return countries


            while (rset.next())
            {
                //population of the city
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

    public void displayCities(String details, String info)
    {
        System.out.println(info);
        if (details.contains("%")) {
            System.out.println("Area, Total Population, % living in cities, % not living in cities");
        }
        System.out.println(details + " \n");

      /*  BigDecimal tp = new BigDecimal("6078749450");
        BigDecimal cp = new BigDecimal("1429559884");


        BigDecimal answer = cp;
        System.out.println(answer);

        answer = answer.multiply(new BigDecimal(100));
        System.out.println(answer);

        answer = answer.divide(tp, 2, RoundingMode.HALF_UP);
        System.out.println(answer);
*/



    }

}

