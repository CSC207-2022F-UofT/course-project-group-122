package use_cases;

import entities.MultipleChoiceQuestion;
import entities.Question;
import entities.ScaleQuestion;
import org.jetbrains.annotations.NotNull;
import user_interface_layer.screens.create_questionnaire_inputs_screen.QuestionModel;

import java.util.ArrayList;
import java.util.List;

public class GetQuestionsModel {
    @NotNull
    public static List<QuestionModel> getQuestionsModelForScreen(List<Question> questions) {
        List<QuestionModel> questionsModel = new ArrayList<>();
        for (Question question : questions) {
            String type = question.getQuestionType();
            switch (type) {
                case "MC":
                    List<String> mcOptions = ((MultipleChoiceQuestion) question).getChoices();
                    String content = question.getContent();
                    String variable = question.getVariableName();
                    QuestionModel mcQuestionModel = new QuestionModel(content, variable, mcOptions);
                    questionsModel.add(mcQuestionModel);
                    break;
                case "Scale":
                    String bottomLabel = ((ScaleQuestion) question).getBottomLabel();
                    String topLabel = ((ScaleQuestion) question).getTopLabel();
                    int scale = ((ScaleQuestion) question).getScaleRange();
                    content = question.getContent();
                    variable = question.getVariableName();
                    QuestionModel scaleQuestionModel = new QuestionModel(content, variable, bottomLabel, topLabel, scale);
                    questionsModel.add(scaleQuestionModel);
                    break;
                case "Text":
                    content = question.getContent();
                    variable = question.getVariableName();
                    QuestionModel textQuestionModel = new QuestionModel(content, variable);
                    questionsModel.add(textQuestionModel);
                    break;
            }
        }
        return questionsModel;
    }
}
