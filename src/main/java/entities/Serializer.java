package entities;

import java.io.*;
import java.util.ArrayList;

public class Serializer {

    public String basePath = new File("storage").getAbsolutePath();

    public Serializer(){}

    public void saveObject(String fileName, Object obj){
        try(FileOutputStream fileout = new FileOutputStream(this.basePath.concat("/"+fileName));
            ObjectOutputStream output = new ObjectOutputStream(fileout)){
            output.writeObject(obj);
        }
        catch (IOException i){
            i.printStackTrace();
        }
    }

    public Object getObject(String fileName){
        Object obj = null;
        try(FileInputStream fileIn = new FileInputStream(this.basePath.concat("/"+fileName));
            ObjectInputStream in = new ObjectInputStream(fileIn)){
            obj = in.readObject();
        }
        catch (IOException i) {
            i.printStackTrace();
        }
        catch (ClassNotFoundException c) {
            System.out.println("Person class not found");
            c.printStackTrace();
        }
        return obj;
    }
    public String[] getFileNameList(String pathName){
        File folder = new File(pathName);
        return folder.list();
    }

    public ArrayList<Object> getAll(){
        String[] names = getFileNameList(this.basePath);
        ArrayList<Object> objs = new ArrayList<>();

        for(String name : names){
            objs.add(getObject(name));
        }
        return objs;
    }
}
