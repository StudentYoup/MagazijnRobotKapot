package MagazijnRobot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HMI_GUI extends JFrame implements ActionListener {
    JButton Orders = new JButton("Orders");
    HMI_Orders HMIORDERS = new HMI_Orders(this);
    public HMI_GUI(){
        setTitle("HMI - MagazijnRobot");
        setExtendedState(MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(null);

        HMI_Panel HMIPanel = new HMI_Panel();
        HMIPanel.setBounds(30, 30, 900, 500);
        add(HMIPanel, BorderLayout.CENTER);

        JLabel HMI_Title = new JLabel("HMI - MagazijnRobot:");
        HMI_Title.setFont(new Font(HMI_Title.getFont().getName(), Font.BOLD, 30));
        HMI_Title.setBounds(1100, 30, 400, 50);
        add(HMI_Title);

        Orders.setBounds(730, 560, 200, 50);
        Orders.setBackground(Color.WHITE);
        Orders.addActionListener(this);
        add(Orders);

        getContentPane().setBackground(Color.GRAY);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Orders){
            HMIORDERS.setVisible(true);
            setVisible(false);
        }
    }
}
