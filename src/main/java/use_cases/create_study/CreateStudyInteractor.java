package use_cases.create_study;

import entities.*;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import use_cases.fetch_id.FetchId;

import java.util.Objects;

public class CreateStudyInteractor implements CreateStudyInputBoundary {

    private CreateStudyOutputBoundary createStudyPresenter;

    private final StudyFactoryInterface studyFactory = new StudyFactory();

    private IDManager idManager;

    /**
     * Creates a new study.
     *
     * @param researcherId The researcher ID.
     * @param studyType    The study type.
     * @param studyName    The study name.
     * @param description  The study description.
     * @param targetSize   The study target size.
     */
    @Override
    public int createStudyObject(int researcherId, String studyType, String studyName,
                                  String description, int targetSize) {
        Study newStudy = studyFactory.createStudy(idManager.newStudyId(), studyType, studyName, targetSize);
        newStudy.setStudyDescription(description);
        Researcher researcher = (Researcher) FetchId.getUser(researcherId);
        newStudy.addResearcher(researcher);
        researcher.addToListStudies(newStudy);
        return FetchId.addStudy(newStudy);
    }


    /**
     * Sets the number of groups in the study and the respective group names.
     *
     * @param numberOfGroups The number of groups.
     * @param groupNames     The group names.
     * @param studyId        The study ID.
     */
    @Override
    public void setStudyGrouping(int studyId, int numberOfGroups, String[] groupNames) {
        Study study = FetchId.getStudy(studyId);
        if (groupingIsValid(study, numberOfGroups, groupNames)) {
            if (namesAreEmpty(groupNames)) {
                study.resetGroups(numberOfGroups);
            } else {
                study.resetGroups(numberOfGroups, groupNames);
            }
        }
    }

    /**
     * Checks that the study has been created successfully.
     *
     * @param studyId The study ID.
     */
    @Override
    public void checkStudyCreatedSuccessfully(int studyId, int researcherId) {
        Study study = FetchId.getStudy(studyId);
        Researcher researcher = (Researcher) FetchId.getUser(researcherId);
        if (checkStudySetupCorrect(study, researcher)) {
            createStudyPresenter.presentStudyCreatedSuccessfully(study.getId(), study.getStudyName(), researcherId);
        } else {
            createStudyPresenter.displayFailureMessage("There is an error in creating the study.");
        }
    }


    /**
     * Check if the study setup is correct.
     * @param study         The study.
     * @param researcher    The researcher.
     * @return              True if the study setup is correct.
     */
    private boolean checkStudySetupCorrect(@NotNull Study study, Researcher researcher) {
        return study.getId() != 0 &&
                study.getStudyName() != null &&
                study.getStudyDescription() != null &&
                study.getStudyType() != null &&
                study.getTargetStudySize() > -1 &&
                study.getNumGroups() != 0 &&
                study.getNumGroups() == study.getGroupNames().length &&
                study.getEligibilityQuestionnaire() == null &&
                (Objects.equals(study.getStudyType(), "General") ||
                        Objects.equals(study.getStudyType(), "Randomized")) &&
                study.getResearchers().contains(researcher) &&
                study.getQuestionnaires().isEmpty();
    }


    /**
     * Returns true if the grouping is valid.
     * <p>
     * Grouping is valid if:
     * 1. If the study is a randomized study, then the group size must be greater than 1.
     * 2. The number of group names must be equal to the group size.
     * @param study         The study.
     * @param groupSize     The group size.
     * @param groupNames    The group names.
     * @return              True if the grouping is valid.
     */
    @Contract(pure = true)
    private boolean groupingIsValid(Study study, int groupSize, String @NotNull [] groupNames) {
        if (groupSize != groupNames.length) {
            createStudyPresenter.displayFailureMessage(
                    "The number of group names does not match the group size.");
            return false;
        } else if (study.getStudyType().equals("Randomized") && groupSize < 2) {
            createStudyPresenter.displayFailureMessage(
                    "The study is a randomized study. It must have at least 2 groups.");
            return false;
        }
        return true;
    }


    /**
     * Checks if the names of the groups are all empty.
     * This means that the user does not provide any group names.
     * @param groupNames    The names of the groups.
     * @return              True if all the names are empty.
     */
    @Contract(pure = true)
    private boolean namesAreEmpty(String @NotNull [] groupNames) {
        for (String name : groupNames) {
            if (! name.equals("")) {
                return false;
            }
        }
        return true;
    }


    /**
     * Sets the presenter for the interactor.
     * @param createStudyPresenter  The presenter.
     */
    public void setCreateStudyPresenter(CreateStudyOutputBoundary createStudyPresenter) {
        this.createStudyPresenter = createStudyPresenter;
    }


    /**
     * Sets the ID manager for the interactor.
     * @param idManager The ID manager.
     */
    public void setIdManager(IDManager idManager) {
        this.idManager = idManager;
    }


}
