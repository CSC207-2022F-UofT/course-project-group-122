import java.lang.reflect.Array;
import java.util.ArrayList;

public class ScaleQuestion extends Question {
    private int scale_range; //This should be a non-negative integer.
    private String variable_name; //The short string defined by users to represent this question.
    private ArrayList<Integer> scales;

    public ScaleQuestion(String id, String type, int scale_range, String variable_name) {
        super(id, type);
        this.scale_range = scale_range;
        this.variable_name = variable_name;
        this.scales = new ArrayList<Integer>();
        for(int i = 0; i <= this.scale_range; i++) {
            this.scales.add(i);
        }
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

    public boolean set_new_scale(int new_scale_range) {
        //The scales ArrayList will also be changed according to the new_scale_range.
        if(new_scale_range >= 0) {
            this.scale_range = new_scale_range;
            ArrayList<Integer> new_scales = new ArrayList<Integer>();
            for(int i = 0; i<= new_scale_range; i++) {
                new_scales.add(i);
            }
            this.scales = new_scales;
            return true;
        }
        return false;
    }

    public int get_scale_range() {
        return this.scale_range;
    }

    public ArrayList<Integer> get_scales() {
        return this.scales;
    }


    public String toString() {
        return "Description: " + this.question_description + "\n" + "Scales: " + this.scales.toString() + "\n"
                + "Answer content: " + this.answer_content;
    }
}

