package use_cases.create_questionnaire;

import entities.*;
import use_cases.fetch_id.FetchId;
import user_interface_layer.screens.create_questionnaire_inputs_screen.QuestionModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CreateQuestionnaireInteractor implements CreateQuestionnaireInputBoundary {
    private CreateQuestionnaireOutputBoundary outputBoundary;

    @Override
    public void createQuestionnaire(CreateQuestionnaireRequestModel data) {
        try {
            Study study = FetchId.getStudy(data.getStudyID());
            List<String> groupNum = new ArrayList<>();
            Map<Integer, String> groupsMap = study.getMatchedGroupNames();
            for (String groupName : data.getGroups()) {
                for (Map.Entry<Integer, String> entry : groupsMap.entrySet()) {
                    if (entry.getValue().equals(groupName)) {
                        groupNum.add(entry.getKey().toString());
                    }
                }
            }
            Questionnaire questionnaire = new Questionnaire(study,
                    data.getQuestionnaireName(), data.getQuestionnaireDescription(), groupNum);
            for (QuestionModel questionData : data.getQuestions()) {
                String type = questionData.getType();
                Question question =
                        QuestionFactoryInterface.create(
                                type,
                                questionnaire,
                                questionData.getVariable(),
                                questionData.getContent());
                if (type.equals("MC")) {
                    List<String> options = List.of(questionData.getOptions().split(","));
                    for (String singleOption : options) {
                        assert question != null;
                        ((MultipleChoiceQuestion) question).addChoice(singleOption);

                    }

                } else if (type.equals("Scale")) {
                    List<String> options = List.of(questionData.getOptions().split(","));
                    assert question != null;
                    ((ScaleQuestion) question).setBottomLabel(options.get(0));
                    ((ScaleQuestion) question).setTopLabel(options.get(1));
                    ((ScaleQuestion) question).setScaleRange(Integer.parseInt(options.get(3)));

                }
                assert question != null;
                questionnaire.addQuestion(question);
                study.addQuestionnaire(questionnaire);
            }
        } catch (Exception e) {
            outputBoundary.presentFailureScreen(e.getMessage());
        }
        outputBoundary.presentSuccessScreen();
}}

