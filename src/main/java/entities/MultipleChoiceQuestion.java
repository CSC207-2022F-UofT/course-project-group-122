package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A subclass of Question that allows User to answer a Question by choosing one of the specified choices.
 */
public class MultipleChoiceQuestion extends Question implements Serializable {

    /**
     * The number of choices for this MultipleChoiceQuestion. The default value is 0.
     */
    private int numOfChoices = 0;

    /**
     * The choices for this MultipleChoiceQuestion.
     * The choices have an order to them, based on their index in the list.
     */
    private final List<String> choices = new ArrayList<>();


    /**
     * The constructor for the MultipleChoiceQuestion class.
     *
     * @param questionnaire     The questionnaire this question is part of.
     * @param variableName      Keyword that describes the content of this Question
     * @param content           What is being asked the participants.
     */
    public MultipleChoiceQuestion(int id, Questionnaire questionnaire, String variableName, String content) {
        super(id, questionnaire, variableName, content);
    }


    /**
     * Adds a choice into the list of choices for this MultipleChoiceQuestion.
     *
     * @param choice    The choice to be added.
     */
    public void addChoice(String choice) {
        this.numOfChoices++;
        this.choices.add(choice);
    }


    /**
     * @return The number of choices of this MultipleChoiceQuestion.
     */
    public int getNumOfChoices() {
        return numOfChoices;
    }


    /**
     * @return The choices of this MultipleChoiceQuestion.
     */
    public List<String> getChoices() {
        List<String> choicesToReturn = new ArrayList<>();
        for (int i = 0; i < this.choices.size(); i++) {
            choicesToReturn.add((i + 1)+". "+this.choices.get(i));
        }
        return choicesToReturn;
    }


    /**
     * @return The type of this Question.
     */
    @Override
    public String getQuestionType() {
        return "MC";
    }


    /**
     * @return The String representation of this Question's potential answers.
     */
    @Override
    public String getAnswerChoices() {
        StringBuilder answerChoices = new StringBuilder();
        for (int i = 0; i < this.choices.size(); i++) {
            if (i != 0) {
                answerChoices.append(",");
            }
            answerChoices.append(i + 1).append(". ").append(this.choices.get(i));
        }
        return answerChoices.toString();

    }
}
