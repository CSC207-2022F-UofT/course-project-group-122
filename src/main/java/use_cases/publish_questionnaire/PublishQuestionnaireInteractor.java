package use_cases.publish_questionnaire;

import entities.Questionnaire;
import entities.Study;
import org.jetbrains.annotations.NotNull;
import use_cases.fetch_id.FetchId;

public class PublishQuestionnaireInteractor implements PublishQuestionnaireInputBoundary {

    private PublishQuestionnaireOutputBoundary publishQuestionnairePresenter;

    /**
     * Publishes a questionnaire.
     *
     * @param questionnaireID The ID of the questionnaire to publish.
     * @param studyId         The ID of the study to publish the questionnaire to.
     */
    @Override
    public void publishQuestionnaire(int questionnaireID, int studyId, int researcherId) {
    Questionnaire questionnaire = FetchId.getQuestionnaire(questionnaireID, studyId);
    Study study = FetchId.getStudy(studyId);
        if (questionnaire == null) {
            publishQuestionnairePresenter.invalidQuestionnaire(questionnaireID, "The questionnaire with the given " +
                    "id does not exist.");
        } else if (study.getEligibilityQuestionnaire() == questionnaire && study.getConsentForm() == null) {
            publishQuestionnairePresenter.invalidQuestionnaire(questionnaireID, "The questionnaire with the given " +
                    "id is the eligibility questionnaire for the study. A mandatory consent form has not been " +
                    "created for the study. You must create a consent form before publishing the eligibility " +
                    "questionnaire.");
        } else if (canBePublished(questionnaire, study)) {
        questionnaire.publish();
        publishQuestionnairePresenter.publishQuestionnaire(questionnaireID, studyId, researcherId);
            if (study.getEligibilityQuestionnaire() == questionnaire) {
                publishQuestionnairePresenter.assignToAllPotentialParticipants(questionnaireID, studyId, researcherId);
            }
        } else {
            throw new IllegalStateException("The questionnaire with the given id cannot be published.");
        }
    }


    /**
     * Checks if the questionnaire ID is a valid questionnaire ID, and the associated questionnaire can be published.
     * @param questionnaire The questionnaire to check.
     * @param study         The study to check.
     * @return  whether the questionnaire can be published.
     */
    private boolean canBePublished(@NotNull Questionnaire questionnaire, @NotNull Study study) {
        if (questionnaire.getStudy() != study) {
            publishQuestionnairePresenter.invalidQuestionnaire(questionnaire.getId(), "The questionnaire is not " +
                    "associated with the study.");
            return false;
        } else if (questionnaire.isPublished()) {
            publishQuestionnairePresenter.invalidQuestionnaire(questionnaire.getId(), "The questionnaire is already " +
                    "published.");
            return false;
        } else if (questionnaire.getListOfQuestion().isEmpty()) {
            publishQuestionnairePresenter.invalidQuestionnaire(questionnaire.getId(), "The questionnaire has no " +
                    "questions.");
            return false;
        } else if (questionnaire.getVariableNames().size() != questionnaire.getListOfQuestion().size() ||
                questionnaire.getVariableNames().size() != questionnaire.getNumOfQuestions()) {
            publishQuestionnairePresenter.invalidQuestionnaire(questionnaire.getId(), "The questionnaire has " +
                    "inconsistent number of questions.");
            return false;
        } else {
            return true;
        }
    }


    /**
     * Sets the presenter for this use case.
     * @param publishQuestionnairePresenter  The presenter for this use case.
     */
    public void setPublishQuestionnairePresenter(PublishQuestionnaireOutputBoundary publishQuestionnairePresenter) {
        this.publishQuestionnairePresenter = publishQuestionnairePresenter;
    }
}
