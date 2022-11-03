package entities;

public class Question {
    protected static int currID = 0;
    private int id;
    private int questionnaireID;
    private String description;
    private String content;

    public Question(int questionnaireID, String description, String content){
        currID++;
        this.id = currID;
        this.questionnaireID = questionnaireID;
        this.description = description;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public int getQuestionnaireID() {
        return questionnaireID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
