package entities;

import org.jetbrains.annotations.NotNull;

public class StudyFactory implements StudyFactoryInterface {


    /**
     * Creates a new study.
     *
     * @param studyType  the type of study
     * @param studyName  the name of the study
     * @param targetSize the target size of the study
     * @return the new study
     */
    @Override
    public Study createStudy(@NotNull String studyType, String studyName, int targetSize) {
        switch (studyType) {
            case "Randomized":
                return new RandomizedStudy(studyName, targetSize);
            case "General":
                return new GeneralStudy(studyName, targetSize);
            default:
                return null;
        }
    }
}
