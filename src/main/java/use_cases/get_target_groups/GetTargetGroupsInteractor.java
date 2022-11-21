package use_cases.get_target_groups;

import entities.Questionnaire;
import entities.Study;
import use_cases.fetch_id.FetchId;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetTargetGroupsInteractor implements GetTargetGroupsInputBoundary {

    private GetTargetGroupsOutputBoundary getTargetGroupsPresenter;

    /**
     * Gets all target groups of a questionnaire.
     *
     * @param questionnaireId The id of the questionnaire.
     * @param studyId         The id of the study.
     */
    @Override
    public void getTargetGroups(int questionnaireId, int studyId) {
        Questionnaire questionnaire = FetchId.getQuestionnaire(questionnaireId, studyId);
        Study study = FetchId.getStudy(studyId);
        if (questionnaire == null) {
            getTargetGroupsPresenter.presentFailure("Questionnaire does not exist.");
        } else {
            Map<Integer, String> studyGroups = study.getMatchedGroupNames();
            List<String> targetGroups = questionnaire.getTargetGroups();
            Map<Integer, String> targetGroupsMap = new HashMap<>();
            for (String targetGroup : targetGroups) {
                int groupNumber = Integer.parseInt(targetGroup);
                targetGroupsMap.put(groupNumber, studyGroups.get(groupNumber));
            }
            getTargetGroupsPresenter.presentTargetGroups(targetGroupsMap, studyGroups,
            studyId, questionnaireId);
        }
    }


    /**
     * Sets the presenter for this interactor.
     *
     * @param getTargetGroupsPresenter The presenter.
     */
    public void setGetTargetGroupsPresenter(GetTargetGroupsOutputBoundary getTargetGroupsPresenter) {
        this.getTargetGroupsPresenter = getTargetGroupsPresenter;
    }
}
