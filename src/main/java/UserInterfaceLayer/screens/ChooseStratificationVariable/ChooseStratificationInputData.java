package UserInterfaceLayer.screens.ChooseStratificationVariable;

import UserInterfaceLayer.screens.ControllerManager;

import java.util.ArrayList;
import java.util.List;

public class ChooseStratificationInputData {
    private final int studyId;
    private List<String> stratificationVariables = new ArrayList<>();
    private final ControllerManager controllerManager;

    public ChooseStratificationInputData(int studyId, List<String> stratificationVariables, ControllerManager controllerManager) {
        this.studyId = studyId;
        this.stratificationVariables = stratificationVariables;
        this.controllerManager = controllerManager;
    }

    public int getStudyId() {
        return studyId;
    }
    public List<String> getStratificationVariables() {
        return stratificationVariables;
    }
    public ControllerManager getControllerManager() {
        return controllerManager;
    }
}
