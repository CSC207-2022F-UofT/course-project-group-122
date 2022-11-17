package UserInterfaceLayer.screens.ParticipantAnswerQuestionnairePanel.QuestionsPanel;

import javax.swing.*;
import java.util.List;

public class QuestionsPanelBuilder {
    public QuestionsPanelBuilder() {
    }
    public ParticipantsQuestionPanel buildMCQuestionPanel(String question, String type, String variable, String options){
        String[] optionsList = options.split(",");
        return new MCQuestionPanel(question, type, variable, optionsList);

    }
    public ParticipantsQuestionPanel buildScaleQuestionPanel(String question, String type, String variable, String options){
        String[] optionsList= options.split(",");
        String bottomLabel = optionsList[0];
        String topLabel = optionsList[1];
        int scale = Integer.parseInt(optionsList[2]);
        return new ScaleQuestionPanel(question, type, variable, bottomLabel, topLabel, scale);
    }

    public ParticipantsQuestionPanel buildTextQuestionPanel(String question, String type, String variable, String options){
        return new TextQuestionPanel(question, type, variable, options);


    }


}
