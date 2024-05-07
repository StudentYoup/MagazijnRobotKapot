package MagazijnRobot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HMI_Orders extends JFrame implements ActionListener {

    HMI_GUI HMIGUI;
    JButton Terug = new JButton("Terug");

    public HMI_Orders(HMI_GUI HMIGUI){
        this.HMIGUI = HMIGUI;
        setTitle("HMI - Orders");
        setExtendedState(MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(null);
        Terug.setBounds(30, 30, 200, 50);
        Terug.setBackground(Color.WHITE);
        Terug.addActionListener(this);
        add(Terug);

        getContentPane().setBackground(Color.GRAY);

        Orders_Panel ordersPanel = new Orders_Panel();
        ordersPanel.setBounds(30, 110, 1476, 600);
        add(ordersPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Terug){
            HMIGUI.setVisible(true);
            setVisible(false);
        }
    }
}
