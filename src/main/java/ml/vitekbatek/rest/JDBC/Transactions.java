package ml.vitekbatek.rest.JDBC;

import java.sql.*;

public class Transactions {

     public ResultSet getRecords(String query){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/smartservices",
                            "postgres", "postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();

            // Request From table
            ResultSet rs = stmt.executeQuery(query);
            return rs;
            //rs.close();
            //stmt.close();
            //c.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
            return null;
        }
    }
    public ResultSet setRecords(String query){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/smartservices",
                            "postgres", "postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();

            // Request From table
            ResultSet rs = stmt.executeQuery(query);
            return rs;
            //rs.close();
            //stmt.close();
            //c.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
            return null;
        }
    }
}


