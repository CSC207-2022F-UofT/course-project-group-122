package use_cases;

import entities.Answer;
import entities.Researcher;

import java.util.HashMap;
import java.util.Map;

public class ResearcherAnswerModifier {

    public ResearcherAnswerModifier(){
    }

    public void modifyAnswer(Researcher r, String reasonForModification,
                             String varName, String newAns, Answer curAnswer){
        Map<String, String> ans = new HashMap<>();
        ans.put(varName, newAns);
        curAnswer.modifyAnswer(ans, r, reasonForModification);
    }
}
