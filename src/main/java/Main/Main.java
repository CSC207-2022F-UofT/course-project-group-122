package Main;

import user_interface_layer.ScreenManager;
import user_interface_layer.screens.ControllerManager;
import user_interface_layer.screens.screen_drivers.*;
import user_interface_layer.screens.study_data_log.StudyDataLogInputData;
import user_interface_layer.screens.study_data_log.StudyDataLogScreen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ControllerManager controllerManager = new ControllerManager(new ScreenManager());
        SetUpLogInScreenDriver setUpLogInScreenDriver = new SetUpLogInScreenDriver();
        SetUpSignUpScreenDriver setUpSignUpScreenDriver = new SetUpSignUpScreenDriver();
        SetUpRegisterScreenDriver setUpRegisterScreenDriver = new SetUpRegisterScreenDriver();
        controllerManager.setLogInScreenDriver(setUpLogInScreenDriver);
        controllerManager.setSignUpScreenDriver(setUpSignUpScreenDriver);
        controllerManager.setRegisterScreenDriver(setUpRegisterScreenDriver);
        SetUpStudyCreationScreenDriver setUpStudyCreationScreenDriver = new SetUpStudyCreationScreenDriver();
        controllerManager.setStudyCreationScreenDriver(setUpStudyCreationScreenDriver);
        SetUpQuestionnaireCreationScreenDriver setUpQuestionnaireCreationScreenDriver = new SetUpQuestionnaireCreationScreenDriver();
        controllerManager.setSetUpQuestionnaireCreationScreenDriver(setUpQuestionnaireCreationScreenDriver);


//        UserRegisterScreen userRegisterScreen = new UserRegisterScreen(controllerManager);
//        userRegisterScreen.setVisible(true);


//        Map<Integer, String[]> test = Map.of(
//                1, new String[]{"1", "Depression from 207", "Open"}, 2, new String[]{"2", "I want to die Syndrome", "Closed"});
//        ResearcherStudyScreenInputData data = new ResearcherStudyScreenInputData(5, "My moooo", test, controllerManager);
//        ResearcherStudyScreen researcherStudyScreen = new ResearcherStudyScreen(data);
//        researcherStudyScreen.setVisible(true);


        HashMap<Integer, String[]> researchers = new HashMap<>();
//        researchers.put(1, new String[]{"1", "JohnSmith", "John"});
//        researchers.put(2, new String[]{"2", "JaneSmith", "Jane"});
//        researchers.put(3, new String[]{"3", "JohnDoe", "John"});
//        researchers.put(4, new String[]{"4", "JaneDoe", "Jane"});
        HashMap<Integer, String[]> potentialParticipants = new HashMap<>();
//        potentialParticipants.put(1, new String[]{"1", "JohnSmith", "John"});
//        potentialParticipants.put(2, new String[]{"2", "JaneSmith", "Jane"});
//        potentialParticipants.put(3, new String[]{"3", "JohnDoe", "John"});
//        potentialParticipants.put(4, new String[]{"4", "JaneDoe", "Jane"});
        HashMap<Integer, String[]> participants = new HashMap<>();
//        participants.put(1, new String[]{"1", "JohnSmith", "John"});
//        participants.put(2, new String[]{"2", "JaneSmith", "Jane"});
//        participants.put(3, new String[]{"3", "JohnDoe", "John"});
//        participants.put(4, new String[]{"4", "JaneDoe", "Jane"});
        String[] eligibility = new String[]{"1", "Eligibility " + "Questionnaire", "Yes", "No"};
        Map<Integer, String[]> questionnaires = new HashMap<>();
//        questionnaires.put(1, new String[]{"1", "Questionnaire 1", "Yes", "No"});
//        questionnaires.put(2, new String[]{"2", "Questionnaire 2", "Yes", "No"});
//        questionnaires.put(3, new String[]{"3", "Questionnaire 3", "No", "No"});
        List<String> groups = new ArrayList<>();
//        groups.add("The Ingenious");
//        groups.add("The Dumb");
//        groups.add("The Smart");
//        groups.add("The Stupid");

        StudyDataLogInputData data = new StudyDataLogInputData(1,
                "Researcher 1",
                4, "Randomized", "Study 234", researchers, potentialParticipants, participants, 6,  eligibility, questionnaires, groups, controllerManager);
        StudyDataLogScreen screen = new StudyDataLogScreen(data);
        screen.setVisible(true);

    }
}
