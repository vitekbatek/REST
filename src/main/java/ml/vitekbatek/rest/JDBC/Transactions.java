package ml.vitekbatek.rest.JDBC;

import java.sql.*;

public class Transactions {

     public ResultSet getNotSendEmailRecords(){

        try {
            Connection conn = null;
            PreparedStatement stmt = null;
            Class.forName("org.postgresql.Driver");
            conn = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/smartservices",
                            "postgres", "postgres");
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement("SELECT transactions.id, transactions.emailstate, transactions.reqstate, clients.name, clients.email, limservices.description\n" +
                                        "FROM transactions \n" +
                                        "INNER JOIN clients  \n" +
                                        "ON transactions.idclient = clients.id  \n" +
                                        "INNER JOIN limservices \n" +
                                        "ON transactions.idlimservice = limservices.id \n" +
                                        "WHERE emailstate = false\n" +
                                        "ORDER BY id ASC");
            ResultSet rs = stmt.executeQuery();
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
    public void setSendEmailRecords(int id){
        try {
            Connection conn = null;
            PreparedStatement stmt = null;
            Class.forName("org.postgresql.Driver");
            conn = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/smartservices",
                            "postgres", "postgres");
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("UPDATE public.transactions\n" +
                    "SET id=id, idclient=idclient, idlimservice=idlimservice, reqdate=reqdate, reqstate=reqstate, emailstate=True\n" +
                    "WHERE id = " + id);
            // Request From table
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}


