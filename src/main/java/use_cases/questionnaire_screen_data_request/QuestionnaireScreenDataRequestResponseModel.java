package use_cases.questionnaire_screen_data_request;

import java.util.ArrayList;
import java.util.List;

public class QuestionnaireScreenDataRequestResponseModel {
    private int questionnaireId;
    private String questionnaireName;
    private String questionnaireDescription;
    private String[] questionsTableHeader = {"Type", "Question", "Variable", "Options"};
    private final List<String[]> formattedQuestions = new ArrayList<>();


}

