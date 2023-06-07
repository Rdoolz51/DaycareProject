package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//This Class is where we manage and establish our database connection
public class ConnectionUtil {


    public static Connection getConnection() throws SQLException {


        try {
            Class.forName("org.postgresql.Driver"); //searching for the postgres driver, which we have as a dependency
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("problem occurred locating driver");
        }

        String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=project0";
        String username = "postgres";
        String password = "password"; //This is the password you made when you installed postgreSQL

        return DriverManager.getConnection(url, username, password);

    }

}