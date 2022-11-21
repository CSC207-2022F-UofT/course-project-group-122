package user_interface_layer;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class SetScreenToCenter{
    public Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    public SetScreenToCenter(JFrame screen){

        int xPoint = getPoint(dimension.getWidth(), screen.getWidth());
        int yPoint = getPoint(dimension.getHeight(), screen.getHeight());

        screen.setLocation(xPoint, yPoint);
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
    public SetScreenToCenter(JFrame screen, int width, int height){
        screen.setSize(width, height);

        int xPoint = getPoint(dimension.getWidth(), screen.getWidth());
        int yPoint = getPoint(dimension.getHeight(), screen.getHeight());
        screen.setLocation(xPoint, yPoint);

    }


}
