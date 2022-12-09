package user_interface_layer.screens.show_participant_info;

import user_interface_layer.screen_helper_classes.SetScreenToCenter;
import user_interface_layer.screens.ControllerManager;

import javax.swing.*;
import java.awt.*;

/**
 * It is the screen that shows the information of a participant.
 */
public class ShowParticipantInfoForQAssignment extends JFrame {

    /**
     * The constructor for the ShowParticipantInfoForQAssignmentScreen.
     * @param participantId The ID of the participant.
     * @param name         The name of the participant.
     * @param studyId     The ID of the study.
     * @param questionnaireId The ID of the questionnaire.
     * @param controllerManager The controller manager.
     */
    public ShowParticipantInfoForQAssignment(int participantId, String name, int studyId, int questionnaireId,
                                             ControllerManager controllerManager) {
        setTitle("Please confirm this is the correct participant");
        setLayout(new BorderLayout());
        JLabel participantTag = new JLabel(name + " (" + participantId+") ");
        JButton assign = new JButton("Confirm");
        assign.addActionListener(e-> controllerManager.assignQuestionnaireToIndividual(
                questionnaireId, studyId, participantId));
        add(participantTag, BorderLayout.CENTER);
        add(assign, BorderLayout.SOUTH);
        pack();
        SetScreenToCenter.setCenter(this);
    }

}

