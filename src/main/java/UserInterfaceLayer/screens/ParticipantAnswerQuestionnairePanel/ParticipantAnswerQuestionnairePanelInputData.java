package UserInterfaceLayer.screens.ParticipantAnswerQuestionnairePanel;

import UserInterfaceLayer.screens.ControllerManager;
import UserInterfaceLayer.screens.ParticipantAnswerQuestionnairePanel.QuestionsPanel.ParticipantsQuestionPanel;
import UserInterfaceLayer.screens.ParticipantAnswerQuestionnairePanel.QuestionsPanel.QuestionsPanelBuilder;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParticipantAnswerQuestionnairePanelInputData {
    private final int participantID;

    private final int studyID;

    private final int questionnaireID;

    private final String questionnaireName;

    private final String questionnaireDescription;

    private List<ParticipantsQuestionPanel> questionsPanel;
    // {"Question":"Type"}
    private final Map<String, String> questionsTypes = new HashMap<>();
    // {"Question":"Variable"}
    private final Map<String, String> questionsVariable = new HashMap<>();
    // {"Question":"Answer"}
    private final Map<String, String> questionsOptions = new HashMap<>();

    private final ControllerManager controllerManager;

// {"Question":[type][variable][answer]}
    // if type is MC, then answer option,option,option
    // if type is SC, then answer bottomLabel, topLabel, scale
    // if type is Text, then answer "" or "what ever suggestion text"
    public ParticipantAnswerQuestionnairePanelInputData(int participantID,
                                                        int studyID,
                                                        int questionnaireID,
                                                        String questionnaireName,
                                                        String questionnaireDescription,
                                                        Map<String, String[]> questionsInformation,
                                                        ControllerManager controllerManager) {
        this.participantID = participantID;
        this.studyID = studyID;
        this.questionnaireID = questionnaireID;
        this.questionnaireName = questionnaireName;
        this.questionnaireDescription = questionnaireDescription;

        for (Map.Entry<String, String[]> entry : questionsInformation.entrySet()) {
            questionsTypes.put(entry.getKey(), entry.getValue()[0]);
            questionsVariable.put(entry.getKey(), entry.getValue()[1]);
            questionsOptions.put(entry.getKey(), entry.getValue()[2]);
        }

        this.controllerManager = controllerManager;

    }

    public void createQuestionsPanels(){
        QuestionsPanelBuilder builder = new QuestionsPanelBuilder();
        for (Map.Entry<String, String> entry : questionsTypes.entrySet()) {
            String type = entry.getValue();
            switch (type) {
                case "MC": {
                    ParticipantsQuestionPanel panel = builder.buildMCQuestionPanel(entry.getKey(), type, questionsVariable.get(entry.getKey()), questionsOptions.get(entry.getKey()));
                    questionsPanel.add(panel);
                    break;
                }
                case "Scale": {
                    ParticipantsQuestionPanel panel = builder.buildScaleQuestionPanel(entry.getKey(), type, questionsVariable.get(entry.getKey()), questionsOptions.get(entry.getKey()));
                    questionsPanel.add(panel);
                    break;
                }
                case "Text": {
                    ParticipantsQuestionPanel panel = builder.buildTextQuestionPanel(entry.getKey(), type, questionsVariable.get(entry.getKey()), questionsOptions.get(entry.getKey()));
                    questionsPanel.add(panel);
                    break;
                }
            }
        }


    }

    public int getParticipantID() {
        return participantID;
    }

    public int getStudyID() {
        return studyID;
    }

    public int getQuestionnaireID() {
        return questionnaireID;
    }

    public String getQuestionnaireName() {
        return questionnaireName;
    }

    public String getQuestionnaireDescription() {
        return questionnaireDescription;
    }

    public List<ParticipantsQuestionPanel> getQuestionsPanel() {
        return questionsPanel;
    }

    public Map<String, String> getQuestionsTypes() {
        return questionsTypes;
    }

    public Map<String, String> getQuestionsVariable() {
        return questionsVariable;
    }

    public Map<String, String> getQuestionsOptions() {
        return questionsOptions;
    }

    public ControllerManager getControllerManager() {
        return controllerManager;
    }

}
