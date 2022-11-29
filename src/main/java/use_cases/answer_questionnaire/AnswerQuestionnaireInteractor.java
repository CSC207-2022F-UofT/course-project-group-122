package use_cases.answer_questionnaire;

import entities.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import use_cases.fetch_id.FetchId;

import java.util.Map;
import java.util.Objects;

public class AnswerQuestionnaireInteractor implements AnswerQuestionnaireInputBoundary {

    private AnswerQuestionnaireOutputBoundary answerQuestionnairePresenter;


    /**
     * Answer a questionnaire.
     *
     * @param questionnaireId The questionnaire ID.
     * @param participantId   The participant ID.
     * @param modifierId      The modifier ID.
     * @param studyId         The study ID.
     * @param answers         A map of variable names to answers
     * @param numQuestions    The number of questions in the questionnaire.
     */
    @Override
    public void answerQuestionnaire(int questionnaireId, int participantId, int modifierId, int studyId,
                                    Map<String, String> answers, int numQuestions) {
        Questionnaire questionnaire = FetchId.getQuestionnaire(questionnaireId, studyId);
        User modifier = FetchId.getUser(modifierId);
        Participant participant = (Participant) FetchId.getUser(participantId);
        Study study = FetchId.getStudy(studyId);
        assert questionnaire != study.getEligibilityQuestionnaire();
        Answer newAnswer = answer(questionnaire, participant, modifier, study, answers, numQuestions);
        assert newAnswer != null;
        assert questionnaire != null;
        participant.addAnswer(newAnswer, questionnaire);
        VersionedAnswer newVersionedAnswer = newAnswer.getCurrentVersion();
        participant.completeQuestionnaire(questionnaire);
        String time  = newVersionedAnswer.getTimeOfModification();
        answerQuestionnairePresenter.presentAnswerQuestionnaireSuccess(participantId, modifierId,
                questionnaireId, time);

    }


    /**
     * Answer an eligibility questionnaire.
     * @param questionnaireId   The questionnaire ID.
     * @param participantId     The participant ID.
     * @param modifierId        The modifier ID.
     * @param studyId           The study ID.
     * @param answers           A map of variable names to answers
     * @param numQuestions      The number of questions in the questionnaire.
     */
    public void answerEligibilityQuestionnaire(int questionnaireId, int participantId, int modifierId, int studyId,
                                               Map<String, String> answers, int numQuestions) {
        Questionnaire questionnaire = FetchId.getQuestionnaire(questionnaireId, studyId);
        User modifier = FetchId.getUser(modifierId);
        Participant participant = (Participant) FetchId.getUser(participantId);
        Study study = FetchId.getStudy(studyId);
        assert Objects.equals(questionnaire, study.getEligibilityQuestionnaire());
        Answer newAnswer = answer(questionnaire, participant, modifier, study, answers, numQuestions);
        assert newAnswer != null;
        VersionedAnswer newVersionedAnswer = newAnswer.getCurrentVersion();
        participant.setEligibilityQuestionnaireAnswer(newAnswer);
        String time  = newVersionedAnswer.getTimeOfModification();
        answerQuestionnairePresenter.presentAnswerQuestionnaireSuccess(participantId, modifierId,
                questionnaireId, time);
    }


    /**
     * Answer a questionnaire. Creates a new version of the answer and returns the answer object
     * @param questionnaire     The questionnaire
     * @param participant       The participant
     * @param user              The modifier
     * @param study             The study
     * @param answers           A map of variable names to answers
     * @param numQuestions      The number of questions in the questionnaire.
     * @return                  The answer object.
     */
    private @Nullable Answer answer(Questionnaire questionnaire, Participant participant, User user, Study study,
                                    Map<String, String> answers, int numQuestions) {
        if (questionnaire == null || participant == null || study == null) {
            answerQuestionnairePresenter.presentAnswerQuestionnaireFailure("There was an error answering the questionnaire.");
        } else if (questionnaire.isClosed()) {
            answerQuestionnairePresenter.presentAnswerQuestionnaireFailure("The questionnaire is closed.");
        } else if (! checkAnswers(questionnaire, answers, numQuestions)) {
            answerQuestionnairePresenter.presentAnswerQuestionnaireFailure("The answers were not valid.");
        } else {
            Answer newAnswer = new Answer(participant, questionnaire);
            VersionedAnswer newVersionedAnswer = new VersionedAnswer(1, user, answers, newAnswer);
            newAnswer.addNewVersion(newVersionedAnswer);
            return newAnswer;
        }
        return null;
    }


    /**
     * Check that the answers are valid.
     * @param questionnaire The questionnaire.
     * @param answers       A map of variable names to answers
     * @param numQuestions  The number of questions in the questionnaire.
     * @return              True if the answers are valid, false otherwise.
     */
    private boolean checkAnswers(@NotNull Questionnaire questionnaire, Map<String, String> answers, int numQuestions) {
        if (questionnaire.getNumOfQuestions() != numQuestions) {
            return false;
        }
        for (String variableName : answers.keySet()) {
            if (!questionnaire.getVariableNames().contains(variableName)) {
                return false;
            }
        }
        return true;
    }


    /**
     * Set the presenter for this interactor.
     * @param answerQuestionnairePresenter The presenter.
     */
    public void setAnswerQuestionnairePresenter(AnswerQuestionnaireOutputBoundary answerQuestionnairePresenter) {
        this.answerQuestionnairePresenter = answerQuestionnairePresenter;
    }


}
