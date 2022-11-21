package user_interface_layer;

import java.util.ArrayList;
import java.util.List;

public class QuestionModel {
    private String type;
    private String question;
    private String variable;

    private List<String> MCoptions = new ArrayList<>();

    private String bottomLabel = "";
    private String topLabel = "";
    private int scale = 0;

    public QuestionModel(String question, String variable){
        this.type = "Text";
        this.question = question;
        this.variable = variable;
    }
    public QuestionModel(String question, String variable, List<String> MCoptions){
        this.type = "MC";
        this.question = question;
        this.variable = variable;
        this.MCoptions = MCoptions;
    }

    public QuestionModel(String question, String variable, String bottomLabel, String topLabel, int scale){
        this.type = "Scale";
        this.question = question;
        this.variable = variable;
        this.bottomLabel = bottomLabel;
        this.topLabel = topLabel;
        this.scale = scale;
    }

    public String getType() {
        return type;
    }

    public String getQuestion() {
        return question;
    }

    public String getVariable() {
        return variable;
    }

    public String getAnswer() {
        switch (type) {
            case "MC":
                return MCoptions.toString();
            case "Scale":
                return bottomLabel +", " + scale+ ", "+ topLabel;
            case "Text":
                return "";
        }
        return "";
    }


}
