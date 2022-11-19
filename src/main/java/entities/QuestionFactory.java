package entities;

import org.jetbrains.annotations.NotNull;

/**
 * A QuestionFactory that creates and returns Question objects.
 */
public class QuestionFactory implements QuestionFactoryInterface, java.io.Serializable{

    /**
     * The create method that gets called with a specified type of Question when creating a Question object.
     * Precondition : type is a valid Question type.
     *
     * @param type              The type of Question to be created.
     * @param questionnaire     The Questionnaire that the Question belongs to.
     * @param variableName      The variable name of the Question.
     * @param content           The content of the Question.
     * @return                  The Question object that was created.
     */
    public Question create(@NotNull String type, Questionnaire questionnaire, String variableName, String content) {
        switch (type) {
            case "MCQ":
                return new MultipleChoiceQuestion(questionnaire, variableName, content);
            case "Scale":
                return new ScaleQuestion(questionnaire, variableName, content);
            case "Text":
                return new TextQuestion(questionnaire, variableName, content);
        }
        return null;
    }
}
