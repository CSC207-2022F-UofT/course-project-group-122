package use_cases.create_questionnaire;

import entities.Study;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A helper class that returns the list of target groups for this questionnaire.
 */
public class CreateTargetGroups {
    /**
     * The method that returns the list of target groups for this questionnaire.
     * @param givenGroups The list of target groups.
     * @param study The study that the questionnaire belongs to.
     * @return The list of target groups for this questionnaire.
     */
    @NotNull
    public static List<String> createTargetGroups(List<String> givenGroups, Study study) {
        List<String> groupNum = new ArrayList<>();
        Map<Integer, String> groupsMap = study.getMatchedGroupNames();
        for (String groupName : givenGroups) {
            for (Map.Entry<Integer, String> entry : groupsMap.entrySet()) {
                if (entry.getValue().equals(groupName)) {
                    groupNum.add(entry.getKey().toString());
                }
            }
        }
        return groupNum;
    }
}
