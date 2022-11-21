package use_cases.edit_questionnaire;

import java.util.Map;

public class EditQuestionnaireControllerInputData {
    int studyID;
    int questionnaireID;
    String questionnaireName;
    String questionnaireDescription;
    Map<String, String[]> newQuestions;


    public EditQuestionnaireControllerInputData(int studyID, int questionnaireID, String questionnaireName, String questionnaireDescription, Map<String, String[]> newQuestions) {
        this.studyID = studyID;
        this.questionnaireID = questionnaireID;
        this.questionnaireName = questionnaireName;
        this.questionnaireDescription = questionnaireDescription;
        this.newQuestions = newQuestions;
    }
}
