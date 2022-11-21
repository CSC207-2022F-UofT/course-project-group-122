package use_cases.answer_questionnaire_data_request.answer_questionnaire_data_request;

import entities.Question;
import entities.Questionnaire;
import use_cases.fetch_id.FetchId;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * This is the use case that fetches the data for the participant to answer the questionnaire.
 */
public class FetchQuestionnaireDataForAnsweringInteractor implements FetchQuestionnaireDataForAnsweringInputBoundary {
    /*
     * This is the interface that the controller calls on to call on the presenter to present the data.
     */
    private FetchQuestionnaireDataForAnswerOutputBoundary presenter;

    public void fetchQuestionnaireDataForAnswering(int studyId,int participantID, int questionnaireId) {
        Questionnaire questionnaire = FetchId.getQuestionnaire(questionnaireId, studyId);
        if (questionnaire == null) {
            presenter.presentFailureScreen("Questionnaire not found");
        } else {
            String questionnaireName = questionnaire.getTitle();
            String questionnaireDescription = questionnaire.getDescription();
            List<Question> questions = questionnaire.getListOfQuestion();
            Map<String, String[]> questionsInformation = new HashMap<>();
            for (Question question : questions) {
                String questionVariable = question.getVariableName();
                String questionType = question.getQuestionType();
                String questionContent = question.getContent();
                String questionOptions = question.getAnswerChoices();
                String[] questionInformation = {questionType, questionContent, questionOptions};
                questionsInformation.put(questionVariable, questionInformation);
            }
            ParticipantAnswerQuestionnairePanelInputData data = new ParticipantAnswerQuestionnairePanelInputData(participantID, studyId, questionnaireId, questionnaireName, questionnaireDescription, questionsInformation);
            presenter.presentQuestionnaireDataForAnswering(data);
        }

    }

    public void setPresenter(FetchQuestionnaireDataForAnswerOutputBoundary presenter) {
        this.presenter = presenter;
    }
}
