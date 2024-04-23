package MagazijnRobot;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class HMI_Panel extends JPanel {
    public HMI_Panel(){
        setPreferredSize(new Dimension(900, 500));
        setBackground(Color.LIGHT_GRAY);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
        setBorder(border);
        setVisible(true);
    }
}
