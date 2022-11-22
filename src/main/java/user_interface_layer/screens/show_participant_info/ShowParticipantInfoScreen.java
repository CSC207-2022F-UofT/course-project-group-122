package user_interface_layer.screens.show_participant_info;

import user_interface_layer.screen_setters.SetScreenToCenter;
import user_interface_layer.screens.ControllerManager;

import javax.swing.*;
import java.awt.*;

public class ShowParticipantInfoScreen extends JFrame {

    public ShowParticipantInfoScreen(int participantId, String name, int studyId, ControllerManager controllerManager) {
    setTitle("Enroll Participant");
    setLayout(new BorderLayout());
    JLabel participantTag = new JLabel(name + " (" + participantId+") ");
    JButton enroll = new JButton("Add");
    enroll.addActionListener(e->{
        controllerManager.addPotentialParticipantToStudyRequest(participantId, studyId);
    });
    add(participantTag, BorderLayout.CENTER);
    add(enroll, BorderLayout.SOUTH);
    pack();
    SetScreenToCenter setScreenToCenter = new SetScreenToCenter(this);
    }


}
