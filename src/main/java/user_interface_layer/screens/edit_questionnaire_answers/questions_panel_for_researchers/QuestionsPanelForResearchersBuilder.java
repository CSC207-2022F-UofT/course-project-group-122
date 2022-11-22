package user_interface_layer.screens.edit_questionnaire_answers.questions_panel_for_researchers;

public class QuestionsPanelForResearchersBuilder {
    public QuestionsPanelForResearchersBuilder() {
    }
    public ResearchersQuestionPanel buildMCQuestionPanel(String question, String type, String variable, String options, String answer){
        String[] optionsList = options.split(",");
        return new MCQuestionPanelForResearchers(question, type, variable, optionsList, answer);

    }
    public ResearchersQuestionPanel buildScaleQuestionPanel(String question, String type, String variable, String options, String answer){
        String[] optionsList= options.split(",");
        String bottomLabel = optionsList[0];
        String topLabel = optionsList[1];
        int scale = Integer.parseInt(optionsList[2]);
        return new ScaleQuestionPanelForResearchers(question, type, variable, bottomLabel, topLabel, scale, answer);
    }

    public ResearchersQuestionPanel buildTextQuestionPanel(String question, String type, String variable, String options, String answer){
        return new TextQuestionPanelForResearchers(question, type, variable, options, answer);


    }

    public static void main(String[] args) {
        QuestionsPanelForResearchersBuilder builder = new QuestionsPanelForResearchersBuilder();
        ResearchersQuestionPanel panel = builder.buildMCQuestionPanel("Question", "MC", "Variable", "Option1,Option2,Option3", "Option1");

    }


}
