package org.example;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws SQLException {
        String urlConnection = "jdbc:derby:baeldung;create=true";
        Connection con = DriverManager.getConnection(urlConnection);

        System.out.println("Current tables:");
        Set<String> dbTables = getDBTables(con);
        dbTables.forEach(System.out::println);
        System.out.println("========================");

        if (!isTableExist("authors", con)) {
            Statement statement = con.createStatement();
            String sql = "CREATE TABLE authors (id INT PRIMARY KEY,first_name VARCHAR(255),last_name VARCHAR(255))";
            statement.execute(sql);
            sql = "INSERT INTO authors VALUES (1, 'arash','ariani')";
            statement.execute(sql);
        }
        System.out.println("Hello World!");
    }


    public static boolean isTableExist(String sTablename, Connection connection) throws SQLException {
        if (connection != null) {
            DatabaseMetaData dbmd = connection.getMetaData();
            ResultSet rs = dbmd.getTables(null, null, sTablename.toUpperCase(), null);
            if (rs.next()) {
                System.out.println("Table " + rs.getString("TABLE_NAME") + " already exists !!");
            } else {
                System.out.println("Write your create table function here !!!");
            }
            return true;
        }
        return false;
    }

    private static Set<String> getDBTables(Connection targetDBConn) throws SQLException {
        Set<String> set = new HashSet<String>();
        DatabaseMetaData dbmeta = targetDBConn.getMetaData();
        readDBTable(set, dbmeta, "TABLE", null);
        readDBTable(set, dbmeta, "VIEW", null);
        return set;
    }

    private static void readDBTable(Set<String> set, DatabaseMetaData dbmeta, String searchCriteria, String schema)
            throws SQLException {
        ResultSet rs = dbmeta.getTables(null, schema, null, new String[]
                {searchCriteria});
        while (rs.next()) {
            set.add(rs.getString("TABLE_NAME").toLowerCase());
        }
    }
}
