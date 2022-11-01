import entities.User;
import use_cases.serializer.Serializer;

import java.util.ArrayList;

public class TestingStuff {

    public static void main(String[] args){
        User u1 = new User("tedward", "ted");

        Serializer s = new Serializer();

        s.saveObject(u1);


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        ArrayList<Object> objs = s.getAll();

        System.out.println(objs.get(0).getClass());


    }
}
