package MagazijnRobot;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class Orders_Panel extends JPanel {
    ArrayList<Order> orders;
    public Orders_Panel(){
        setBackground(Color.LIGHT_GRAY);
        orders = Main.db.getOrders();
        setLayout(new GridLayout(1, orders.size()));
        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
        setBorder(border);
        for(Order order : orders){
            JPanel j = new JPanel();
            j.setSize(new Dimension(400, 600));
            j.setBackground(Color.lightGray);
            j.setBorder(border);
            j.setLayout(new GridLayout(3, 1));
            j.add(new JLabel("#ID: " + order.orderID));
            j.add(new JLabel("Orderlines: " + order.orderlines.size()));
            JPanel List = new JPanel();
            List.setLayout(new GridLayout(5, 1));
            j.add(List);
            add(j);
            for(Orderline orderline : order.orderlines){
                JLabel JL = new JLabel("#" + orderline.orderlineID + " " + orderline.description + " " + orderline.quantity);
                JL.setSize(new Dimension(400, 50));
                List.add(JL);
            }
        }

        setVisible(true);
    }
}
