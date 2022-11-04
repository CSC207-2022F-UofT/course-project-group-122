package entities;

/**
 * A subclass of Question that allows Users to answer a Question by inputting a text/short answer.
 */
public class TextQuestion extends Question {
    /**
     * The Constructor of the TextQuestion class.
     *
     * @param questionnaireID
     * @param description
     * @param content
     */
    public TextQuestion(int questionnaireID, String description, String content) {
        super(questionnaireID, description, content);
    }
}

