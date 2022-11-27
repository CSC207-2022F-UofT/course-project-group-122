package use_cases.answer_questionnaire_data_request;

import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.participant_answer_questionnaire_panel.questions_panel.ParticipantsQuestionPanel;
import user_interface_layer.screens.participant_answer_questionnaire_panel.questions_panel.QuestionsPanelBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * This class is used to pass data to the ParticipantAnswerQuestionnairePanel
 */
public class ParticipantAnswerQuestionnairePanelInputData {

    /*
     * The participant ID.
     */
    private final int participantID;

    /*
     * The study ID.
     */
    private final int studyID;

    /*
     * The questionnaire ID.
     */
    private final int questionnaireID;

    /*
     * Thr name of the questionnaire.
     */
    private final String questionnaireName;

    /*
     * The description of the questionnaire.
     */
    private final String questionnaireDescription;

    /*
     * The list of Panels that are used for the screen. Each panel is a question with a space to answer accordingly
     * to the type of question.
     */
    private final List<ParticipantsQuestionPanel> questionsPanel = new ArrayList<>();

    /*
     * The map of questions and its type.
     * {"Question":"Type"}
     */
    private final Map<String, String> questionsTypes = new HashMap<>();

    /*
     * The map of questions and its variables.
     * {"Question":"Variable"}
     */
    private final Map<String, String> questionsVariable = new HashMap<>();

    /*
     * The map of questions and its options.
     * {"Question":"Options"}
     */
    private final Map<String, String> questionsOptions = new HashMap<>();

// {"Question":[type][variable][options]}
    // if type is MC, then answer option,option,option
    // if type is SC, then answer bottomLabel,topLabel,scale
    // if type is Text, then answer "" or "what ever suggestion text"
    public ParticipantAnswerQuestionnairePanelInputData(int participantID,
                                                        int studyID,
                                                        int questionnaireID,
                                                        String questionnaireName,
                                                        String questionnaireDescription,
                                                        Map<String, String[]> questionsInformation) {
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
        createQuestionsPanels();
    }

    /*
     * Creates the questions panels for the screen.
     */
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
    /*
     * Returns the participant ID.
     */
    public int getParticipantID() {
        return participantID;
    }

    /*
     * Returns the study ID.
     */
    public int getStudyID() {
        return studyID;
    }

    /*
     * Returns the questionnaire ID.
     */
    public int getQuestionnaireID() {
        return questionnaireID;
    }

    /*
     * Returns the questionnaire name.
     */
    public String getQuestionnaireName() {
        return questionnaireName;
    }

    /*
     * Returns the questionnaire description.
     */
    public String getQuestionnaireDescription() {
        return questionnaireDescription;
    }

    /*
     * Returns the questions panels.
     */
    public List<ParticipantsQuestionPanel> getQuestionsPanel() {
        return questionsPanel;
    }


}
