package entities;

public interface StudyFactoryInterface {

    /**
     * Creates a new study.
     *
     * @param studyType the type of study
     * @param studyName the name of the study
     * @param targetSize the target size of the study
     *
     * @return  the new study
     */
    Study createStudy(String studyType, String studyName, int targetSize);

}
