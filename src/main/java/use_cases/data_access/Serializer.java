package use_cases.data_access;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Serializer {

    public static final String BASEPATH = new File("storage").getAbsolutePath();


    private static @NotNull String getClassName(@NotNull Object obj){
        return obj.getClass().getSimpleName();
    }


    public static void saveObject(@NotNull Object obj){
        String filename = File.separator + getClassName(obj) + ".ser";
        try(FileOutputStream fileOut = new FileOutputStream(BASEPATH.concat(filename));
            ObjectOutputStream output = new ObjectOutputStream(fileOut)){
            output.writeObject(obj);
        }
        catch (IOException i){
            i.printStackTrace();
        }
    }

    private static Object getObject(String fileName){
        Object obj = null;
        try(FileInputStream fileIn = new FileInputStream(BASEPATH.concat("/"+fileName));
            ObjectInputStream in = new ObjectInputStream(fileIn)){
            obj = in.readObject();
        }
        catch (IOException i) {
            i.printStackTrace();
        }
        catch (ClassNotFoundException c) {
            Logger.getLogger("Person class not found");
            c.printStackTrace();
        }
        return obj;
    }



    private static String[] getFileNameList(){
        File folder = new File(BASEPATH);
        return folder.list();
    }


    private static void purge(String @NotNull [] listOfFileNames){
        for(String name : listOfFileNames){
            File folder = new File(BASEPATH + File.separator + name);
            folder.delete();
        }
    }

    public static @NotNull List<Object> getAll(){
        String[] names = getFileNameList();
        ArrayList<Object> objs = new ArrayList<>();

        for (String name : names) {
            objs.add(getObject(name));
        }
        purge(names);
        return objs;
    }
}
