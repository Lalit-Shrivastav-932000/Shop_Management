package com;

//This file is made by Lalit


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Postgre {

    Connection conn = null;

    public Connection connectDB() {
        //this method will connect program to "demo" database as user "postgres"

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost/jewellery", "postgres", "password");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return (conn);
    }

    public String closeConn(Connection c, PreparedStatement ps, ResultSet rs) {

        String s1 = "";
        String s2 = "";
        String s3 = "";

        try {

            if (c != null && (!c.isClosed())) {
                c.close();
                s1 = "connection closed";
            } else {
                s1 = "connection already closed";
            }

            if (ps != null && (!ps.isClosed())) {
                ps.close();
                s2 = "statement closed";
            } else {
                s2 = "statement already closed";
            }

            if (rs != null && (!rs.isClosed())) {
                rs.close();
                s3 = "ResultSet closed";
            } else {
                s3 = "ResultSet already closed";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return(s3 + "    " + s2 + "     " + s1);

    }
    
}
