package MagazijnRobot;


import java.sql.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class DBConnection {
    // JDBC URL, username, and password of MySQL server
    private static final String URL = "jdbc:mysql://localhost:3306/MagazijnRobot";
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
            ArrayList<Order> orders = new ArrayList<>();
            while(rs.next()){
                // Uncomment this line to add orders to the ArrayList
                orders.add(new Order(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getBoolean(4)));
            }
            return orders;
        }
        catch(Exception ex){
            System.out.println("ERROR!!!");
            ex.printStackTrace(); // Print stack trace for debugging
            return new ArrayList<>();
        }
    }
    public ArrayList<Orderline> getOrderline(int orderID) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM orderlines WHERE orderID = " + orderID);
            ArrayList<Orderline> orderlines = new ArrayList<>();
            while (rs.next()) {
                int orderlineID = rs.getInt("orderlineID");
                int stockItemID = rs.getInt("stockItemID");
                String description = rs.getString("description");
                int quantity = rs.getInt("quantity");
                int pickedQuantity = rs.getInt("pickedQuantity");
                boolean complete = rs.getBoolean("complete");
                orderlines.add(new Orderline(orderlineID, orderID, stockItemID, description, quantity, pickedQuantity, complete));
            }
            return orderlines;
        } catch (Exception ex) {
            System.out.println("ERROR!!!");
            ex.printStackTrace(); // Print stack trace for debugging
            return new ArrayList<>();
        }
    }
    public Product getProduct(int stockItemID) {
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT si.stockItemID, si.stockItemName, sh.quantityOnHand, sh.binLocation " +
                    "FROM stockitems si " +
                    "INNER JOIN stockitemholdings sh ON si.stockItemID = sh.stockItemID " +
                    "WHERE si.stockItemID = " + stockItemID;
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                String productName = rs.getString("stockItemName");
                int quantityOnHand = rs.getInt("quantityOnHand");
                String binLocation = rs.getString("binLocation");

                String[] binParts = binLocation.split("-");
                int x = Integer.parseInt(binParts[0]);
                int y = Integer.parseInt(binParts[1]);
                return new Product(stockItemID, productName, quantityOnHand, x, y);
            } else {
                // If no matching record found, return null or handle appropriately
                return null;
            }
        } catch (Exception ex) {
            System.out.println("ERROR!!!");
            ex.printStackTrace(); // Print stack trace for debugging
            return new Product();
        }
    }
}