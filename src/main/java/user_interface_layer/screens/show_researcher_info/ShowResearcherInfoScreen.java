package user_interface_layer.screens.show_researcher_info;

import user_interface_layer.screen_helper_classes.SetScreenToCenter;
import user_interface_layer.screens.ControllerManager;

import javax.swing.*;
import java.awt.*;

/**
 * It is the screen that shows the information of a researcher.
 */
public class ShowResearcherInfoScreen extends JFrame {

    /**
     * Displays the screen with the information of the researcher.
     * @param researcherId The ID of the researcher.
     * @param researcherName The name of the researcher.
     * @param studyId The ID of the study.
     * @param controllerManager The controller manager.
     */
    public ShowResearcherInfoScreen(int researcherId, String researcherName, int studyId,
                                    ControllerManager controllerManager) {
    setTitle("Enroll Participant");
    setLayout(new BorderLayout());
    JLabel participantTag = new JLabel(researcherName+ " (" + researcherId +") ");
    JButton enroll = new JButton("Add");
    enroll.addActionListener(e-> controllerManager.addResearcherToStudyRequest(researcherId, studyId));
    add(participantTag, BorderLayout.CENTER);
    add(enroll, BorderLayout.SOUTH);
    pack();
        SetScreenToCenter.setCenter(this);
    }

}
