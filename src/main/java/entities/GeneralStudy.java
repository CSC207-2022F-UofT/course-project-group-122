package entities;

import java.io.Serializable;

public class GeneralStudy extends Study implements Serializable {


    /**
     * Construct a study object with the following parameters specified:
     *
     * @param studyName       The name of the study that the researcher specifies
     * @param targetStudySize The target study size. What is the number of participants the researchers of this study
     *                        want to achieve?
     */
    public GeneralStudy(String studyName, int targetStudySize) {
        super(studyName, targetStudySize);
    }

    /**
     * Retrieve the type of the study.
     *
     * @return the type of the study.
     */
    @Override
    public String getStudyType() {
        return "General";
    }
}
