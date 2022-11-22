package user_interface_layer.screen_setters;



public class TestScreens {
    public static void main(String[] args) {
        // Test Log In Interface Screens
//        ViewModel viewModel = new ViewModel();
//        viewModel.getRegisterScreen().setVisible(false);


        // Test Participant Not Enrolled Home Screen

//        ParticipantNotEnrolledInputData dataForNotEnrolled = new ParticipantNotEnrolledInputData(1, viewModel);
//        ParticipantNotEnrolledScreen participantNotEnrolledScreen = new ParticipantNotEnrolledScreen(dataForNotEnrolled);
//        viewModel.setUserHomeScreen(participantNotEnrolledScreen);
//        viewModel.getUserHomeScreen().setVisible(true);


        // Test Participant Enrolled Home Screen
//        List<String[]> questionnaires = new ArrayList<>();
//        questionnaires.add(new String[]{"1", "Questionnaire 1", "Description 1", "Not Completed"});
//        questionnaires.add(new String[]{"2", "Questionnaire 2", "Description 2", "Not Completed"});
//        questionnaires.add(new String[]{"3", "Questionnaire 3", "Description 3", "Not Completed"});
//        questionnaires.add(new String[]{"4", "Questionnaire 4", "Description 4", "Completed"});
//        questionnaires.add(new String[]{"5", "Questionnaire 5", "Description 5", "Completed"});
//        String [] eligibilityQuestionnaire = new String[]{"1", "Eligibility Questionnaire", "Description 1", "Completed"};
//
//
//        ParticipantEnrolledInputData dataForEnrolled = new ParticipantEnrolledInputData(44, "Study 1", 2,eligibilityQuestionnaire ,questionnaires, viewModel);
//        ParticipantEnrolledScreen participantEnrolledScreen = new ParticipantEnrolledScreen(dataForEnrolled);
//        viewModel.setUserHomeScreen(participantEnrolledScreen);
//        viewModel.getUserHomeScreen().setVisible(true);
//


        // Test MCQuestion Panel Screen
//        MCQuestionInputData MCdata = new MCQuestionInputData(4, "Question 4", "age", new ArrayList<>() {{
//            add("18-25");
//            add("26-35");
//            add("36-45");
//            add("46-55");
//        }});
//        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        QuestionPanels mcQuestion = new MCQuestionPanel(MCdata);
//        frame.add(mcQuestion);
//        frame.pack();
//        frame.setVisible(true);


        // Test ScaleQuestion Panel Screen
//        ScaleQuestionInputData scaleQuestionInputData = new ScaleQuestionInputData(5, "Question 5", "happy",
//                "not happy", "happy", new ArrayList<>() {{
//            add(1);
//            add(2);
//            add(3);
//            add(4);
//            add(5);
//        }});
//        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        QuestionPanels scaleQuestion = new ScaleQuestionPanel(scaleQuestionInputData);
//        frame.add(scaleQuestion);
//        frame.pack();
//        frame.setVisible(true);

        // Test textQuestion Panel Screen
//        TextQuestionInputData textQuestionInputData = new TextQuestionInputData(6, "Question 6", "name");
//        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        QuestionPanels textQuestion = new TextQuestionPanel(textQuestionInputData);
//        frame.add(new TextQuestionPanel(textQuestionInputData));
//        frame.pack();
//        frame.setVisible(true);


        // Test Answer Questionnaire Screen
//        MCQuestionInputData MCdata = new MCQuestionInputData(4, "Question 4", "age", new ArrayList<>() {{
//            add("18-25");
//            add("26-35");
//            add("36-45");
//            add("46-55");
//        }});
//        QuestionPanels mcQuestion = new MCQuestionPanel(MCdata);
//        ScaleQuestionInputData scaleQuestionInputData = new ScaleQuestionInputData(5, "Question 5", "happy",
//                "not happy", "happy", new ArrayList<>() {{
//            add(1);
//            add(2);
//            add(3);
//            add(4);
//            add(5);
//        }});
//        QuestionPanels scaleQuestion = new ScaleQuestionPanel(scaleQuestionInputData);
//        TextQuestionInputData textQuestionInputData = new TextQuestionInputData(6, "Question 6", "name");
//        QuestionPanels textQuestion = new TextQuestionPanel(textQuestionInputData);
//
//        AnswerQuestionnaireInputData answerQuestionnaireInputData =
//                new AnswerQuestionnaireInputData(1, 7, "Questionnaire 1", "Description 1", 8,
//                        new ArrayList<>() {{
//                            add(mcQuestion);
//                            add(scaleQuestion);
//                            add(textQuestion);
//                        }}, viewModel);
//        AnswerQuestionnaireScreen answerQuestionnaireScreen = new AnswerQuestionnaireScreen(answerQuestionnaireInputData);
//        viewModel.setAnswerQuestionnaireScreen(answerQuestionnaireScreen);
//        viewModel.getRegisterScreen().setVisible(false);
//        viewModel.getAnswerQuestionnaireScreen().setVisible(true);


        // Test StudyLog Screen
//        List<String[]> researchers = new ArrayList<>() {{
//            add(new String[]{"1", "JohnUsername", "JohnName"});
//            add(new String[]{"2", "JaneUsername", "JaneName"});
//        }};
//
//        List<String[]> questionnaires = new ArrayList<>() {{
//            add(new String[]{"1", "Questionnaire 1", "a description for questionnaire 1", "Not Published", "Open"});
//            add(new String[]{"2", "Questionnaire 2", "a description for questionnaire 2", "Published", "Closed"});
//        }};
//        String[] elilibilityQ = new String[]{"0", "Questionnaire", "the Elibilibity Questionnaire", "Published", "Open"};
//        StudyLogInputData studyLogInputData = new StudyLogInputData(1, 2, "Randomized", "", "Title" , researchers, researchers, researchers,elilibilityQ ,questionnaires,new ArrayList<>() {{
//            add("Group 1");
//            add("Group 2");
//            add("Group 3");
//        }}, new ViewModel());
//        ResearcherStudyLogScreen studyLogScreen = new ResearcherStudyLogScreen(studyLogInputData);
//        viewModel.setResearcherStudyLogScreen(studyLogScreen);
//        viewModel.getResearcherStudyLogScreen().setVisible(true);

        // Test Add User To Study Screen
//        AddUserInputData addUserToStudyInputData = new AddUserInputData( 45, "Potential Participant", new ArrayList<>(){{
//            add(new String[] {"1", "JohnUsername", "JohnName"});
//            add(new String[] {"2", "JaneUsername", "JaneName"});
//            add(new String[] {"3", "JackUsername", "JackName"});
//        }}, viewModel);
//        AddUserScreen addUserToStudyScreen = new AddUserScreen(addUserToStudyInputData);
//        viewModel.setAddUserScreen(addUserToStudyScreen);
//        viewModel.getAddUserScreen().setVisible(true);


        // Test Add Potential Participant Screen
//        EnrollPotentialParticipantInputData enrollPotentialParticipantInputData = new EnrollPotentialParticipantInputData(
//                55, new ArrayList<>(){{
//            add(new String[] {"1", "JohnUsername", "JohnName"});
//            add(new String[] {"2", "JaneUsername", "JaneName"});
//            add(new String[] {"3", "JackUsername", "JackName"});
//        }}, viewModel);
//        EnrollPotentialParticipantScreen enrollPotentialParticipantScreen = new EnrollPotentialParticipantScreen(enrollPotentialParticipantInputData);
//        viewModel.setEnrollPotentialParticipantScreen(enrollPotentialParticipantScreen);
//        viewModel.getEnrollPotentialParticipantScreen().setVisible(true);


        // Test Researcher Home Screen
//        ResearchersStudiesInputData data = new ResearchersStudiesInputData(13, new ArrayList<>(){{
//            add(new String[] {"1", "Study 1", "a description for study 1", "Not Published", "Open"});
//            add(new String[] {"2", "Study 2", "a description for study 2", "Published", "Closed"});
//        }}, viewModel);
//
//        ResearcherStudiesScreen researcherStudiesScreen = new ResearcherStudiesScreen(data);
//        viewModel.setUserHomeScreen(researcherStudiesScreen);
//        viewModel.getUserHomeScreen().setVisible(true);

        // Test Create Study Screen
//        CreateStudyInputData data = new CreateStudyInputData(13, viewModel);
//        CreateStudyScreen createStudyScreen = new CreateStudyScreen(data);
//        viewModel.setCreateStudyScreen(createStudyScreen);
//        viewModel.getCreateStudyScreen().setVisible(true);


        // Test Create Questionnaire Screen
//        CreateQuestionnaireDataInput data = new CreateQuestionnaireDataInput(1, viewModel);
//        CreateQuestionnaireScreen createQuestionnaireScreen = new CreateQuestionnaireScreen(data);
//        createQuestionnaireScreen.setVisible(true);
}}

