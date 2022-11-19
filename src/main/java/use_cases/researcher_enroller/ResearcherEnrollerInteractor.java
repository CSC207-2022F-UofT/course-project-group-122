package use_cases.researcher_enroller;

import entities.Researcher;
import entities.Study;
import entities.User;
import org.jetbrains.annotations.NotNull;
import use_cases.fetch_id.FetchId;

public class ResearcherEnrollerInteractor implements ResearcherEnrollerInputBoundary {

    private final ResearcherEnrollerOutputBoundary researcherEnrollerPresenter = new ResearcherEnrollerPresenter();

    /**
     * Fetches the researcher's information from the database and returns it to the presenter.
     *
     * @param researcherId The researcher's id.
     */
    @Override
    public void fetchResearcher(int researcherId, int studyId) {
        Researcher researcher = checkValidResearcherId(researcherId);
        Study study = FetchId.getStudy(studyId);
        if (researcher.listStudiesContains(study)) {
            researcherEnrollerPresenter.invalidResearcherId(researcherId,
                    "The researcher is already enrolled in the study.");
        } else {
            researcherEnrollerPresenter.presentResearcherInformation(researcher.getId(), researcher.getName());
        }
    }

    /**
     * Enroll the researcher in the study. This is called when the researcher confirms who to enroll.
     * Precondition: the researcher id is associated with the correct researcher
     *
     * @param researcherId The researcher's id.
     */
    @Override
    public void enrollResearcher(int researcherId, int studyId) {
        Researcher researcher = checkValidResearcherId(researcherId);
        Study study = FetchId.getStudy(studyId);
        if (researcher.listStudiesContains(study)) {
            researcherEnrollerPresenter.invalidResearcherId(researcherId,
                    "The researcher is already enrolled in the study.");
        } else {
            study.addResearchers(researcher);
            researcher.addToListStudies(study);
            researcherEnrollerPresenter.presentEnrollmentSuccess(researcher.getId(), researcher.getName(),
                    study.getId(), study.getStudyName());
        }

    }


    /**
     * Checks if the researcher ID is a valid researcher ID, and return the researcher object if it is.
     * @param researcherId  The researcher's id.
     * @return  The researcher object if the researcher ID is valid, null otherwise.
     */
    private @NotNull Researcher checkValidResearcherId(int researcherId) {
        if (FetchId.checkUserExists(researcherId)) {
            User user = FetchId.getUser(researcherId);
            if (user instanceof Researcher) {
                return (Researcher) user;
            } else {
                researcherEnrollerPresenter.invalidResearcherId(researcherId, "The user with the given id is not a " +
                        "researcher.");
            }
        } else {
            researcherEnrollerPresenter.invalidResearcherId(researcherId, "The user with the given id does not exist.");
        }
        throw new IllegalArgumentException("The researcher ID is invalid.");
    }
}
