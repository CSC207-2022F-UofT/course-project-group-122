import java.util.ArrayList;

public class MultipleChoiceQuestion extends Question{
    private ArrayList<String> choices_list;
    private int num_choices;

    public MultipleChoiceQuestion(String id, String type) {
        super(id, type);
        this.num_choices = 0;
        this.choices_list = new ArrayList<String>();
        super.question_type = "multiple choice";
    }

    @Override
    public boolean set_question_id(String s) {
        super.question_id = s;
        return true;
    }

    @Override
    public String get_question_id() {
        return this.question_id;
    }

    @Override
    public boolean set_question_description(String s) {
        super.question_description = s;
        return true;
    }

    @Override
    public String get_question_description() {
        return this.question_description;
    }

    @Override
    public boolean set_answer_content(String s) {
        this.answer_content = s;
        return true;
    }

    @Override
    public String get_answer_content() {
        return this.answer_content;
    }

    @Override
    public String get_question_type() {
        return this.question_type;
    }

    public boolean set_num_choices(int num) {
        this.num_choices = num;
        return true;
    }

    public int get_num_choices() {
        return this.num_choices;
    }

    public boolean add_choices(ArrayList<String> choices_list) {
        this.choices_list.addAll(choices_list);
        return true;
    }

    public ArrayList<String> get_choices_list() {
        return this.choices_list;
    }

    public String get_nth_choice(int n) {
        if(this.choices_list.size() >= n) {
            return this.choices_list.get(n-1);
        }
        return "There is no n-th choice.";
    }

    public boolean remove_nth_choice(int n) {
        if(this.choices_list.size() >= n) {
            this.choices_list.remove(n-1);
            return true;
        }
        return false;
    }

    public boolean set_choices_order(ArrayList<Integer> new_order) {
        //new_order is an arraylist containing integers in [1, size] with no repetition.
        if(new_order.size() == this.choices_list.size()) {
            ArrayList<String> new_choices_list = new ArrayList<>();
            for(int n: new_order) {
                new_choices_list.add(this.choices_list.get(n-1));
            }
            this.choices_list = new_choices_list;
            return true;
        }
        return false;
    }

    public String toString() {
        return "Description: " + this.question_description + "\n" + "Choices: " + this.choices_list.toString() + "\n"
                + "Answer content: " + this.answer_content;
    }
}
