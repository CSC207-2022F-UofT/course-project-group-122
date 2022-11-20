package user_interface_layer.screens.showResearcherInfo;

import user_interface_layer.SetScreenToCenter;
import user_interface_layer.screens.ControllerManager;

import javax.swing.*;
import java.awt.*;

public class ShowResearcherInfoScreen extends JFrame {

    public ShowResearcherInfoScreen(ShowResearcherInputData data, ControllerManager controllerManager) {
    setTitle("Enroll Participant");
    setLayout(new BorderLayout());
    JLabel participantTag = new JLabel(data.getUserName() + " (" + data.getResearcherId()+") ");
    JButton enroll = new JButton("Add");
    enroll.addActionListener(e->{
        controllerManager.addResearcherToStudyRequest(data.getResearcherId(), data.getStudyId());
    });
    add(participantTag, BorderLayout.CENTER);
    add(enroll, BorderLayout.SOUTH);
    pack();
    SetScreenToCenter setScreenToCenter = new SetScreenToCenter(this);
    }


}
