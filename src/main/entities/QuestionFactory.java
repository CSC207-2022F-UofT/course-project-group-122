package entities;

public class QuestionFactory implements QuestionFactoryInterface{
    public Question create(String type,int questionnaireID, String description, String content){
        switch (type){
            case "Multiple Choice" : return new MultipleChoiceQuestion(questionnaireID, description, content);
            case "Scale" : return new ScaleQuestion(questionnaireID, description, content);
            case "Text" : return new TextQuestion(questionnaireID, description, content);
        }
        return null;
    }
}
