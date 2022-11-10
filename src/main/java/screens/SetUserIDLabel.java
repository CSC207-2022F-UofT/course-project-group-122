package screens;

import actionListeners.LogOut;
import view.View;

import javax.swing.*;
import java.awt.*;

public class SetUserIDLabel {
    private int userID;
    private View view;

    public SetUserIDLabel(JFrame screen , int UserID, View view) {
        JPanel holdLabelPanel = new JPanel();
        //holdLabelPanel.setBackground(Color.GRAY);
        JLabel userIDLabel = new JLabel("ID: " + UserID);
        //userIDLabel.setBackground(Color.DARK_GRAY);
        holdLabelPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        holdLabelPanel.add(userIDLabel);
        screen.add(holdLabelPanel, BorderLayout.NORTH);

        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem logOut = new JMenuItem("Log Out");
        logOut.addActionListener(new LogOut(view));
        popupMenu.add(logOut);

        userIDLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                popupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        });
    }



    public static void main(String[] args) {
        JFrame test = new JFrame();
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SetScreenToCenter center = new SetScreenToCenter(test);
        View view = new View();
        SetUserIDLabel test2 = new SetUserIDLabel(test, 1, view);
        test.setVisible(true);
    }
}
