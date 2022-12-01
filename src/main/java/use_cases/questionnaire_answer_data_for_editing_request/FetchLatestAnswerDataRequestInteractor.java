package use_cases.questionnaire_answer_data_for_editing_request;

import entities.*;
import org.jetbrains.annotations.NotNull;
import use_cases.fetch_id.FetchId;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FetchLatestAnswerDataRequestInteractor implements FetchLatestAnswerDataRequestInputBoundary {
    FetchLatestAnswerDataRequestOutputBoundary presenter;
    @Override
    public void fetchLatestAnswerDataRequest(int researcherId, int studyId, int participantId, int questionnaireID) {
        try{
            Participant participant = (Participant) FetchId.getUser(participantId);
            Questionnaire questionnaire = FetchId.getQuestionnaire(questionnaireID, studyId);
            Answer answer = participant.getQuestionnaireAnswer(questionnaire);
            if (answer == null) {
                presenter.presentQuestionnaireNotAnswered("Questionnaire has not been answered yet");
            } else {

                VersionedAnswer currVersionedAnswer = answer.getCurrentVersion();
                assert questionnaire != null;
                List<Question> questionList = questionnaire.getListOfQuestion();
                Map<String, String> variableAnswer = currVersionedAnswer.getAnswer();
                Map<String, String[]> answerData = createAnswerData(questionList, variableAnswer);
                ResearcherEditQuestionnaireScreenAnswersInputData data =
                        new ResearcherEditQuestionnaireScreenAnswersInputData(
                                researcherId,
                                studyId,
                                questionnaireID,
                                questionnaire.getTitle(),
                                questionnaire.getDescription(),
                                answerData);
                presenter.presentLatestAnswerDataRequest(data);
            }
        } catch (Exception e) {
            presenter.presentQuestionnaireNotAnswered(e.getMessage());
        }

    }

    @NotNull
    private static Map<String, String[]> createAnswerData(@NotNull List<Question> questionList, Map<String, String> variableAnswer) {
        Map<String, String[]> answerData = new HashMap<>();
        for (Question question : questionList) {
            String variable = question.getVariableName();
            String answerText = variableAnswer.get(variable);
            String[] answerDataArray = {question.getQuestionType(), question.getVariableName(), question.getAnswerChoices(), answerText};
            answerData.put(question.getContent(), answerDataArray);
        }
        return answerData;
    }

    public void setPresenter(FetchLatestAnswerDataRequestOutputBoundary presenter) {
        this.presenter = presenter;
    }
}
