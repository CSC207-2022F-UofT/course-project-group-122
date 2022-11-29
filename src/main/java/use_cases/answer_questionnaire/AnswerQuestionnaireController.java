package use_cases.answer_questionnaire;

import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class AnswerQuestionnaireController {

    private AnswerQuestionnaireInputBoundary answerQuestionnaireInteractor;

    public static final String ELIGIBILITY_QUESTIONNAIRE = "Eligibility Questionnaire";

    public static final String QUESTIONNAIRE = "Questionnaire";


    public void answerQuestionnaire(@NotNull AnswerQuestionnaireRequestModel answerQuestionnaireRequestModel, @NotNull String type) {
        int questionnaireId = answerQuestionnaireRequestModel.getQuestionnaireId();
        int participantId = answerQuestionnaireRequestModel.getParticipantId();
        int modifierId = answerQuestionnaireRequestModel.getModifierId();
        int studyId = answerQuestionnaireRequestModel.getStudyId();
        Map<String, String> answers = answerQuestionnaireRequestModel.getAnswers();
        int numQuestions = answerQuestionnaireRequestModel.getNumQuestions();
        if (type.equals(ELIGIBILITY_QUESTIONNAIRE)) {
            answerQuestionnaireInteractor.answerEligibilityQuestionnaire(questionnaireId, participantId, modifierId,
                    studyId, answers, numQuestions);
        } else if (type.equals(QUESTIONNAIRE)) {
            answerQuestionnaireInteractor.answerQuestionnaire(questionnaireId, participantId, modifierId, studyId,
                    answers, numQuestions);
        }
    }


    /**
     * Set the interactor for this controller.
     * @param answerQuestionnaireInteractor The interactor.
     */
    public void setAnswerQuestionnaireInteractor(AnswerQuestionnaireInputBoundary answerQuestionnaireInteractor) {
        this.answerQuestionnaireInteractor = answerQuestionnaireInteractor;
    }
}
