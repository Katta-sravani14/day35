package com.bridgelabz.DBDemo;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
//import java.sql.Statement;
import java.util.Enumeration;

public class DBDemo
{
    public static void main(String [] args)
    {
        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
        String userName = "root";
        String passWord = "Sravani@123";
        Connection connection;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Driver loaded ");
        }
        catch (ClassNotFoundException e)
        {
            throw  new IllegalStateException("Cannot find the driver");
        }
        listDrivers();
        try
        {
            System.out.println("Connecting to database:"+jdbcURL);
            connection = DriverManager.getConnection(jdbcURL,userName,passWord);

            System.out.println("Connection is Successful !!!! :"+connection);


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void listDrivers()
    {
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while(driverList.hasMoreElements())
        {
            Driver driverClass = (Driver) driverList.nextElement();
            System.out.println(" "+driverClass.getClass().getName());
        }
    }


}