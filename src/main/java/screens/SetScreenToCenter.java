package screens;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class SetScreenToCenter{
    public Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    public SetScreenToCenter(JFrame screen){
        screen.setLayout(new GridLayout(1,1));
        screen.setSize(400, 80);

        int xPoint = getPoint(dimension.getWidth(), screen.getWidth());
        int yPoint = getPoint(dimension.getHeight(), screen.getHeight());

        screen.setLocation(xPoint, yPoint);
        screen.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private int getPoint(double dimension, int length){
        return (int) ((dimension - length) / 2);
    }

    public SetScreenToCenter(JFrame screen, java.awt.LayoutManager layout, int width, int height){
        screen.setLayout(layout);
        screen.setSize(width, height);

        int xPoint = getPoint(dimension.getWidth(), screen.getWidth());
        int yPoint = getPoint(dimension.getHeight(), screen.getHeight());
        screen.setLocation(xPoint, yPoint);
        screen.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


}
