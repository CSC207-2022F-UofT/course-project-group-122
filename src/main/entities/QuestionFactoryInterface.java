package entities;

public interface QuestionFactoryInterface {
    Question create(String type, int questionnaireID, String description, String content);


}
