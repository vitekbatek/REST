package ml.vitekbatek.rest.JDBC;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.*;

public class Transactions {
    private Connection conn = null;
    private PreparedStatement stmt = null;


     public CachedRowSetImpl  getNotSendEmailRecords(){
         try {
             Class.forName("org.postgresql.Driver");
             conn = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/smartservices",
                            "postgres", "postgres");
             //conn.setAutoCommit(false);
             stmt = conn.prepareStatement("SELECT transactions.id, transactions.emailstate, transactions.reqstate, clients.name, clients.email, limservices.description\n" +
                                        "FROM transactions \n" +
                                        "INNER JOIN clients  \n" +
                                        "ON transactions.idclient = clients.id  \n" +
                                        "INNER JOIN limservices \n" +
                                        "ON transactions.idlimservice = limservices.id \n" +
                                        "WHERE emailstate = false\n" +
                                        "ORDER BY id ASC");
             ResultSet rs = stmt.executeQuery();
             CachedRowSetImpl  crs = new CachedRowSetImpl();
             crs.populate(rs);
             rs.close();
             stmt.close();
             conn.close();
             return crs;
         } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
            return null;
         }
    }
    public void setSendEmailRecords(int id){
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/smartservices",
                            "postgres", "postgres");
            //conn.setAutoCommit(false);

            stmt = conn.prepareStatement("UPDATE transactions " +
                    "SET id=id, idclient=idclient, idlimservice=idlimservice, reqdate=reqdate, reqstate=reqstate, emailstate=True\n" +
                    "WHERE id = " + id);
            // Update table
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}


