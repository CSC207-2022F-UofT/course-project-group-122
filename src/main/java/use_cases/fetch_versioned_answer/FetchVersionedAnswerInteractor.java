package use_cases.fetch_versioned_answer;

import entities.Answer;
import entities.Question;
import entities.Questionnaire;
import entities.VersionedAnswer;
import use_cases.fetch_id.FetchId;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FetchVersionedAnswerInteractor implements FetchVersionedAnswerInputBoundary {
    FetchVersionedAnswerOutBoundary fetchVersionedAnswerOutBoundary;

    @Override
    public void fetchVersionedAnswer(int studyId, int participantId, int questionnaireID, int answerID, int version) {
        try {
            Answer answer = FetchId.getAnswer(answerID, participantId);
            if (answer == null) {
                throw new Exception("Answer does not exist");
            }
            Questionnaire questionnaire = FetchId.getQuestionnaire(questionnaireID, studyId);
            assert questionnaire != null;
            List<Question> questions = questionnaire.getListOfQuestion();
            List<VersionedAnswer> versionedAnswers = answer.getAllVersions();
            if (versionedAnswers.size() == 0) {
                throw new Exception("Version does not exist");
            }
            List<String[]> versionedAnswersList = new ArrayList<>();
            for (VersionedAnswer versionedAnswer : versionedAnswers) {
                if (versionedAnswer.getVersion() == version) {
                    Map<String, String> answers = versionedAnswer.getAnswer();
                    for (Question question : questions) {
                        String questionContent = question.getContent();
                        String variable = question.getVariableName();
                        String answerString = answers.get(variable);
                        String[] questionAnswer = {questionContent, answerString};
                        versionedAnswersList.add(questionAnswer);
                    }
                }
            }
            FetchVersionedAnswerResponseModel data = new FetchVersionedAnswerResponseModel(studyId, questionnaireID, versionedAnswersList);
            fetchVersionedAnswerOutBoundary.presentVersionedAnswer(data);
        }catch (Exception e){
            fetchVersionedAnswerOutBoundary.presentFailedScreen(e.getMessage());
        }

    }

    public void setFetchVersionedAnswerOutBoundary(FetchVersionedAnswerOutBoundary fetchVersionedAnswerOutBoundary) {
        this.fetchVersionedAnswerOutBoundary = fetchVersionedAnswerOutBoundary;
    }
}
