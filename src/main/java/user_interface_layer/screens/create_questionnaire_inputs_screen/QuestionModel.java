package user_interface_layer.screens.create_questionnaire_inputs_screen;

import java.util.ArrayList;
import java.util.List;

/**
 * The data structure class for a question.
 */
public class QuestionModel {
    /**
     * The type of the question.
     */
    private final String type;
    /**
     * The content of the question.
     */
    private final String content;
    /**
     * The variable of the question.
     */
    private final String variable;

    /**
     * The list of choices if the question is a multiple choice question.
     */
    private List<String> mcOptions = new ArrayList<>();

    /**
     * The bottom label for the scale question.
     */
    private String bottomLabel = "";
    /**
     * The top label for the scale question.
     */
    private String topLabel = "";
    /**
     * The scale for the scale question.
     */
    private int scale = 0;

    /**
     * The constructor of a text question model.
     * @param content The content of the question.
     * @param variable The variable of the question.
     */
    public QuestionModel(String content, String variable){
        this.type = "Text";
        this.content = content;
        this.variable = variable;
    }

    /**
     * The constructor of a multiple choice question model.
     * @param content The content of the question.
     * @param variable The variable of the question.
     * @param mcOptions The list of choices for a multiple choice question.
     */
    public QuestionModel(String content, String variable, List<String> mcOptions){
        this.type = "MC";
        this.content = content;
        this.variable = variable;
        this.mcOptions = mcOptions;
    }

    /**
     * The constructor of a scale question model.
     * @param content The content of the question.
     * @param variable The variable of the question.
     * @param bottomLabel The bottom label for the scale question.
     * @param topLabel The top label for the scale question.
     * @param scale The scale for the scale question.
     */
    public QuestionModel(String content, String variable, String bottomLabel, String topLabel, int scale){
        this.type = "Scale";
        this.content = content;
        this.variable = variable;
        this.bottomLabel = bottomLabel;
        this.topLabel = topLabel;
        this.scale = scale;
    }

    /**
     * @return The type of the question.
     */
    public String getType() {
        return type;
    }

    /**
     * @return The content of the question.
     */
    public String getContent() {
        return content;
    }

    /**
     * @return The variable of the question.
     */
    public String getVariable() {
        return variable;
    }

    /**
     * @return The list of choices for a multiple choice question.
     */
    public String getOptions() {
        switch (type) {
            case "MC":
                StringBuilder options = new StringBuilder();
                for (int i = 0; i < mcOptions.size(); i++) {
                    options.append(mcOptions.get(i));
                    if (i != mcOptions.size() - 1) {
                        options.append(",");
                    }
                }
                return options.toString();
            case "Scale":
                return bottomLabel +"," + topLabel + ","+ scale;
            case "Text":
                return "Free Text Entry";
            default:
                return "";
        }
    }
}
