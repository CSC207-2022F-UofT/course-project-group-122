package user_interface_layer.screens.show_participant_info;

import user_interface_layer.screen_setters.SetScreenToCenter;
import user_interface_layer.screens.ControllerManager;

import javax.swing.*;
import java.awt.*;

public class ShowParticipantInfoForQAssignment extends JFrame {

    public ShowParticipantInfoForQAssignment(int participantId, String name, int studyId, int questionnaireId,
                                             ControllerManager controllerManager) {
        setTitle("Please confirm this is the correct participant");
        setLayout(new BorderLayout());
        JLabel participantTag = new JLabel(name + " (" + participantId+") ");
        JButton assign = new JButton("Confirm");
        assign.addActionListener(e->{
            controllerManager.assignQuestionnaireToIndividual(questionnaireId, studyId, participantId);
        });
        add(participantTag, BorderLayout.CENTER);
        add(assign, BorderLayout.SOUTH);
        pack();
        SetScreenToCenter setScreenToCenter = new SetScreenToCenter(this);
    }

}

