package user_interface_layer.screens.consent_form;

import use_cases.create_consent_form.CreateConsentFormRequestModel;
import user_interface_layer.screen_helper_classes.SetScreenToCenter;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.message_screens.GeneralFailureScreen;

import javax.swing.*;
import java.awt.*;

/**
 * This is the screen for creating a consent form.
 */
public class CreateConsentFormScreen extends JFrame {

    /**
     * @param studyId The study id.
     * @param researcherId The researcher id.
     * @param controllerManager The controller manager.
     */
    public CreateConsentFormScreen(int studyId, int researcherId, ControllerManager controllerManager) {
        super("Create Consent Form Screen");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JTextArea studyDescription = new JTextArea(3, 20);
        JPanel studyDescriptionInputPanel = new JPanel();
        studyDescriptionInputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel studyDescriptionLabel = new JLabel("Study Description: ", SwingConstants.CENTER);
        studyDescription.setLineWrap(true);
        JScrollPane studyDescriptionScrollPane = new JScrollPane(studyDescription);
        studyDescriptionInputPanel.add(studyDescriptionLabel);
        studyDescriptionInputPanel.add(studyDescriptionScrollPane);

        JTextArea risksAndBenefits = new JTextArea(3, 20);
        JPanel risksAndBenefitsInputPanel = new JPanel();
        risksAndBenefitsInputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel risksAndBenefitsLabel = new JLabel("Risks and Benefits: ", SwingConstants.CENTER);
        risksAndBenefits.setLineWrap(true);
        JScrollPane risksAndBenefitsScrollPane = new JScrollPane(risksAndBenefits);
        risksAndBenefitsInputPanel.add(risksAndBenefitsLabel);
        risksAndBenefitsInputPanel.add(risksAndBenefitsScrollPane);

        JTextArea participantRights = new JTextArea(3, 20);
        JPanel participantRightsInputPanel = new JPanel();
        participantRightsInputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel participantRightsLabel = new JLabel("Participant Rights: ", SwingConstants.CENTER);
        participantRights.setLineWrap(true);
        JScrollPane participantRightsScrollPane = new JScrollPane(participantRights);
        participantRightsInputPanel.add(participantRightsLabel);
        participantRightsInputPanel.add(participantRightsScrollPane);

        JPanel createConsentFormButtonPanel = new JPanel();
        JButton createConsentFormButton = new JButton("Create Consent Form");
        createConsentFormButton.addActionListener(e -> {
            if (studyDescription.getText().equals("")
                    || risksAndBenefits.getText().equals("")
                    || participantRights.getText().equals("")) {
                new GeneralFailureScreen("Please fill out all fields");
            } else {
                CreateConsentFormRequestModel createConsentFormRequestModel = new CreateConsentFormRequestModel(
                        researcherId,
                        studyId,
                        studyDescription.getText(),
                        risksAndBenefits.getText(),
                        participantRights.getText()
                );
                controllerManager.createConsentForm(createConsentFormRequestModel);
                dispose();
            }
        });
        createConsentFormButtonPanel.add(createConsentFormButton);

        JPanel screenPanel = new JPanel();
        screenPanel.setLayout(new BoxLayout(screenPanel, BoxLayout.Y_AXIS));
        screenPanel.add(studyDescriptionInputPanel);
        screenPanel.add(risksAndBenefitsInputPanel);
        screenPanel.add(participantRightsInputPanel);
        screenPanel.add(createConsentFormButtonPanel);

        add(screenPanel, BorderLayout.CENTER);

        pack();
        SetScreenToCenter.setCenter(this);
    }

}
