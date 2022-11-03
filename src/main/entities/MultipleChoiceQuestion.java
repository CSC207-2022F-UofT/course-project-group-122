package entities;

import java.util.ArrayList;
import java.util.List;

public class MultipleChoiceQuestion extends Question {

    private int numOfChoices;
    private List<String> choices;


    public MultipleChoiceQuestion(int questionnaireID, String description, String content) {
        super(questionnaireID, description, content);
        this.numOfChoices = 0;
        this.choices = new ArrayList<>();
    }


    private boolean isInChoices(int index) {
        return index >= 0 && index < this.choices.size();
    }

    public boolean addChoice(String choice){
        this.numOfChoices ++;
        this.choices.add(choice);
        return true;
    }

    public boolean removeChoice(String choice){
        if (this.choices.contains(choice)){
            this.choices.remove(choice);
            numOfChoices--;
            return true;
        }
        return false;

    }
    public boolean removeChoice(int index){
        if (this.isInChoices(index)){
            this.choices.remove(index);
            numOfChoices--;
            return true;
        }
        return false;
    }

    public boolean rearrangeChoices(int indexToArrange, int index){
        if (this.isInChoices(indexToArrange) && this.isInChoices(index)){
            String holdChoice = this.choices.remove(indexToArrange);
            this.choices.add(index,holdChoice);
            return true;
        }
        return false;
    }

    public boolean modifyChoice(int index, String newChoice){
        if (this.isInChoices(index)){
            this.choices.set(index, newChoice);
            return true;
        }
        return false;

    }


    public int getNumOfChoices() {
        return numOfChoices;
    }

    public List<String> getChoices() {
        return choices;
    }
}
