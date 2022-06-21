package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * include jdbc jar file
 *
 * File -> Project structure -> Project settings -> libraries -> put "plus sign" choose ojdbc8.jar -> ok
 */
public class App 
{
    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
        String user ="system";
        String password = "oracle";

        try {
            System.out.println("Connecting to DAtabase");
            Class.forName("oracle.jdbc.driver.OracleDriver");  /*added this line*/
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println( connection.toString());
            System.out.println("Connection Success");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
