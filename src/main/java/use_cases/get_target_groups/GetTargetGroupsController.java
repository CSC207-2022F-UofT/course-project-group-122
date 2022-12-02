package use_cases.get_target_groups;

/**
 * The class that the screen calls to get all target groups of a questionnaire.
 */
public class GetTargetGroupsController {

    /**
     * The interface that the use case implements and the controller calls on.
     */
    private GetTargetGroupsInputBoundary getTargetGroupsInteractor;


    /**
     * Gets all target groups of a questionnaire and all the groups of the study.
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
