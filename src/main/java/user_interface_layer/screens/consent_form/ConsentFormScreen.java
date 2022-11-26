package user_interface_layer.screens.consent_form;

import org.jetbrains.annotations.NotNull;
import use_cases.fetch_consent_form.FetchConsentFormResponseModel;
import user_interface_layer.screen_setters.SetScreenToCenter;
import user_interface_layer.screens.ControllerManager;

import javax.swing.*;
import java.awt.*;

public class ConsentFormScreen extends JFrame {


    public ConsentFormScreen(@NotNull FetchConsentFormResponseModel responseModel, ControllerManager controllerManager) {
        setTitle("Consent Form for Study: " + responseModel.getStudyName() + " (" + responseModel.getStudyId() + ")");
        setLayout(new BorderLayout());
        JLabel studyDescription = new JLabel("Study Description: ");
        JTextArea studyDescriptionText = new JTextArea(responseModel.getStudyDescription());
        studyDescriptionText.setEditable(false);
        JLabel risksAndBenefits = new JLabel("Risks and Benefits: ");
        JTextArea risksAndBenefitsText = new JTextArea(responseModel.getRisksAndBenefits());
        risksAndBenefitsText.setEditable(false);
        JLabel participantRights = new JLabel("Participant Rights: ");
        JTextArea participantRightsText = new JTextArea(responseModel.getParticipantRights());
        participantRightsText.setEditable(false);
        JButton accept = new JButton("Accept");
        accept.addActionListener(e -> {
            controllerManager.answerEligibilityQuestionnaireRequestData(responseModel.getUserId(),
                    responseModel.getParticipantId(), responseModel.getEligibilityQuestionnaireId(),
                    responseModel.getStudyId());
        });
        add(studyDescription, BorderLayout.NORTH);
        add(studyDescriptionText, BorderLayout.NORTH);
        add(risksAndBenefits, BorderLayout.CENTER);
        add(risksAndBenefitsText, BorderLayout.CENTER);
        add(participantRights, BorderLayout.SOUTH);
        add(participantRightsText, BorderLayout.SOUTH);
        add(accept, BorderLayout.SOUTH);
        pack();
        SetScreenToCenter setScreenToCenter = new SetScreenToCenter(this);
    }
}
