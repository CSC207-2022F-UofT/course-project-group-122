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
        Answer answer = FetchId.getAnswer(answerID, participantId);
        Questionnaire questionnaire = FetchId.getQuestionnaire(questionnaireID, studyId);
        List< Question > questions = questionnaire.getListOfQuestion();
        List<VersionedAnswer> versionedAnswers = answer.getAllVersions();
        List<String[]> versionedAnswersList = new ArrayList<>();
        for (VersionedAnswer versionedAnswer : versionedAnswers) {
            if (versionedAnswer.getVersion() == version) {
                Map<String, String> answers = versionedAnswer.getAnswer();
                for (Question question : questions) {
                    String variable = question.getVariableName();
                    String answerString = answers.get(variable);
                    String[] questionAnswer = {variable, answerString};
                    versionedAnswersList.add(questionAnswer);
                }
            }
        }
        FetchVersionedAnswerResponseModel data = new FetchVersionedAnswerResponseModel(studyId, questionnaireID, versionedAnswersList);
        fetchVersionedAnswerOutBoundary.presentVersionedAnswer(data);
    }
}
