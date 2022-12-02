import entities.Study;
import entities.StudyPool;
import entities.User;
import entities.UserPool;
import use_cases.participant_enroller.RandomGroupGeneratorManager;
import use_cases.serializer.Serializer;
import use_cases.user_log_out.UserLogOutGateway;
import use_cases.user_log_out.UserLogOutInteractor;

import java.util.HashMap;

public class TestingStuff {

    public static void main(String[] args){
//        UserPool uP1 = setupUserPool();
//        StudyPool sP1 = setupStudyPool();
//        RandomGroupGeneratorManager thing = new RandomGroupGeneratorManager();
//
//        UserLogOutInteractor logout = new UserLogOutInteractor();
//        UserLogOutGateway gateway = new UserLogOutGateway();
//
//        logout.setUserLogOutGateway(gateway);
//        logout.saveData(uP1, sP1, thing);


    }

    public static UserPool setupUserPool(){
        User u1 = new User("test1", "sample name1");
        User u2 = new User("test2", "sample name2");
        User u3 = new User("test3", "sample name3");

        HashMap<String, User> users = new HashMap<>();
        users.put("test1", u1);
        users.put("test2", u2);
        users.put("test3", u3);

        return new UserPool(users);
    }

    public static StudyPool setupStudyPool(){
        Study s1 = new Study("test1", 1);
        Study s2 = new Study("test2", 1);
        Study s3 = new Study("test3", 1);

        HashMap<Integer, Study> studies = new HashMap<>();
        studies.put(s1.getId(), s1);
        studies.put(s2.getId(), s2);
        studies.put(s3.getId(), s3);

        return new StudyPool(studies);

    }
}
