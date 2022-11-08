public abstract class Question {
    protected String question_id;
    protected String question_type;
    protected String question_description;
    protected String answer_content;

    public Question(String id, String type) {
        this.question_id = id;
        this.question_type = type;
        this.question_description = "just created, no description!";
        this.answer_content = "just created, no answer!";
    }

    public abstract boolean set_question_id(String s);
    public abstract String get_question_id();

    public abstract boolean set_question_description(String s);
    public abstract String get_question_description();
    public abstract boolean set_answer_content(String s);
    public abstract String get_answer_content();
    public abstract String get_question_type();
}
