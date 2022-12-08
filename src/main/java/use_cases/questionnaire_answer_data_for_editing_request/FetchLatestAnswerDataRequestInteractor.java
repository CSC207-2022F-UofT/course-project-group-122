package use_cases.questionnaire_answer_data_for_editing_request;

import entities.*;
import org.jetbrains.annotations.NotNull;
import use_cases.fetch_id.FetchId;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is the use case that fetches the data for the participant to answer the questionnaire.
 */
public class FetchLatestAnswerDataRequestInteractor implements FetchLatestAnswerDataRequestInputBoundary {
    /**
     * The interface that the presenter implements and use case calls on to present the data.
     */
    FetchLatestAnswerDataRequestOutputBoundary presenter;

    /**
     * The method in the use case that fetches the latest answer data for the researcher to check.
     * @param researcherId    The researcher ID of the researcher that is fetching the latest answer data of a questionnaire.
     * @param studyId         The study ID of the study that the questionnaire belongs to.
     * @param participantId   The participant ID of the participant that answered the questionnaire.
     * @param questionnaireID The questionnaire ID of the questionnaire that the participant answered.
     */
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
                for (Question question : questionList) {
                    System.out.println(question.getContent() + question.getVariableName());
                }
                Map<String, String> variableAnswer = currVersionedAnswer.getAnswer();
                Map<String, String[]> answerData = createAnswerData(questionList, variableAnswer);
                for (Map.Entry<String, String[]> entry : answerData.entrySet()) {
                    System.out.println(entry.getKey() + " " + Arrays.toString(entry.getValue()));
                }
                ResearcherEditQuestionnaireScreenAnswersInputData data =
                        new ResearcherEditQuestionnaireScreenAnswersInputData(
                                researcherId,
                                participantId,
                                studyId,
                                answer.getId(),
                                questionnaire.getTitle(),
                                questionnaire.getDescription(),
                                answerData);
                presenter.presentLatestAnswerDataRequest(data);
            }
        } catch (Exception e) {
            presenter.presentQuestionnaireNotAnswered(e.getMessage());
        }

    }

    /**
     * Formats the answer data for the screen to display.
     * @param questionList  The list of questions in the questionnaire.
     * @param variableAnswer The map of variable name to answer.
     * @return The map of variable name to answer data.
     */
    @NotNull
    private static Map<String, String[]> createAnswerData(@NotNull List<Question> questionList, Map<String, String> variableAnswer) {
        Map<String, String[]> answerData = new HashMap<>();
        for (Question question : questionList) {
            String variable = question.getVariableName();
            String answerText = variableAnswer.get(variable);
            String[] answerDataArray = {question.getQuestionType(), variable, question.getAnswerChoices(), answerText};
            answerData.put(question.getContent(), answerDataArray);
            System.out.println(question.getContent() + " " + question.getQuestionType() + " " + variable + " " + question.getAnswerChoices() + " " + answerText);
        }
        return answerData;
    }

    /**
     * Sets the presenter for the use case.
     * @param presenter The presenter of the use case.
     */
    public void setPresenter(FetchLatestAnswerDataRequestOutputBoundary presenter) {
        this.presenter = presenter;
    }
}
