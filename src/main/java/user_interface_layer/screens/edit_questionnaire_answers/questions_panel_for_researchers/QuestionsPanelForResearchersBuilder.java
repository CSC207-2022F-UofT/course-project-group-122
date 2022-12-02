package user_interface_layer.screens.edit_questionnaire_answers.questions_panel_for_researchers;

/**
 * The Builder class for building the panel that contains the questions and the answers for a questionnaire.
 */
public class QuestionsPanelForResearchersBuilder {
    /**
     * The constructor of the class.
     */
    public QuestionsPanelForResearchersBuilder() {
    }

    /**
     * Builds a panel for a multiple choice question.
     * @param question The question.
     * @param type   The type of the question.
     * @param variable The variable of the question.
     * @param options The options of the question.
     * @param answer The answer of the question.
     * @return The panel that contains the question and the answer for a question.
     */
    public ResearchersQuestionPanel buildMCQuestionPanel(String question, String type, String variable, String options, String answer){
        String[] optionsList = options.split(",");
        return new MCQuestionPanelForResearchers(question, type, variable, optionsList, answer);

    }

    /**
     * Builds a panel for a scale question.
     * @param question The question.
     * @param type   The type of the question.
     * @param variable The variable of the question.
     * @param options The options of the question.
     * @param answer The answer of the question.
     * @return The panel that contains the question and the answer for a question.
     */
    public ResearchersQuestionPanel buildScaleQuestionPanel(String question, String type, String variable, String options, String answer){
        String[] optionsList= options.split(",");
        String bottomLabel = optionsList[0];
        String topLabel = optionsList[1];
        int scale = Integer.parseInt(optionsList[2]);
        return new ScaleQuestionPanelForResearchers(question, type, variable, bottomLabel, topLabel, scale, answer);
    }

    /**
     * Builds a panel for a text question.
     * @param question The question.
     * @param type   The type of the question.
     * @param variable The variable of the question.
     * @param options The options of the question.
     * @param answer The answer of the question.
     * @return The panel that contains the question and the answer for a question.
     */
    public ResearchersQuestionPanel buildTextQuestionPanel(String question, String type, String variable, String options, String answer){
        return new TextQuestionPanelForResearchers(question, type, variable, options, answer);
    }
}
