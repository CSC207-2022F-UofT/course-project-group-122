package use_cases.get_target_groups;

public class GetTargetGroupsController {

    private GetTargetGroupsInputBoundary getTargetGroupsInteractor;


    /**
     * Gets all target groups of a questionnaire.
     * @param questionnaireId   The id of the questionnaire.
     * @param studyId           The id of the study.
     */
    public void getTargetGroups(int questionnaireId, int studyId) {
        getTargetGroupsInteractor.getTargetGroups(questionnaireId, studyId);
    }


    /**
     * Sets the interactor for this controller.
     * @param getTargetGroupsInteractor  The interactor.
     */
    public void setGetTargetGroupsInteractor(GetTargetGroupsInputBoundary getTargetGroupsInteractor) {
        this.getTargetGroupsInteractor = getTargetGroupsInteractor;
    }
}
