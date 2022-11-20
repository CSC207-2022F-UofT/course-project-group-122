package user_interface_layer.screens.showParticipantInfo;

import user_interface_layer.SetScreenToCenter;
import user_interface_layer.screens.ControllerManager;

import javax.swing.*;
import java.awt.*;

public class ShowParticipantInfoScreen extends JFrame {

    public ShowParticipantInfoScreen(ShowParticipantInputData data, ControllerManager controllerManager) {
    setTitle("Enroll Participant");
    setLayout(new BorderLayout());
    JLabel participantTag = new JLabel(data.getUserName() + " (" + data.getParticipantId()+") ");
    JButton enroll = new JButton("Add");
    enroll.addActionListener(e->{
        controllerManager.addPotentialParticipantToStudyRequest(data.getParticipantId(), data.getStudyId());
    });
    add(participantTag, BorderLayout.CENTER);
    add(enroll, BorderLayout.SOUTH);
    pack();
    SetScreenToCenter setScreenToCenter = new SetScreenToCenter(this);
    }


}
