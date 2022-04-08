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


        /**Name: getLanguageReport
         *description: return number of people who speak the following the following languages ('Chinese','Hindi','English','Spanish','Arabic') from greatest number to smallest, including the percentage of the world population
         *@param con - A variable of type 'Connection' called con which uses the connection between the database and intellij / the program.
         * @return a string on the report    */
        String details = a.getLanguageReport();
        a.displayCities(details, "return number of people who speak the following the following languages ('Chinese','Hindi','English','Spanish','Arabic') from greatest number to smallest, including the percentage of the world population:");







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








    public void displayCities(String details, String info) {
        System.out.println(info);
        System.out.println(details);
    }
}

