package use_cases.questionnaire_screen_data_request.questionnaire_screen_data_request;

import entities.Question;
import entities.Questionnaire;
import use_cases.fetch_id.FetchId;
import use_cases.questionnaire_screen_data_request.CheckQuestionnaireInputData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FetchQuestionnaireScreenInteractor implements FetchQuestionnaireScreenInputBoundary {
    FetchQuestionnaireScreenPresenter presenter;

    @Override
    public void fetchQuestionnaireData(int researchId, int studyId, int questionnaireId) {
        Questionnaire questionnaire = FetchId.getQuestionnaire(questionnaireId, studyId);
        if (questionnaire == null) {
            FetchQuestionnaireScreenPresenter presenter = new FetchQuestionnaireScreenPresenter();
            presenter.presentQuestionnaireScreenDataFailure("Questionnaire not found");
        } else {
            String questionnaireName = questionnaire.getTitle();
            String questionnaireDescription = questionnaire.getDescription();
            Map<String, String[]> InputData = new HashMap<>();
            List<Question> question = questionnaire.getListOfQuestion();
            for (Question q : question) {
                String[] formattedQuestion = new String[]{q.getQuestionType(), q.getContent(), q.getAnswerChoices()};
                InputData.put(q.getVariableName(), formattedQuestion);
            }
            use_cases.questionnaire_screen_data_request.CheckQuestionnaireInputData data = new CheckQuestionnaireInputData(questionnaireId,
                    questionnaireName, questionnaireDescription, InputData);
            presenter.presentQuestionnaireScreenData(data);
        }
    }

    public void setPresenter(FetchQuestionnaireScreenPresenter presenter) {
        this.presenter = presenter;
    }
}
