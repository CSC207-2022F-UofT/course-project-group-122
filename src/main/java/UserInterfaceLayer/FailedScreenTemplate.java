package UserInterfaceLayer;

import javax.swing.*;
import java.awt.*;


/**
 * This class is the template for all failed screens. It extends ScreenBaseTemplate. It has a button that
 */
public class FailedScreenTemplate extends JFrame{
    public JLabel failedLabel;

    public JPanel failedPanel = new JPanel(new GridLayout(1,1));
    public FailedScreenTemplate(String message){
//        SetScreenToCenter toCenter = new SetScreenToCenter(this, new GridLayout(1,1), 200, 100);
//        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//
//        failedLabel = new JLabel(message, SwingConstants.CENTER);
//        failedPanel.add(failedLabel);
//
//        this.add(failedPanel);
//        this.setVisible(true);
        JOptionPane.showMessageDialog(null, message);
    }

    public static void main(String[] args) {
        FailedScreenTemplate test = new FailedScreenTemplate("You are a mistake");
    }


}
