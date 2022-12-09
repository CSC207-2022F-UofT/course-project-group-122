package use_cases.answer_questionnaire_data_request;

import user_interface_layer.screens.create_questionnaire_inputs_screen.QuestionModel;
import user_interface_layer.screens.user_answer_questionnaires_screen.questions_panel.ParticipantsQuestionPanel;
import user_interface_layer.screens.user_answer_questionnaires_screen.questions_panel.CreateQuestionsPanel;

import java.util.ArrayList;
import java.util.List;

/*
 * This class is used to pass data to the ParticipantAnswerQuestionnairePanel
 */
public class FetchQuestionnaireDataForAnswerResponseModel {

    /*
     * The participant ID.
     */
    private final int participantID;

    /**
     * The modifier's ID, i.e. the id of the researcher that is modifying the answer of the questionnaire.
     */
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

    /*
     * The list of questions that are used for the screen. QuestionModel is a data structure class used to pass data to
     * the screen.
     */
    private final List<QuestionModel> questionsModel;

    /**
     * @param participantID The participant ID.
     * @param modifierId The modifier's ID, i.e. the id of the researcher that is modifying the answer of the questionnaire.
     * @param studyID The study ID.
     * @param questionnaireID The questionnaire ID.
     * @param questionnaireName The name of the questionnaire.
     * @param questionnaireDescription The description of the questionnaire.
     * @param questionsModel The list of questions that are used for the screen. QuestionModel is a data structure class used to pass data to the screen.
     */
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
        createQuestionsPanels();
    }

    /*
     * Creates the questions panels for the screen.
     */
    private void createQuestionsPanels(){
        CreateQuestionsPanel builder = new CreateQuestionsPanel();
        for (QuestionModel model : questionsModel) {
            String type = model.getType();
            switch (type) {
                case "MC": {
                    ParticipantsQuestionPanel panel = builder.buildMCQuestionPanel(
                            model.getContent(),
                            type, model.getVariable(),
                            model.getOptions());
                    questionsPanel.add(panel);
                    break;
                }
                case "Scale": {
                    ParticipantsQuestionPanel panel = builder.buildScaleQuestionPanel(
                            model.getContent(),
                            type, model.getVariable(),
                            model.getOptions());
                    questionsPanel.add(panel);
                    break;
                }
                case "Text": {
                    ParticipantsQuestionPanel panel = builder.buildTextQuestionPanel(
                            model.getContent(),
                            type, model.getVariable());
                    questionsPanel.add(panel);
                    break;
                }
            }
        }
    }
    /**
     * @return The participant ID.
     */
    public int getParticipantID() {
        return participantID;
    }

    /**
     * @return The modifier's ID, i.e. the id of the researcher that is modifying the answer of the questionnaire.
     */
    public int getModifierId() {
        return modifierId;
    }

    /**
     * @return The study ID.
     */
    public int getStudyID() {
        return studyID;
    }

    /**
     * @return The questionnaire ID.
     */
    public int getQuestionnaireID() {
        return questionnaireID;
    }

    /**
     * @return The name of the questionnaire.
     */
    public String getQuestionnaireName() {
        return questionnaireName;
    }

    /**
     * @return The description of the questionnaire.
     */
    public String getQuestionnaireDescription() {
        return questionnaireDescription;
    }

    /**
     * @return The list of Panels that are used for the screen. Each panel is a question with a space to answer
     * accordingly to the type of question.
     */
    public List<ParticipantsQuestionPanel> getQuestionsPanel() {
        return questionsPanel;
    }


}
