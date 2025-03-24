package Project;

import java.sql.*;

public class Conn {
    public Connection conn;
    public Statement statement;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to the database
            String url = "jdbc:mysql://localhost:3306/ebsystem"; // Replace with your DB details
            String username = "root"; // Replace with your DB username
            String password = "Mangate@2252004"; // Replace with your DB password

            conn = DriverManager.getConnection(url, username, password);

            // Create a Statement object to execute queries
            if (conn != null) {
                statement = conn.createStatement();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
