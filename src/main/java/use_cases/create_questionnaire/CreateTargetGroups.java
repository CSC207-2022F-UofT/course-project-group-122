package use_cases.create_questionnaire;

import entities.Study;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CreateTargetGroups {
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
