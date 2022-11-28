package use_cases.create_questionnaire;

import user_interface_layer.screens.create_questionnaire_inputs_screen.QuestionModel;

import java.util.List;

public class CreateQuestionnaireRequestModel {
    String type;
    int studyID;
    int researcherID;
    String questionnaireName;
    String questionnaireDescription;
    List<String> groups;
    int numOfQuestions;
    List<QuestionModel> questions;

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

    public String getType() {
        return type;
    }

    public int getStudyID() {
        return studyID;
    }

    public String getQuestionnaireName() {
        return questionnaireName;
    }

    public String getQuestionnaireDescription() {
        return questionnaireDescription;
    }

    public int getNumOfQuestions() {
        return numOfQuestions;
    }

    public List<String> getGroups() {
        return groups;
    }

    public List<QuestionModel> getQuestions() {
        return questions;
    }

    public int getResearcherID() {
        return researcherID;
    }
}

