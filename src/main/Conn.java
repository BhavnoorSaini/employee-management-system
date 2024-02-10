package main;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;

    public Conn () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///employeemanagmentsystem", "root", creds.password);
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
