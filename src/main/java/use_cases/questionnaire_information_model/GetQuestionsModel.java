package use_cases.questionnaire_information_model;

import entities.MultipleChoiceQuestion;
import entities.Question;
import entities.ScaleQuestion;
import org.jetbrains.annotations.NotNull;
import user_interface_layer.screens.create_questionnaire_inputs_screen.QuestionModel;

import java.util.ArrayList;
import java.util.List;

/**
 * The data structure class that use cases use to format questions for the screen.
 */
public class GetQuestionsModel {
    /**
     * The method that formats the questions for the screen.
     * @param questions The list of questions in the questionnaire.
     * @return The list of questions in the questionnaire in the format that the screen can use.
     */
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
