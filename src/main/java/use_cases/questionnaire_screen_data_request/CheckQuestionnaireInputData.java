package use_cases.questionnaire_screen_data_request;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 * This class is used to pass data to the CheckQuestionnaireScreen.
 * Through display_researcher_questionnaire.
 *
 */
public class CheckQuestionnaireInputData {
    /*
     * The identifier of the questionnaire.
     */
    private final int questionnaireId;

    /*
     * The name of the questionnaire.
     */
    private final String questionnaireName;

    /*
     * The description of the questionnaire.
     */
    private final String questionnaireDescription;

    /*
     * The header of the table that displays the questions.
     */
    private final String[] questionsTableHeader = {"Type", "Question", "Variable", "Options"};

    /*
     * The List of questions that the questionnaire has organized as an array. This attribute is used to display the questions in the table.
     */
    private final List<String[]> formattedQuestions = new ArrayList<>();

    /**
     * The study id.
     */
    private final int studyId;

    /* Map <"Variable" ; [type, description, options]>
     * The key is the question. The value is an array with the question's type, variable and options.
     * The options should be formatted as follows:
     *     - For MC questions: comma separated and without spaces.
     *     - For Scale questions: comma separated such like buttonLabel,topLabel,scale.
     *     - For Text questions: empty string.
     */
    public CheckQuestionnaireInputData(int questionnaireId,
                                       String questionnaireName,
                                       String questionnaireDescription,
                                       @NotNull Map<String, String[]> questions,
                                       int studyId) {
        this.questionnaireId = questionnaireId;
        this.questionnaireName = questionnaireName;
        this.questionnaireDescription = questionnaireDescription;
        for (Map.Entry<String, String[]> entry : questions.entrySet()) {
            String[] question = new String[]{entry.getValue()[0], entry.getValue()[1], entry.getKey(), entry.getValue()[2]};
            formattedQuestions.add(question);
        }
        this.studyId = studyId;
    }

    /*
     * Returns the identifier of the questionnaire.
     */
    public int getQuestionnaireId() {
        return questionnaireId;
    }

    /*
     * Returns the name of the questionnaire.
     */
    public String getQuestionnaireName() {
        return questionnaireName;
    }

    /*
     * Returns the description of the questionnaire.
     */
    public String getQuestionnaireDescription() {
        return questionnaireDescription;
    }

    /*
     * Returns the header of the table that displays the questions.
     */
    public String[] getQuestionsTableHeader() {
        return questionsTableHeader;
    }

    /*
     * Returns the List of questions that the questionnaire has organized as an array. This attribute is used to display the questions in the table.
     */
    public List<String[]> getFormattedQuestions() {
        return formattedQuestions;
    }


    /**
     * Returns the study id.
     * @return
     */
    public int getStudyId() {
        return studyId;
    }

}
