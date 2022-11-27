package user_interface_layer.screens.consent_form;

import org.jetbrains.annotations.NotNull;
import use_cases.fetch_consent_form.FetchConsentFormResponseModel;
import user_interface_layer.screen_setters.SetScreenToCenter;
import user_interface_layer.screens.ControllerManager;

import javax.swing.*;
import java.awt.*;

public class ConsentFormScreenForReview extends JFrame {
    public ConsentFormScreenForReview(@NotNull FetchConsentFormResponseModel responseModel, ControllerManager controllerManager) {
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel headerLabel = new JLabel("Consent Form for Study: " + responseModel.getStudyName() + " (" +
                responseModel.getStudyId() + ")", SwingConstants.LEFT);

        JScrollPane scrollPane = new JScrollPane();
        JLabel studyDescription = new JLabel("Study Description: ", SwingConstants.LEFT);
        JTextArea studyDescriptionText = new JTextArea(5, 20);
        studyDescriptionText.setText(responseModel.getStudyDescription());
        studyDescriptionText.setEditable(false);
        studyDescriptionText.setLineWrap(true);
        scrollPane.setViewportView(studyDescriptionText);

        JLabel risksAndBenefits = new JLabel("Risks and Benefits: ", SwingConstants.LEFT);
        JTextArea risksAndBenefitsText = new JTextArea(5, 20);
        risksAndBenefitsText.setText(responseModel.getRisksAndBenefits());
        risksAndBenefitsText.setEditable(false);
        risksAndBenefitsText.setLineWrap(true);
        scrollPane.setViewportView(risksAndBenefitsText);

        JLabel participantRights = new JLabel("Participant Rights: ", SwingConstants.LEFT);
        JTextArea participantRightsText = new JTextArea(5, 20);
        participantRightsText.setText(responseModel.getParticipantRights());
        participantRightsText.setEditable(false);
        participantRightsText.setLineWrap(true);
        scrollPane.setViewportView(participantRightsText);

        panel.add(headerLabel);
        panel.add(studyDescription);
        panel.add(studyDescriptionText);
        panel.add(risksAndBenefits);
        panel.add(risksAndBenefitsText);
        panel.add(participantRights);
        panel.add(participantRightsText);

        add(panel, BorderLayout.NORTH);

        pack();
        SetScreenToCenter setScreenToCenter = new SetScreenToCenter(this);
    }
}
