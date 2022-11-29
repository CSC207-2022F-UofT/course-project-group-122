package use_cases.answer_questionnaire_data_request;

import user_interface_layer.screens.create_questionnaire_inputs_screen.QuestionModel;
import user_interface_layer.screens.user_answer_questionnaires_screen.questions_panel.ParticipantsQuestionPanel;
import user_interface_layer.screens.user_answer_questionnaires_screen.questions_panel.QuestionsPanelBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * This class is used to pass data to the ParticipantAnswerQuestionnairePanel
 */
public class FetchQuestionnaireDataForAnswerResponseModel {

    /*
     * The participant ID.
     */
    private final int participantID;

    private final int modifierId;

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
    private final List<QuestionModel> questionsModel;

    public FetchQuestionnaireDataForAnswerResponseModel(int participantID,
                                                        int modifierId,
                                                        int studyID,
                                                        int questionnaireID,
                                                        String questionnaireName,
                                                        String questionnaireDescription,
                                                        List<QuestionModel> questionsModel) {
        this.participantID = participantID;
        this.modifierId = modifierId;
        this.studyID = studyID;
        this.questionnaireID = questionnaireID;
        this.questionnaireName = questionnaireName;
        this.questionnaireDescription = questionnaireDescription;
        this.questionsModel = questionsModel;
    }

    /*
     * Creates the questions panels for the screen.
     */
    private void createQuestionsPanels(){
        QuestionsPanelBuilder builder = new QuestionsPanelBuilder();
        for (QuestionModel model : questionsModel) {
            String type = model.getType();
            switch (type) {
                case "MC": {
                    ParticipantsQuestionPanel panel = builder.buildMCQuestionPanel(model.getContent(), type, model.getVariable(), model.getOptions());
                    questionsPanel.add(panel);
                    break;
                }
                case "Scale": {
                    ParticipantsQuestionPanel panel = builder.buildScaleQuestionPanel(model.getContent(), type, model.getVariable(), model.getOptions());
                    questionsPanel.add(panel);
                    break;
                }
                case "Text": {
                    ParticipantsQuestionPanel panel = builder.buildTextQuestionPanel(model.getContent(), type, model.getVariable());
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

    public int getModifierId() {
        return modifierId;
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
