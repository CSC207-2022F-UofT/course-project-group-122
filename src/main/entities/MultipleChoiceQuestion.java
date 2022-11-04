package entities;

import java.util.ArrayList;
import java.util.List;

/**
 * A subclass of Question that allows User to answer a Question by choosing one of the specified choices.
 */
public class MultipleChoiceQuestion extends Question {

    /**
     * The number of choices for this MultipleChoiceQuestion.
     */
    private int numOfChoices;

    /**
     * The choices for this MultipleChoiceQuestion.
     * The choices have an order to them, based on their index in the list.
     */
    private List<String> choices;


    /**
     * The constructor for the MultipleChoiceQuestion class.
     *
     * @param questionnaireID
     * @param description
     * @param content
     */
    public MultipleChoiceQuestion(int questionnaireID, String description, String content) {
        super(questionnaireID, description, content);
        this.numOfChoices = 0;
        this.choices = new ArrayList<>();
    }


    /**
     * Checks if index is in the length of the list of choices for this MultipleChoiceQuestion.
     *
     * @param index
     * @return true if the index is in the length of the list of choices.
     */
    private boolean isInChoices(int index) {
        return index >= 0 && index < this.choices.size();
    }

    /**
     * Adds a choice into the list of choices for this MultipleChoiceQuestion.
     *
     * @param choice
     * @return true if choice was successfully added into the list of choices.
     */
    public boolean addChoice(String choice) {
        this.numOfChoices++;
        this.choices.add(choice);
        return true;
    }

    /**
     * Removes a choice from the list of choices for this MultipleChoiceQuestion.
     * This method is overloaded.
     *
     * @param choice
     * @return true if choice was successfully removed from the list of choices.
     */
    public boolean removeChoice(String choice) {
        if (this.choices.contains(choice)) {
            this.choices.remove(choice);
            numOfChoices--;
            return true;
        }
        return false;

    }

    /**
     * Removes the choice at index index from the list of choices for this MultipleChoiceQuestion.
     * This method is overloaded.
     *
     * @param index
     * @return true if choice at index was successfully removed from the list of choices.
     */
    public boolean removeChoice(int index) {
        if (this.isInChoices(index)) {
            this.choices.remove(index);
            numOfChoices--;
            return true;
        }
        return false;
    }

    /**
     * Rearrange the list of choices so that the choice at index  indexToArranged is inserted in index.
     *
     * @param indexToArrange
     * @param index
     * @return true if choice at index indexToArranged was successfully inserted at index.
     */
    public boolean rearrangeChoices(int indexToArrange, int index) {
        if (this.isInChoices(indexToArrange) && this.isInChoices(index)) {
            String holdChoice = this.choices.remove(indexToArrange);
            this.choices.add(index, holdChoice);
            return true;
        }
        return false;
    }

    /**
     * Modify the choice in index so that the newChoice is in this index.
     *
     * @param index
     * @param newChoice
     * @return
     */
    public boolean modifyChoice(int index, String newChoice) {
        if (this.isInChoices(index)) {
            this.choices.set(index, newChoice);
            return true;
        }
        return false;

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
        return choices;
    }
}
