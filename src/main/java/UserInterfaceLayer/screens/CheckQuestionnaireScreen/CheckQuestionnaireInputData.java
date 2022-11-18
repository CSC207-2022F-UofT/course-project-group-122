package UserInterfaceLayer.screens.CheckQuestionnaireScreen;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CheckQuestionnaireInputData {
    private int questionnaireId;
    private String questionnaireName;
    private String questionnaireDescription;
    private String[] questionsTableHeader = {"Type", "Question", "Variable", "Options"};
    private final List<String[]> formattedQuestions = new ArrayList<>();


    public CheckQuestionnaireInputData(int questionnaireId,
                                       String questionnaireName,
                                       String questionnaireDescription,
                                       Map<String, String[]> questions) {
        this.questionnaireId = questionnaireId;
        this.questionnaireName = questionnaireName;
        this.questionnaireDescription = questionnaireDescription;
        for (Map.Entry<String, String[]> entry : questions.entrySet()) {
            String[] question = new String[]{entry.getValue()[0], entry.getKey(), entry.getValue()[1], entry.getValue()[2]};
            formattedQuestions.add(question);
        }
    }

    public int getQuestionnaireId() {
        return questionnaireId;
    }

    public String getQuestionnaireName() {
        return questionnaireName;
    }

    public String getQuestionnaireDescription() {
        return questionnaireDescription;
    }


    public String[] getQuestionsTableHeader() {
        return questionsTableHeader;
    }

    public List<String[]> getFormattedQuestions() {
        return formattedQuestions;
    }

}
