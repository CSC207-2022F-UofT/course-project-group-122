package entities;

public interface QuestionFactoryInterface{


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
    Question create(String type, Questionnaire questionnaire, String variableName, String content);


}
