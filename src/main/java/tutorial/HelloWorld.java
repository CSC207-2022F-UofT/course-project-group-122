package tutorial;
import javax.swing.*;

public class HelloWorld {

    public static void main(String[] args) {
        JFrame myFrame = new JFrame("morbin time");
        JButton myButton = new JButton("click me");

        myButton.setBounds(100,100,100,40);

        myFrame.add(myButton);

        myFrame.setSize(1280,720);
        myFrame.setLayout(null);
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static String convert(int decide) {
        if (decide % 15 == 0) {
            return "tutorial.HelloWorld";
        }
        if (decide % 3 == 0) {
            return "Hello";
        }
        if (decide % 5 == 0) {
            return "World";
        }
        return String.valueOf(decide);
    }
}
