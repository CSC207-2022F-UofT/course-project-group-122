package entities;

import java.util.ArrayList;
import java.util.List;

public class StudyQuestionnaireManager {

    /**
     * The study that this manager is managing.
     */
    private final Study study;

    /**
     * The eligibility questionnaire of the study, stored as a separate attribute to the other regular questionnaires which
     * are stored separately in another attribute.
     */
    private Questionnaire eligibilityQuestionnaire;

    /**
     * The list of all questionnaires created by the researchers for this study.
     */
    private final List<Questionnaire> questionnaires = new ArrayList<>();

    /**
     * The consent form of the study.
     */
    private ConsentForm consentForm;


    /**
     * Constructor for StudyQuestionnaireManager.
     *
     * @param study the study that this StudyQuestionnaireManager is managing.
     */
    public StudyQuestionnaireManager(Study study) {
        this.study = study;
    }


    /**
     * Retrieve the study that this manager is managing.
     *
     * @return the study that this manager is managing.
     */
    public Study getStudy() {
        return study;
    }

    /**
     * Retrieve the eligibility questionnaire.
     *
     * @return the eligibility questionnaire.
     */
    protected Questionnaire getEligibilityQuestionnaire() {
        return eligibilityQuestionnaire;
    }

    /**
     * Set the eligibility questionnaire.
     *
     * @param eligibilityQuestionnaire the eligibility questionnaire.
     */
    protected void setEligibilityQuestionnaire(Questionnaire eligibilityQuestionnaire) {
        this.eligibilityQuestionnaire = eligibilityQuestionnaire;
    }

    /**
     * Retrieve the list of questionnaires of the study. Return a copy.
     *
     * @return the list of questionnaires of the study.
     */
    protected List<Questionnaire> getQuestionnaires() {
        return new ArrayList<>(this.questionnaires);
    }

    /**
     * Add a questionnaire to the list of questionnaires.
     *
     * @param q the questionnaire to be added.
     * @return whether the addition is successful.
     */
    protected boolean addQuestionnaire(Questionnaire q) {
        if (!this.questionnaires.contains(q)) {
            return this.questionnaires.add(q);
        }
        return false;
    }

    /**
     * Remove a questionnaire from the list of questionnaires.
     *
     * @param q the questionnaire to be removed.
     * @return whether the removal is successful.
     */
    protected boolean removeQuestionnaire(Questionnaire q) {
        if (this.questionnaires.contains(q)) {
            return this.questionnaires.remove(q);
        }
        return false;
    }

    /**
     * Retrieve the consent form.
     *
     * @return the consent form.
     */
    protected ConsentForm getConsentForm() {
        return consentForm;
    }

    /**
     * Set the consent form.
     *
     * @param consentForm the consent form.
     */
    protected void setConsentForm(ConsentForm consentForm) {
        this.consentForm = consentForm;
    }
}