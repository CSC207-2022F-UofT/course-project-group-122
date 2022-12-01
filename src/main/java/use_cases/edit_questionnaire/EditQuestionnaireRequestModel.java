package use_cases.edit_questionnaire;

import user_interface_layer.screens.create_questionnaire_inputs_screen.QuestionModel;

import java.util.ArrayList;
import java.util.List;

/**
 * The data structure class that the use case needs to edit the questionnaire.
 */
public class EditQuestionnaireRequestModel {
    /**
     * The study id of the study that the questionnaire belongs to.
     */
    int studyID;
    /**
     * The questionnaire id of the questionnaire that the researcher wants to edit.
     */
    int questionnaireID;
    /**
     * The researcher id of the researcher that wants to edit the questionnaire.
     */
    int researcherID;
    /**
     * The name of the questionnaire.
     */
    String questionnaireName;
    /**
     * The description of the questionnaire.
     */
    String questionnaireDescription;

    /**
     * The list of the target groups of participants that the questionnaire is targeted to.
     */
    List<String> studyGroups;
    /**
     * The list of the questions that the questionnaire has, including the previous questions and the new questions,
     * formatted in the QuestionModel class.
     */
    List<QuestionModel> questions;

    /**
     * The constructor of the class.
     * @param studyID The study id of the study that the questionnaire belongs to.
     * @param questionnaireID The questionnaire id of the questionnaire that the researcher wants to edit.
     * @param researcherID The researcher id of the researcher that wants to edit the questionnaire.
     * @param questionnaireName The name of the questionnaire.
     * @param questionnaireDescription The description of the questionnaire.
     * @param studyGroupNames The list of the target groups of participants that the questionnaire is targeted to.
     * @param questions The list of the questions that the questionnaire has, including the previous questions
     *                  and the new questions,
     */
    public EditQuestionnaireRequestModel(int studyID, int questionnaireID, int researcherID, String questionnaireName, String questionnaireDescription, ArrayList<String> studyGroupNames, List<QuestionModel> questions) {
        this.studyID = studyID;
        this.questionnaireID = questionnaireID;
        this.researcherID = researcherID;
        this.questionnaireName = questionnaireName;
        this.questionnaireDescription = questionnaireDescription;
        this.studyGroups = studyGroupNames;
        this.questions = questions;
    }

    /**
     * @return The study id of the study that the questionnaire belongs to.
     */
    public int getStudyID() {
        return studyID;
    }

    /**
     * @return The questionnaire id of the questionnaire that the researcher wants to edit.
     */
    public int getQuestionnaireID() {
        return questionnaireID;
    }

    /**
     * @return The researcher id of the researcher that wants to edit the questionnaire.
     */
    public int getResearcherID() {
        return researcherID;
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
     * @return The list of the target groups of participants that the questionnaire is targeted to.
     */
    public List<String> getStudyGroups() {
        return studyGroups;
    }

    /**
     * @return The list of the questions that the questionnaire has, including the previous questions and the
     * new questions, formatted in the QuestionModel class.
     */
    public List<QuestionModel> getQuestions() {
        return questions;
    }
}
