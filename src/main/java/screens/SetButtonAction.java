package screens;

import javax.swing.*;
import java.awt.event.ActionListener;

public class SetButtonAction{

    public SetButtonAction(JPanel panel, JButton button, String actionCommand, ActionListener actionListener){
        button.setActionCommand(actionCommand);
        button.addActionListener(actionListener);
        panel.add(button);
    }
    public SetButtonAction (JButton button, String actionCommand, ActionListener actionListener){
        button.setActionCommand(actionCommand);
        button.addActionListener(actionListener);
    }
//    public SetButtonAction(JFrame screen, JPanel panel, JButton button, String actionCommand, ActionListener actionListener){
//        button.setActionCommand(actionCommand);
//        button.addActionListener(actionListener);
//        panel.add(button);
//        screen.add(panel);
//    }


}
