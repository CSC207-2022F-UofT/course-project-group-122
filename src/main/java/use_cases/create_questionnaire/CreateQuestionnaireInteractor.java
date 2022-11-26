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
            if (!study.isActive()) {
                throw new Exception("Study is not active");
            }
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
                createQuestion(questionnaire, questionData);
            }
            if (data.getType().equals("General")) {
                study.addQuestionnaire(questionnaire);
            } else if (data.getType().equals("Eligibility")) {
                study.setEligibilityQuestionnaire(questionnaire);
            } else {
                outputBoundary.presentFailureScreen("Fail to create questionnaire");
            }
        } catch (Exception e) {
            outputBoundary.presentFailureScreen(e.getMessage());
        }
        outputBoundary.presentSuccessScreen(data.getResearcherID(), data.getStudyID());

    }

//    public void editQuestionnaire(CreateQuestionnaireRequestModel data) {
//        try {
//            Study study = FetchId.getStudy(data.getStudyID());
//            if (!study.isActive()) {
//                throw new Exception("Study is not active");
//            }
//            List<String> groupNum = new ArrayList<>();
//            Map<Integer, String> groupsMap = study.getMatchedGroupNames();
//            for (String groupName : data.getGroups()) {
//                for (Map.Entry<Integer, String> entry : groupsMap.entrySet()) {
//                    if (entry.getValue().equals(groupName)) {
//                        groupNum.add(entry.getKey().toString());
//                    }
//                }
//            }
//            Questionnaire questionnaire = FetchId.getQuestionnaire(data.getQuestionnaireID());
//            questionnaire.setQuestionnaireName(data.getQuestionnaireName());
//            questionnaire.setQuestionnaireDescription(data.getQuestionnaireDescription());
//            questionnaire.setGroups(groupNum);
//            for (QuestionModel questionData : data.getQuestions()) {
//                createQuestion(questionnaire, questionData);
//            }
//            if (data.getType().equals("General")) {
//                study.addQuestionnaire(questionnaire);
//            } else if (data.getType().equals("Eligibility")) {
//                study.setEligibilityQuestionnaire(questionnaire);
//            } else {
//                outputBoundary.presentFailureScreen("Fail to create questionnaire");
//            }
//        } catch (Exception e) {
//            outputBoundary.presentFailureScreen(e.getMessage());
//        }
//        outputBoundary.presentSuccessScreen(data.getResearcherID(), data.getStudyID());
//
//    }

    private static void createQuestion(Questionnaire questionnaire, QuestionModel questionData) {
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
            ((ScaleQuestion) question).setScaleRange(Integer.parseInt(options.get(2)));

        }
        assert question != null;
        questionnaire.addQuestion(question);
    }

    public void setOutputBoundary(CreateQuestionnaireOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

}


