package use_cases.answer_questionnaire;

import entities.*;
import org.jetbrains.annotations.NotNull;
import use_cases.fetch_id.FetchId;

import java.util.Map;

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
        if (questionnaire == null || participant == null || study == null) {
            answerQuestionnairePresenter.presentAnswerQuestionnaireFailure("There was an error answering the questionnaire.");
        } else if (! checkAnswers(questionnaire, answers, numQuestions)) {
            answerQuestionnairePresenter.presentAnswerQuestionnaireFailure("The answers were not valid.");
        } else {
            Answer newAnswer = new Answer(participant, questionnaire);
            VersionedAnswer newVersionedAnswer = new VersionedAnswer(1, modifier, answers, newAnswer);
            newAnswer.addNewVersion(newVersionedAnswer);
            participant.addAnswer(newAnswer, questionnaire);
            participant.completeQuestionnaire(questionnaire);
            String time  = newVersionedAnswer.getTimeOfModification();
            answerQuestionnairePresenter.presentAnswerQuestionnaireSuccess(participantId, modifierId,
                    questionnaireId, time);
        }
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
