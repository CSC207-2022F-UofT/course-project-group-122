package screens;

import view.ViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetSimpleUserScreenHeader extends JPanel {


    public SetSimpleUserScreenHeader(int UserID, ViewModel viewModel) {

        setBackground(new Color(204, 204, 204));
        //studyLogHeader.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        JLabel userIDLabel = new JLabel("ID: " + UserID);
        add(userIDLabel);

        JButton logOutButton = new JButton("Log Out");

        logOutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                viewModel.getUserHomeScreen().setVisible(false);
                viewModel.getRegisterScreen().setVisible(true);
            }
        });
        add(logOutButton);
    }
}

