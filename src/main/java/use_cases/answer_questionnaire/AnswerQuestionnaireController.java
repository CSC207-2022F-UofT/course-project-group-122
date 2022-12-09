package use_cases.answer_questionnaire;

import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * This the controller that the button that submits the questionnaire answers calls on, through the controller manager.
 */
public class AnswerQuestionnaireController {
    /**
     * The interface that the use case implements and is called on by the controller.
     */
    private AnswerQuestionnaireInputBoundary answerQuestionnaireInteractor;

    /**
     * Constant that indicates that the questionnaire is an eligibility questionnaire.
     */
    public static final String ELIGIBILITY_QUESTIONNAIRE = "Eligibility Questionnaire";

    /**
     * Constant that indicates that the questionnaire is a normal questionnaire.
     */
    public static final String QUESTIONNAIRE = "Questionnaire";

    /**
     * This method calls on the use case that creates and submits the questionnaire answers.
     *
     * @param answerQuestionnaireRequestModel The request model that contains the data needed to create and submit the
     *                                        questionnaire answers.
     * @param questionnaireType               The type of the questionnaire that the participant is answering.
     */
    public void answerQuestionnaire(@NotNull AnswerQuestionnaireRequestModel answerQuestionnaireRequestModel,
                                    @NotNull String questionnaireType) {
        int questionnaireId = answerQuestionnaireRequestModel.getQuestionnaireId();
        int participantId = answerQuestionnaireRequestModel.getParticipantId();
        int modifierId = answerQuestionnaireRequestModel.getModifierId();
        int studyId = answerQuestionnaireRequestModel.getStudyId();
        Map<String, String> answers = answerQuestionnaireRequestModel.getAnswers();
        int numQuestions = answerQuestionnaireRequestModel.getNumQuestions();
        if (questionnaireType.equals(ELIGIBILITY_QUESTIONNAIRE)) {
            answerQuestionnaireInteractor.answerEligibilityQuestionnaire(questionnaireId, participantId, modifierId,
                    studyId, answers, numQuestions);
        } else if (questionnaireType.equals(QUESTIONNAIRE)) {
            answerQuestionnaireInteractor.answerQuestionnaire(questionnaireId, participantId, modifierId, studyId,
                    answers, numQuestions);
        }
    }

    /**
     * Set the interactor for this controller.
     *
     * @param answerQuestionnaireInteractor The interactor.
     */
    public void setAnswerQuestionnaireInteractor(AnswerQuestionnaireInputBoundary answerQuestionnaireInteractor) {
        this.answerQuestionnaireInteractor = answerQuestionnaireInteractor;
    }
}
