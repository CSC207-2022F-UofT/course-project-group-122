package use_cases.answer_questionnaire;

import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class AnswerQuestionnaireController {

    private AnswerQuestionnaireInputBoundary answerQuestionnaireInteractor;


    public void answerQuestionnaire(@NotNull AnswerQuestionnaireRequestModel answerQuestionnaireRequestModel) {
        int questionnaireId = answerQuestionnaireRequestModel.getQuestionnaireId();
        int participantId = answerQuestionnaireRequestModel.getParticipantId();
        int modifierId = answerQuestionnaireRequestModel.getModifierId();
        int studyId = answerQuestionnaireRequestModel.getStudyId();
        Map<String, String> answers = answerQuestionnaireRequestModel.getAnswers();
        int numQuestions = answerQuestionnaireRequestModel.getNumQuestions();
        answerQuestionnaireInteractor.answerQuestionnaire(questionnaireId, participantId, modifierId, studyId, answers, numQuestions);
    }


    /**
     * Set the interactor for this controller.
     * @param answerQuestionnaireInteractor The interactor.
     */
    public void setAnswerQuestionnaireInteractor(AnswerQuestionnaireInputBoundary answerQuestionnaireInteractor) {
        this.answerQuestionnaireInteractor = answerQuestionnaireInteractor;
    }
}
