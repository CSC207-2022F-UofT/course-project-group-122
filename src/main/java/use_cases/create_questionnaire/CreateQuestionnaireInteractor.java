package use_cases.create_questionnaire;

import entities.IDManager;
import entities.Questionnaire;
import entities.Study;
import org.jetbrains.annotations.NotNull;
import use_cases.fetch_id.FetchId;
import user_interface_layer.screens.create_questionnaire_inputs_screen.QuestionModel;

import java.util.List;

/**
 * The interactor for the create questionnaire use case.
 */
public class CreateQuestionnaireInteractor implements CreateQuestionnaireInputBoundary {
    /**
     * The output boundary for the create questionnaire use case, that the presenter implements.
     */
    private CreateQuestionnaireOutputBoundary creationOutputBoundary;


    /**
     * The IDManager that manages all the IDs of all the entities.
     */
    private IDManager idManager;

    /**
     * The use case that creates a questionnaire.
     *
     * @param data The request model that contains the data for the questionnaire to be created.
     *             This is the data that the screen passes in.
     */
    @Override
    public void createQuestionnaire(CreateQuestionnaireRequestModel data) {
        try {

            Study study = FetchId.getStudy(data.getStudyID());
            if (!study.isActive()) {
                creationOutputBoundary.presentFailureScreen("Study is not active");
            } else if (data.getType().equals("Eligibility")) {
                if (study.getEligibilityQuestionnaire() != null) {
                    creationOutputBoundary.presentFailureScreen("Eligibility questionnaire already exists");
                    throw new IllegalStateException("Eligibility questionnaire already exists");
                }
                Questionnaire questionnaire = createQuestionnaireHelper(data, study);
                study.setEligibilityQuestionnaire(questionnaire);
            } else {
                Questionnaire questionnaire = createQuestionnaireHelper(data, study);
                study.addQuestionnaire(questionnaire);
            }
            creationOutputBoundary.presentSuccessScreen(data.getResearcherID(), data.getStudyID());
        } catch (Exception e) {
            creationOutputBoundary.presentFailureScreen(e.getMessage());
        }

    }

    @NotNull
    private Questionnaire createQuestionnaireHelper(@NotNull CreateQuestionnaireRequestModel data, Study study) {
        List<String> groupNum = CreateTargetGroups.createTargetGroups(data.getGroups(), study);
        Questionnaire questionnaire = new Questionnaire(idManager.newQuestionnaireId(), study,
                data.getQuestionnaireName(), data.getQuestionnaireDescription(), groupNum);
        for (QuestionModel questionData : data.getQuestions()) {
            CreateQuestion.createQuestion(idManager.newQuestionId(), questionnaire, questionData);
        }
        return questionnaire;
    }

    /**
     * Sets the output boundary for the create questionnaire use case.
     *
     * @param outputBoundary The output boundary for the create questionnaire use case, that the presenter implements.
     */
    public void setCreationOutputBoundary(CreateQuestionnaireOutputBoundary outputBoundary) {
        this.creationOutputBoundary = outputBoundary;
    }


    /**
     * Sets the IDManager that manages all the IDs of all the entities.
     *
     * @param idManager The IDManager that manages all the IDs of all the entities.
     */
    public void setIdManager(IDManager idManager) {
        this.idManager = idManager;
    }
}


