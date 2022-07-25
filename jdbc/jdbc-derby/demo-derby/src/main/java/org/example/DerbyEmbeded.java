package org.example;

import java.sql.*;

public class DerbyEmbeded {
    public static void main(String[] args) {
        //runed as a  EmbeddedCP
        String urlConnection = "jdbc:derby:baeldung";
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
