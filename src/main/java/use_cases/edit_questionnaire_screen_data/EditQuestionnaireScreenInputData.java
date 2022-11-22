package use_cases.edit_questionnaire_screen_data;

import user_interface_layer.screens.ControllerManager;

import java.util.List;
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


    private List<String> studyGroups;
    /*
     * The questions of the questionnaire.
     * The key is the question. The value is an array with the question's type, variable and options.
     * The options should be formatted as follows:
     *     - For MC questions: comma separated and without spaces.
     *     - For Scale questions: comma separated such like buttonLabel,topLabel,scale.
     *     - For Text questions: empty string.
     */
    private final Map<String, String[]> questions;




    /*
     * The constructor of the class.
     * @param studyID The study ID.
     * @param questionnaireID The questionnaire ID.
     * @param questionnaireName The questionnaire name.
     * @param questionnaireDescription The questionnaire description.
     * @param questions The questions of the questionnaire. Map< "Variable" ; [type, description, options] >
     * @param controllerManager The controller manager.
     */
    public EditQuestionnaireScreenInputData(int studyID,
                                            int questionnaireID,
                                            String questionnaireName,
                                            String questionnaireDescription,
                                            List<String> studyGroups,
                                            Map<String, String[]> questions) {
        this.studyID = studyID;
        this.questionnaireID = questionnaireID;
        this.questionnaireName = questionnaireName;
        this.questionnaireDescription = questionnaireDescription;
        this.studyGroups = studyGroups;
        this.questions = questions;
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


    public List<String> getStudyGroups() {
        return studyGroups;
    }
}

