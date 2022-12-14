package use_cases.fetch_study_data;

import entities.Researcher;
import entities.Study;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The response model for the Fetch Study Data use case.
 */
public class FetchStudyDataResponseModel {

    /**
     * The ID of the researcher whose study data is to be fetched.
     */
    private final int researcherId;

    /**
     * The name of the researcher whose study data is to be fetched.
     */
    private final String researcherName;

    /**
     * The map of study data that is associated with the researcher.
     * The key is the study object, and the value is a String array that contains:
     * - the study ID
     * - the study name
     * - the study status (Active or Closed)
     */
    private final Map<Integer, String[]> studiesData;


    public FetchStudyDataResponseModel(@NotNull Researcher researcher, List<Study> listOfStudies) {
        this.researcherId = researcher.getId();
        this.researcherName = researcher.getName();
        this.studiesData = compileStudyData(listOfStudies);
    }

    @Contract(pure = true)
    private @NotNull Map<Integer, String[]> compileStudyData(@NotNull List<Study> listOfStudies) {
        Map<Integer, String[]> studiesData = new HashMap<>();
        for (Study study : listOfStudies) {
            String[] studyData = new String[4];
            studyData[0] = Integer.toString(study.getId());
            studyData[1] = study.getStudyName();
            studyData[2] = getStatus(study);
            studyData[3] = study.getStudyType();
            studiesData.put(study.getId(), studyData);
        }
        return studiesData;
    }

    private @NotNull String getStatus(@NotNull Study study) {
        if (study.isActive()) {
            return "Active";
        } else {
            return "Closed";
        }
    }


    /**
     * Returns the ID of the researcher whose study data is to be fetched.
     *
     * @return The ID of the researcher whose study data is to be fetched.
     */
    public int getResearcherID() {
        return researcherId;
    }


    /**
     * Returns the name of the researcher whose study data is to be fetched.
     *
     * @return The name of the researcher whose study data is to be fetched.
     */
    public String getResearcherName() {
        return researcherName;
    }


    /**
     * Returns the map of study data that is associated with the researcher.
     *
     * @return The map of study data that is associated with the researcher.
     */
    public Map<Integer, String[]> getStudiesData() {
        return studiesData;
    }
}
