package user_interface_layer.screens.create_questionnaire_inputs_screen;

import java.util.ArrayList;
import java.util.List;

public class QuestionModel {
    private String type;
    private String content;
    private String variable;

    private List<String> MCoptions = new ArrayList<>();

    private String bottomLabel = "";
    private String topLabel = "";
    private int scale = 0;

    public QuestionModel(String content, String variable){
        this.type = "Text";
        this.content = content;
        this.variable = variable;
    }
    public QuestionModel(String content, String variable, List<String> MCoptions){
        this.type = "MC";
        this.content = content;
        this.variable = variable;
        this.MCoptions = MCoptions;
    }

    public QuestionModel(String content, String variable, String bottomLabel, String topLabel, int scale){
        this.type = "Scale";
        this.content = content;
        this.variable = variable;
        this.bottomLabel = bottomLabel;
        this.topLabel = topLabel;
        this.scale = scale;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public String getVariable() {
        return variable;
    }

    public String getOptions() {
        switch (type) {
            case "MC":
                return MCoptions.toString().replace(", ", ",");
            case "Scale":
                return bottomLabel +"," + topLabel + ","+ scale;
            case "Text":
                return "";
        }
        return "";
    }


}
