package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connect {

    private static String userName = "root";
    private static String password = "";
    private static String dbName = "veterinary_management_system";
    private static String host = "localhost";
    private static int port = 3308;
    private static String dbUrl = "jdbc:mysql://" + host + ":" + port + "/" + dbName;


    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(dbUrl, userName, password);
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("ConnectionUtil : "+ex.getMessage());
            return null;
        }
    }

}

