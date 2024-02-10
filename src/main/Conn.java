package main;

import java.sql.*;

// Connection class to connect to the database
public class Conn {
    
    Connection c;
    Statement s;

    public Conn () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Connect to MySQL database
            // creds.password is the password for the root (default) database
            c = DriverManager.getConnection("jdbc:mysql:///employeemanagmentsystem", "root", creds.password);
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
