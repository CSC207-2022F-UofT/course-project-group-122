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
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
        JLabel headerLabel = new JLabel("Consent Form for Study: " + responseModel.getStudyName() + " (" +
                responseModel.getStudyId() + ")", SwingConstants.LEFT);
        headerLabel.setFont(new Font("Serif", Font.BOLD, 20));
        titlePanel.add(headerLabel);

        JScrollPane scrollPane = new JScrollPane();
        JPanel contentPanel1 = new JPanel();
        contentPanel1.setLayout(new BoxLayout(contentPanel1, BoxLayout.X_AXIS));
        JLabel studyDescription = new JLabel("Study Description: ", SwingConstants.LEFT);
        studyDescription.setFont(new Font("Serif", Font.BOLD, 16));
        contentPanel1.add(studyDescription);
        JTextArea studyDescriptionText = new JTextArea(5, 20);
        studyDescriptionText.setText(responseModel.getStudyDescription());
        studyDescriptionText.setEditable(false);
        studyDescriptionText.setLineWrap(true);
        scrollPane.setViewportView(studyDescriptionText);

        JPanel contentPanel2 = new JPanel();
        contentPanel2.setLayout(new BoxLayout(contentPanel2, BoxLayout.X_AXIS));
        JLabel risksAndBenefits = new JLabel("Risks and Benefits: ", SwingConstants.LEFT);
        risksAndBenefits.setFont(new Font("Serif", Font.BOLD, 16));
        contentPanel2.add(risksAndBenefits);
        JTextArea risksAndBenefitsText = new JTextArea(5, 20);
        risksAndBenefitsText.setText(responseModel.getRisksAndBenefits());
        risksAndBenefitsText.setEditable(false);
        risksAndBenefitsText.setLineWrap(true);
        scrollPane.setViewportView(risksAndBenefitsText);

        JPanel contentPanel3 = new JPanel();
        contentPanel3.setLayout(new BoxLayout(contentPanel3, BoxLayout.X_AXIS));
        JLabel participantRights = new JLabel("Participant Rights: ", SwingConstants.LEFT);
        participantRights.setFont(new Font("Serif", Font.BOLD, 16));
        contentPanel3.add(participantRights);
        JTextArea participantRightsText = new JTextArea(5, 20);
        participantRightsText.setText(responseModel.getParticipantRights());
        participantRightsText.setEditable(false);
        participantRightsText.setLineWrap(true);
        scrollPane.setViewportView(participantRightsText);

        panel.add(titlePanel);
        panel.add(contentPanel1);
        panel.add(studyDescriptionText);
        panel.add(contentPanel2);
        panel.add(risksAndBenefitsText);
        panel.add(contentPanel3);
        panel.add(participantRightsText);

        add(panel, BorderLayout.NORTH);

        pack();
        SetScreenToCenter setScreenToCenter = new SetScreenToCenter(this);
    }
}
