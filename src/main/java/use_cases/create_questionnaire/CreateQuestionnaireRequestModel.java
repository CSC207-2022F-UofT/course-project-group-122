package use_cases.create_questionnaire;

import user_interface_layer.screens.create_questionnaire_inputs_screen.QuestionModel;

import java.util.List;

/**
 * The data structure class that contains the data for the questionnaire to be created.
 */
public class CreateQuestionnaireRequestModel {
    /**
     * The type of the questionnaire.
     */
    String type;
    /**
     * The id of the study.
     */
    int studyID;
    /**
     * The id of the researcher.
     */
    int researcherID;
    /**
     * The name of questionnaire.
     */
    String questionnaireName;
    /**
     * The description of the questionnaire.
     */
    String questionnaireDescription;
    /**
     * The list of target groups.
     */
    List<String> groups;
    /**
     * The number of questions.
     */
    int numOfQuestions;
    /**
     * The list of questions in the QuestionModel format.
     */
    List<QuestionModel> questions;

    /**
     * The constructor for the CreateQuestionnaireRequestModel class.
     * @param type The type of the questionnaire.
     * @param studyID The id of the study.
     * @param researcherID The id of the researcher.
     * @param questionnaireName The name of questionnaire.
     * @param questionnaireDescription The description of the questionnaire.
     * @param groups The list of target groups.
     * @param numOfQuestions The number of questions.
     * @param questions The list of questions in the QuestionModel format.
     */
    public CreateQuestionnaireRequestModel(String type, int studyID, int researcherID, String questionnaireName, String questionnaireDescription, List<String> groups, int numOfQuestions, List<QuestionModel> questions) {
        this.type = type;
        this.studyID = studyID;
        this.researcherID = researcherID;
        this.questionnaireName = questionnaireName;
        this.questionnaireDescription = questionnaireDescription;
        this.numOfQuestions = numOfQuestions;
        this.groups = groups;
        this.questions = questions;
    }

    /**
     * @return The type of the questionnaire.
     */
    public String getType() {
        return type;
    }

    /**
     * @return The id of the study.
     */
    public int getStudyID() {
        return studyID;
    }

    /**
     * @return The name of questionnaire.
     */
    public String getQuestionnaireName() {
        return questionnaireName;
    }

    /**
     * @return The description of questionnaire.
     */
    public String getQuestionnaireDescription() {
        return questionnaireDescription;
    }

    /**
     * @return The list of target groups.
     */
    public List<String> getGroups() {
        return groups;
    }

    /**
     * @return The list of questions in the QuestionModel format.
     */
    public List<QuestionModel> getQuestions() {
        return questions;
    }

    /**
     * @return The id of the researcher.
     */
    public int getResearcherID() {
        return researcherID;
    }
}

