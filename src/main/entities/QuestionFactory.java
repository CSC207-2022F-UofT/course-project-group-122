package entities;

/**
 * A QuestionFactory that creates and returns Question objects.
 */
public class QuestionFactory implements QuestionFactoryInterface {

    /**
     * The create method that gets called with a specified type of Question when creating a Question object.
     * Precondition : type is a valid Question type.
     *
     * @param type
     * @param questionnaireID
     * @param description
     * @param content
     * @return
     */
    public Question create(String type, int questionnaireID, String description, String content) {
        switch (type) {
            case "Multiple Choice":
                return new MultipleChoiceQuestion(questionnaireID, description, content);
            case "Scale":
                return new ScaleQuestion(questionnaireID, description, content);
            case "Text":
                return new TextQuestion(questionnaireID, description, content);
        }
        return null;
    }
}
