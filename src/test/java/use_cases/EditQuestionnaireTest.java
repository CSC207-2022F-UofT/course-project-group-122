package use_cases;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

import entities.*;

import use_cases.create_study.*;
import use_cases.edit_questionnaire.EditQuestionnaireController;
import use_cases.edit_questionnaire.EditQuestionnaireInteractor;
import use_cases.edit_questionnaire.EditQuestionnairePresenter;
import use_cases.edit_questionnaire.EditQuestionnaireRequestModel;
import use_cases.fetch_id.FetchId;
import user_interface_layer.screens.create_questionnaire_inputs_screen.QuestionModel;

import javax.print.attribute.HashAttributeSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EditQuestionnaireTest {

    @Test
    public void editquestionnaire() {

        EditQuestionnairePresenter presenter = new EditQuestionnairePresenter();
        EditQuestionnaireInteractor interactor = new EditQuestionnaireInteractor();
        EditQuestionnaireController controller = new EditQuestionnaireController();

        controller.setInputBoundary(interactor);
        interactor.setEditOutputBoundary(presenter);


    }
}
