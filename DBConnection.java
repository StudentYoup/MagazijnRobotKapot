package MagazijnRobot;


import java.sql.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class DBConnection {
    // JDBC URL, username, and password of MySQL server
    private static final String URL = "jdbc:mysql://localhost:3306/nerdygadgets";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // JDBC variables for opening and managing connection
    private static Connection connection;

    public DBConnection() {
        try {
            // Opening database connection to MySQL server
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the MySQL server.");

            // Do whatever database operations you need here

        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        }
    }
    public ArrayList<Order> getOrders(){
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from orders");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            return new ArrayList<>();
        }
        catch(Exception ex){
            return new ArrayList<>();
        }
    }
}