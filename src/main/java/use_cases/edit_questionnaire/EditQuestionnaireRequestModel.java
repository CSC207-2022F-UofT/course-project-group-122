package use_cases.edit_questionnaire;

import user_interface_layer.screens.create_questionnaire_inputs_screen.QuestionModel;

import java.util.ArrayList;
import java.util.List;

public class EditQuestionnaireRequestModel {
    int studyID;
    int questionnaireID;
    int researcherID;
    String questionnaireName;
    String questionnaireDescription;

    List<String> studyGroups;
    List<QuestionModel> questions;



    public EditQuestionnaireRequestModel(int studyID, int questionnaireID, int researcherID, String questionnaireName, String questionnaireDescription, ArrayList<String> studyGroupNames, List<QuestionModel> questions) {
        this.studyID = studyID;
        this.questionnaireID = questionnaireID;
        this.researcherID = researcherID;
        this.questionnaireName = questionnaireName;
        this.questionnaireDescription = questionnaireDescription;
        this.studyGroups = studyGroupNames;
        this.questions = questions;
    }

    public int getStudyID() {
        return studyID;
    }

    public int getQuestionnaireID() {
        return questionnaireID;
    }

    public int getResearcherID() {
        return researcherID;
    }

    public String getQuestionnaireName() {
        return questionnaireName;
    }

    public String getQuestionnaireDescription() {
        return questionnaireDescription;
    }

    public List<String> getStudyGroups() {
        return studyGroups;
    }

    public List<QuestionModel> getQuestions() {
        return questions;
    }
}
