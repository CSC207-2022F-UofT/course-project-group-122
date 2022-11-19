package use_cases.fetch_questionnaire_versioned_answer_viewing;

import java.util.ArrayList;
import java.util.List;

/*
 * This class is used to pass data to the CheckQuestionnaireVersionedAnswerScreen.
 * Through CheckQuestionnaireVersionedAnswer.
 */
public class CheckQuestionnaireVersionedAnswerInputData {
    /**
     * The study ID.
     */
    private final int studyID;

    /**
     * The questionnaire ID.
     */
    private final int questionnaireID;

    /**
     * The questions and its corresponding answers, in a list of String arrays.
     */
    private List<String[]> versionedAnswers = new ArrayList<>(); //[Question] [Answer]

    /**
     * The constructor of the class.
     */
    public CheckQuestionnaireVersionedAnswerInputData(int studyID,
                                                      int questionnaireID,
                                                      List<String[]> questionAnswers) {
        this.studyID = studyID;
        this.questionnaireID = questionnaireID;
        this.versionedAnswers = questionAnswers;
    }

    /*
     * Returns the study ID.
     */
    public int getStudyID() {
        return studyID;
    }

    /*
     * Returns the questionnaire ID.
     */
    public int getQuestionnaireID() {
        return questionnaireID;
    }


    /*
     * Returns the questions and its corresponding answers, in a list of String arrays.
     */
    public List<String[]> getVersionedAnswers() {
        return versionedAnswers;
    }

}
