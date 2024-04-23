package MagazijnRobot;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order {
    public int orderID;
    public int customerID;
    public Date date;
    public boolean complete;
    public ArrayList<Orderline> orderlines;

    public Order(int orderID, int customerID, Date date, boolean complete) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.date = date;
        this.complete = complete;
        this.orderlines = Main.db.getOrderline(orderID);
    }
}