import java.util.ArrayList;

public class TextQuestion extends Question{
    public TextQuestion(String id, String type) {
        super(id, type);
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

    public String toString() {
        return "Description: " + this.question_description + "\n" + "Answer content: " + this.answer_content;
    }
}
