package use_cases.fetch_study_data_for_editing;

/**
 * The interface that the presenter implements and the use case calls on.
 */
public interface FetchStudyDataForEditingInputBoundary {
    /**
     * @param studyId      The study id
     * @param researcherId The researcher id
     */
    void fetchStudyDataForEditing(int studyId, int researcherId);
}
