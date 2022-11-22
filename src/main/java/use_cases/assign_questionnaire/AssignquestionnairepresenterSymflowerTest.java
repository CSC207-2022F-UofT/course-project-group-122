package use_cases.assign_questionnaire;

import org.junit.*;
import user_interface_layer.presenter_manager.display_failure_message.DisplayFailureMessageInterface;
import user_interface_layer.presenter_manager.display_general_success_message.DisplaySuccessMessageInterface;

public class AssignquestionnairepresenterSymflowerTest {
	@Test
	public void assigntoallfail1() {
		AssignQuestionnairePresenter a = null; // TODO This is a fallback value due to incomplete analysis.
		int QuestionnaireId = 0; // TODO This is a fallback value due to incomplete analysis.
		int studyID = 0; // TODO This is a fallback value due to incomplete analysis.
		String message = null; // TODO This is a fallback value due to incomplete analysis.
		a.assigntoallfail(QuestionnaireId, studyID, message);
	}

	@Test
	public void assigntoallpresent2() {
		AssignQuestionnairePresenter a = null; // TODO This is a fallback value due to incomplete analysis.
		int questionnaireID = 0; // TODO This is a fallback value due to incomplete analysis.
		int studyID = 0; // TODO This is a fallback value due to incomplete analysis.
		a.assigntoallpresent(questionnaireID, studyID);
	}

	@Test
	public void assigntogroupfail3() {
		AssignQuestionnairePresenter a = null; // TODO This is a fallback value due to incomplete analysis.
		int QuestionnaireId = 0; // TODO This is a fallback value due to incomplete analysis.
		int studyID = 0; // TODO This is a fallback value due to incomplete analysis.
		String group = null; // TODO This is a fallback value due to incomplete analysis.
		String message = null; // TODO This is a fallback value due to incomplete analysis.
		a.assigntogroupfail(QuestionnaireId, studyID, group, message);
	}

	@Test
	public void assigntogrouppresent4() {
		AssignQuestionnairePresenter a = null; // TODO This is a fallback value due to incomplete analysis.
		int questionnaireID = 0; // TODO This is a fallback value due to incomplete analysis.
		int studyID = 0; // TODO This is a fallback value due to incomplete analysis.
		String group = null; // TODO This is a fallback value due to incomplete analysis.
		a.assigntogrouppresent(questionnaireID, studyID, group);
	}

	@Test
	public void assigntoparticipantfail5() {
		AssignQuestionnairePresenter a = null; // TODO This is a fallback value due to incomplete analysis.
		int QuestionnaireId = 0; // TODO This is a fallback value due to incomplete analysis.
		int studyID = 0; // TODO This is a fallback value due to incomplete analysis.
		int participantID = 0; // TODO This is a fallback value due to incomplete analysis.
		String message = null; // TODO This is a fallback value due to incomplete analysis.
		a.assigntoparticipantfail(QuestionnaireId, studyID, participantID, message);
	}

	@Test
	public void assigntoparticipantpresent6() {
		AssignQuestionnairePresenter a = null; // TODO This is a fallback value due to incomplete analysis.
		int questionnaireID = 0; // TODO This is a fallback value due to incomplete analysis.
		int studyID = 0; // TODO This is a fallback value due to incomplete analysis.
		int participantID = 0; // TODO This is a fallback value due to incomplete analysis.
		a.assigntoparticipantpresent(questionnaireID, studyID, participantID);
	}

	@Test
	public void setDisplayFailureMessage7() {
		AssignQuestionnairePresenter a = null; // TODO This is a fallback value due to incomplete analysis.
		DisplayFailureMessageInterface displayFailureMessage = null; // TODO This is a fallback value due to incomplete analysis.
		a.setDisplayFailureMessage(displayFailureMessage);
	}

	@Test
	public void setDisplaySuccessMessage8() {
		AssignQuestionnairePresenter a = null; // TODO This is a fallback value due to incomplete analysis.
		DisplaySuccessMessageInterface displaySuccessMessage = null; // TODO This is a fallback value due to incomplete analysis.
		a.setDisplaySuccessMessage(displaySuccessMessage);
	}
}
