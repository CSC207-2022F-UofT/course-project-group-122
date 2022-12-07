package user_interface_layer.screens.user_answer_questionnaires_screen.questions_panel;

/**
 * The builder of the questions panel.
 */
public class CreateQuestionsPanel {
    /**
     * The constructor of the builder.
     */
    public CreateQuestionsPanel() {
    }

    /**
     * Creates a panel for the multiple choice question.
     * @param question The question.
     * @param type   The type of the question.
     * @param variable The variable of the question.
     * @param options The options of the question.
     * @return The panel of the question.
     */
    public ParticipantsQuestionPanel buildMCQuestionPanel(String question, String type, String variable, String options){
        String[] optionsList = options.split(",");
        return new MCQuestionPanel(question, type, variable, optionsList);
    }

    /**
     * Creates a panel for the scale question.
     * @param question The question.
     * @param type  The type of the question.
     * @param variable The variable of the question.
     * @param options The options of the question.
     * @return The panel of the question.
     */
    public ParticipantsQuestionPanel buildScaleQuestionPanel(String question, String type, String variable, String options){
        String[] optionsList= options.split(",");
        String bottomLabel = optionsList[0];
        String topLabel = optionsList[1];
        int scale = Integer.parseInt(optionsList[2]);
        return new ScaleQuestionPanel(question, type, variable, bottomLabel, topLabel, scale);
    }

    /**
     * Creates a panel for the text question.
     * @param question The question.
     * @param type The type of the question.
     * @param variable The variable of the question.
     * @return The panel of the question.
     */
    public ParticipantsQuestionPanel buildTextQuestionPanel(String question, String type, String variable){
        return new TextQuestionPanel(question, type, variable);


    }


}
