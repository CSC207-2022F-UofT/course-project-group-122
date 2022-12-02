package user_interface_layer.screens.show_participant_info;

import user_interface_layer.screen_helper_classes.SetScreenToCenter;
import user_interface_layer.screens.ControllerManager;

import javax.swing.*;
import java.awt.*;

/**
 * It is the screen that shows the information of a participant.
 */
public class ShowParticipantInfoScreen extends JFrame {

    /**
     * @param participantId The ID of the participant.
     * @param name        The name of the participant.
     * @param studyId   The ID of the study.
     * @param controllerManager The controller manager.
     */
    public ShowParticipantInfoScreen(int participantId, String name, int studyId, ControllerManager controllerManager) {
    setTitle("Participant Information");
    setLayout(new BorderLayout());
    JLabel participantTag = new JLabel(name + " (" + participantId+") ");
    JButton enroll = new JButton("Add");
    enroll.addActionListener(e-> controllerManager.addPotentialParticipantToStudyRequest(
            participantId, studyId));
    add(participantTag, BorderLayout.CENTER);
    add(enroll, BorderLayout.SOUTH);
    pack();
        SetScreenToCenter.setCenter(this);
    }


}
