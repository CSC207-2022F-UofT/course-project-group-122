package use_cases.create_questionnaire;

import java.util.Map;

public class CreateQuestionnaireControllerInputData {
    int studyID;
    String questionnaireName;
    String questionnaireDescription;
    int numOfQuestions;
    Map<String, String[]> questionMap;

    public CreateQuestionnaireControllerInputData(int studyID, String questionnaireName, String questionnaireDescription, int numOfQuestions, Map<String, String[]> questionMap) {
        this.studyID = studyID;
        this.questionnaireName = questionnaireName;
        this.questionnaireDescription = questionnaireDescription;
        this.numOfQuestions = numOfQuestions;
        this.questionMap = questionMap;
    }
}

