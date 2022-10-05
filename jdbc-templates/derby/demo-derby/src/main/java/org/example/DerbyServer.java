package org.example;

import java.sql.*;

public class DerbyServer {
    public static void main(String[] args) {
        //runed as Apache Derby in Client/Server Mode
        String urlConnection = "jdbc:derby://localhost:1527/logger-db";
        try (Connection con = DriverManager.getConnection(urlConnection)) {
            Statement statement = con.createStatement();
            String sql = "SELECT * FROM authors";
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                // We can print or use ResultSet here
                int a =0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
