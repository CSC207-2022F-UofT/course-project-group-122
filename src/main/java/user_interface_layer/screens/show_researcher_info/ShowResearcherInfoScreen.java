package user_interface_layer.screens.show_researcher_info;

import user_interface_layer.screen_setters.SetScreenToCenter;
import user_interface_layer.screens.ControllerManager;

import javax.swing.*;
import java.awt.*;

public class ShowResearcherInfoScreen extends JFrame {

    public ShowResearcherInfoScreen(int researcherId, String researcherName, int studyId,
                                    ControllerManager controllerManager) {
    setTitle("Enroll Participant");
    setLayout(new BorderLayout());
    JLabel participantTag = new JLabel(researcherName+ " (" + researcherId +") ");
    JButton enroll = new JButton("Add");
    enroll.addActionListener(e->{
        controllerManager.addResearcherToStudyRequest(researcherId, studyId);
    });
    add(participantTag, BorderLayout.CENTER);
    add(enroll, BorderLayout.SOUTH);
    pack();
    SetScreenToCenter setScreenToCenter = new SetScreenToCenter(this);
    }


}
