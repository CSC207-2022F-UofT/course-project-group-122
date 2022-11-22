package use_cases.result_extraction;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class testcsv {
    public static void main(String[] args) {
        String questionnairePath = "C:\\Users\\jiali\\IdeaProjects\\course-project-group-122\\src\\main\\java\\use_cases\\result_extraction" + "\\" +"omg.csv";
        File questionnaireResult = new File(questionnairePath);

        ArrayList<String> headLine = new ArrayList<>();
        for (int i = 6; i > 0; i--) {
            headLine.add(" ");
        }
        ArrayList<String> a = new ArrayList<>();
        a.add("fuck");
        a.add("ohhh");
        headLine.addAll(a);
        String[] k = headLine.toArray(new String[0]);


        try {
            FileWriter exportFile = new FileWriter(questionnaireResult);
            CSVWriter writer = new CSVWriter(exportFile);
            List<String[]> result = new ArrayList<String[]>();
            result.add(k);
            result.add(k);
            writer.writeAll(result);
            writer.close();
        }
        catch (IOException err) {
            err.printStackTrace();
        }
        int id = 1;
        String I = id + "fuck";
        System.out.println(I);








    }
}
