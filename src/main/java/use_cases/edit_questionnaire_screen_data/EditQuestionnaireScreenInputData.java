package use_cases.edit_questionnaire_screen_data;

import user_interface_layer.screens.create_questionnaire_inputs_screen.QuestionModel;

import java.util.ArrayList;
import java.util.List;


/**
 * The data structure class that the use case needs to fetch the information for editing the questionnaire.
 */
public class EditQuestionnaireScreenInputData {

    /*
     * The study ID.
     */
    private final int studyID;

    /**
     * The questionnaire ID.
     */
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

    /**
     * The list of the target groups of participants that the questionnaire is targeted to.
     */
    private final List<String> studyGroups;
    /*
     * The questions of the questionnaire, formatted in the QuestionModel class.
     */
    private final List<QuestionModel> questions;

    /*
     * The list of variables corresponding to each question.
     */
    private final List<String> previousVariables = new ArrayList<>();

    /**
     * The constructor of the class.
     * @param studyID The study ID.
     * @param questionnaireID The questionnaire ID.
     * @param researcherID The researcher ID.
     * @param questionnaireName The questionnaire name.
     * @param questionnaireDescription The questionnaire description.
     * @param studyGroups The list of the target groups of participants that the questionnaire is targeted to.
     * @param questions The questions of the questionnaire, formatted in the QuestionModel class.
     */
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
     * @return The researcher ID.
     */
    public int getResearcherID() {return researcherID; }

    /**
     * @return The questionnaire name.
     */
    public String getQuestionnaireName() {
        return questionnaireName;
    }

    /**
     * @return The questionnaire description.
     */
    public String getQuestionnaireDescription() {
        return questionnaireDescription;
    }

    /**
     * @return The list of the target groups of participants that the questionnaire is targeted to.
     */
    public List<QuestionModel> getQuestions() {
        return questions;
    }

    /**
     * @return The list of the target groups of participants that the questionnaire is targeted to.
     */
    public List<String> getPreviousVariables() {
        return previousVariables;
    }

    /**
     * @return The list of the target groups of participants that the questionnaire is targeted to.
     */
    public List<String> getStudyGroups() {
        return studyGroups;
    }
}

