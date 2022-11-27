package use_cases.edit_questionnaire_screen_data;

import user_interface_layer.screens.create_questionnaire_inputs_screen.QuestionModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class EditQuestionnaireScreenInputData {

    /*
     * The study ID.
     */
    private final int studyID;


    private final int researcherID;

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

    private List<String> studyGroups;
    /*
     * The questions of the questionnaire.
     * The key is the question. The value is an array with the question's type, variable and options.
     * The options should be formatted as follows:
     *     - For MC questions: comma separated and without spaces.
     *     - For Scale questions: comma separated such like buttonLabel,topLabel,scale.
     *     - For Text questions: empty string.
     */
    private final List<QuestionModel> questions;

    /*
     * The constructor of the class.
     * @param studyID The study ID.
     * @param questionnaireID The questionnaire ID.
     * @param questionnaireName The questionnaire name.
     * @param questionnaireDescription The questionnaire description.
     * @param questions The questions of the questionnaire. Map< "Variable" ; [type, description, options] >
     * @param controllerManager The controller manager.
     */
    private List<String> previousVariables = new ArrayList<>();

    public EditQuestionnaireScreenInputData(int studyID,
                                            int questionnaireID,
                                            int researcherID,
                                            String questionnaireName,
                                            String questionnaireDescription,
                                            List<String> studyGroups,
                                            List<QuestionModel> questions) {
        this.studyID = studyID;
        this.questionnaireID = questionnaireID;
        this.researcherID = researcherID;
        this.questionnaireName = questionnaireName;
        this.questionnaireDescription = questionnaireDescription;
        this.studyGroups = studyGroups;
        this.questions = questions;
        for (QuestionModel question : questions) {
            previousVariables.add(question.getVariable());
        }

    }

    public int getStudyID() {
        return studyID;
    }

    public int getQuestionnaireID() {
        return questionnaireID;
    }

    public int getResearcherID() {return researcherID; }

    public String getQuestionnaireName() {
        return questionnaireName;
    }

    public String getQuestionnaireDescription() {
        return questionnaireDescription;
    }

    public List<QuestionModel> getQuestions() {
        return questions;
    }

    public List<String> getPreviousVariables() {
        return previousVariables;
    }

    public List<String> getStudyGroups() {
        return studyGroups;
    }
}

