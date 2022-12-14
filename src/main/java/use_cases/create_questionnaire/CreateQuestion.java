package use_cases.create_questionnaire;

import entities.*;
import org.jetbrains.annotations.NotNull;
import user_interface_layer.screens.create_questionnaire_inputs_screen.QuestionModel;

import java.util.List;

/**
 * A helper class for the creation questionnaire use case.
 */
public class CreateQuestion {

    /**
     * @param questionnaire The questionnaire to add the questions to.
     * @param questionData The data for the questions to be createdd and added.
     */
    public static void createQuestion(int newId, Questionnaire questionnaire, @NotNull QuestionModel questionData) {
        String type = questionData.getType();
        Question question =
                QuestionFactory.create(
                        newId,
                        type,
                        questionnaire,
                        questionData.getVariable(),
                        questionData.getContent());
        if (type.equals("MC")) {
            List<String> options = List.of(questionData.getOptions().split(","));
            for (String singleOption : options) {
                assert question != null;
                ((MultipleChoiceQuestion) question).addChoice(singleOption);
            }

        } else if (type.equals("Scale")) {
            List<String> options = List.of(questionData.getOptions().split(","));
            assert question != null;
            ((ScaleQuestion) question).setBottomLabel(options.get(0));
            ((ScaleQuestion) question).setTopLabel(options.get(1));
            ((ScaleQuestion) question).modifyScaleRange(Integer.parseInt(options.get(2)));

        }
        assert question != null;
        questionnaire.addQuestion(question);
    }
}
