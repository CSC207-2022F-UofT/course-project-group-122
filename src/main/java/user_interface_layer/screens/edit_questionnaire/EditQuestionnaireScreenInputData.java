package user_interface_layer.screens.edit_questionnaire;

import user_interface_layer.screens.ControllerManager;

import java.util.Map;


public class EditQuestionnaireScreenInputData {

    /*
     * The study ID.
     */
    private final int studyID;

    /*
     * The questionnaire ID.
     */
    private final int questionnaireID;

    /*
     * The questionnaire name.
     */
    private final String questionnaireName;

    /*
     * The questionnaire description.
     */
    private final String questionnaireDescription;

    /*
     * The header for the question's table.
     */
    private final String[] questionsTableHeader = {"Type", "Question", "Variable", "Options"};

    /*
     * The questions of the questionnaire.
     * The key is the question. The value is an array with the question's type, variable and options.
     * The options should be formatted as follows:
     *     - For MC questions: comma separated and without spaces.
     *     - For Scale questions: comma separated such like buttonLabel,topLabel,scale.
     *     - For Text questions: empty string.
     */
    private final Map<String, String[]> questions;

    private final ControllerManager controllerManager;

    public EditQuestionnaireScreenInputData(int studyID,
                                            int questionnaireID,
                                            String questionnaireName,
                                            String questionnaireDescription,
                                            Map<String, String[]> questions,
                                            ControllerManager controllerManager) {
        this.studyID = studyID;
        this.questionnaireID = questionnaireID;
        this.questionnaireName = questionnaireName;
        this.questionnaireDescription = questionnaireDescription;
        this.questions = questions;
        this.controllerManager = controllerManager;
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

    public Map<String, String[]> getQuestions() {
        return questions;
    }

    public String[] getQuestionsTableHeader() {
        return questionsTableHeader;
    }

    public ControllerManager getControllerManager() {
        return controllerManager;
    }


}

