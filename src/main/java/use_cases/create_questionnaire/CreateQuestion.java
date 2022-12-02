package use_cases.create_questionnaire;

import entities.*;
import org.jetbrains.annotations.NotNull;
import user_interface_layer.screens.create_questionnaire_inputs_screen.QuestionModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A helper class for the create questionnaire use case.
 */
public class CreateQuestion {

    /**
     * @param questionnaire The questionnaire to add the questions to.
     * @param questionData The data for the questions to be createdd and added.
     */
    public static void createQuestion(Questionnaire questionnaire, @NotNull QuestionModel questionData) {
        String type = questionData.getType();
        Question question =
                QuestionFactoryInterface.create(
                        type,
                        questionnaire,
                        questionData.getVariable(),
                        questionData.getContent());
        if (type.equals("MC")) {
            List<String> options = List.of(questionData.getOptions().split(","));
            for (String singleOption : options) {
                assert question != null;
                ((MultipleChoiceQuestion) question).addChoice(singleOption);
                System.out.println(singleOption);

            }

        } else if (type.equals("Scale")) {
            List<String> options = List.of(questionData.getOptions().split(","));
            assert question != null;
            ((ScaleQuestion) question).setBottomLabel(options.get(0));
            ((ScaleQuestion) question).setTopLabel(options.get(1));
            ((ScaleQuestion) question).modifyScaleRange(Integer.parseInt(options.get(2)));
            System.out.println(options.get(2));

        }
        assert question != null;
        questionnaire.addQuestion(question);
    }
}
