package use_cases.fetch_versioned_answer;

import entities.Answer;
import entities.Question;
import entities.Questionnaire;
import entities.VersionedAnswer;
import org.jetbrains.annotations.NotNull;
import use_cases.fetch_id.FetchId;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This is the use case that fetches the versioned answer of a participant.
 */
public class FetchVersionedAnswerInteractor implements FetchVersionedAnswerInputBoundary {
    /**
     * The interface that the presenter implements.
     */
    FetchVersionedAnswerOutBoundary fetchVersionedAnswerOutBoundary;

    /**
     * This is the method that fetches the versioned answer of a participant.
     * @param studyId         The study ID.
     * @param participantId   The participant ID.
     * @param questionnaireID The questionnaire ID.
     * @param answerID        The answer ID.
     * @param version         The version of the answer.
     */
    @Override
    public void fetchVersionedAnswer(int studyId, int participantId, int questionnaireID, int answerID, int version) {
        try {
            Answer answer = FetchId.getAnswer(answerID, participantId);
            if (answer == null) {
                throw new Exception("Answer does not exist");
            }
            Questionnaire questionnaire = FetchId.getQuestionnaire(questionnaireID, studyId);
            assert questionnaire != null;
            List<Question> questions = questionnaire.getListOfQuestion();
            List<VersionedAnswer> versionedAnswers = answer.getAllVersions();
            if (versionedAnswers.size() == 0) {
                throw new Exception("Version does not exist");
            }
            List<String[]> versionedAnswersList = formattedVersionAnswers(version, questions, versionedAnswers);
            FetchVersionedAnswerResponseModel data = new FetchVersionedAnswerResponseModel(studyId, questionnaireID, versionedAnswersList);
            fetchVersionedAnswerOutBoundary.presentVersionedAnswer(data);
        }catch (Exception e){
            fetchVersionedAnswerOutBoundary.presentFailedScreen(e.getMessage());
        }

    }

    /**
     * A helper method that formats the versioned answers.
     * @param version        The version of the answer.
     * @param questions     The list of questions.
     * @param versionedAnswers The list of versioned answers.
     * @return The list of versioned answers.
     */
    @NotNull
    private static List<String[]> formattedVersionAnswers(int version,
                                                          List<Question> questions,
                                                          List<VersionedAnswer> versionedAnswers) {
        List<String[]> versionedAnswersList = new ArrayList<>();
        for (VersionedAnswer versionedAnswer : versionedAnswers) {
            if (versionedAnswer.getVersion() == version) {
                Map<String, String> answers = versionedAnswer.getAnswer();
                for (Question question : questions) {
                    String questionContent = question.getContent();
                    String variable = question.getVariableName();
                    String answerString = answers.get(variable);
                    String[] questionAnswer = {questionContent, answerString};
                    versionedAnswersList.add(questionAnswer);
                }
            }
        }
        return versionedAnswersList;
    }

    /**
     * Sets the presenter.
     * @param fetchVersionedAnswerOutBoundary The interface that the presenter implements.
     */
    public void setFetchVersionedAnswerOutBoundary(FetchVersionedAnswerOutBoundary fetchVersionedAnswerOutBoundary) {
        this.fetchVersionedAnswerOutBoundary = fetchVersionedAnswerOutBoundary;
    }
}
