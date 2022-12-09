package user_interface_layer.screen_helper_classes;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * A helper class that sets the screen to the center of the screen.
 */
public class SetScreenToCenter {
    /**
     * Sets the screen to the center of the screen.
     */
    public static final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

    /**
     * @param screen The screen to set to the center of the screen.
     */
    public static void setCenter(@NotNull JFrame screen) {

        int xPoint = getPoint(dimension.getWidth(), screen.getWidth());
        int yPoint = getPoint(dimension.getHeight(), screen.getHeight());

        screen.setLocation(xPoint, yPoint);
    }

    /**
     * @param dimension The dimension of the screen.
     * @param length    The length of the screen.
     * @return The point to set the screen to.
     */
    private static int getPoint(double dimension, int length) {
        return (int) ((dimension - length) / 2);
    }

    /**
     * @param screen The screen to set to the center of the screen.
     * @param layout The layout of the screen.
     * @param width  The width of the screen.
     * @param height The height of the screen.
     */
    public SetScreenToCenter(@NotNull JFrame screen, java.awt.LayoutManager layout, int width, int height) {
        screen.setLayout(layout);
        screen.setSize(width, height);

        int xPoint = getPoint(dimension.getWidth(), screen.getWidth());
        int yPoint = getPoint(dimension.getHeight(), screen.getHeight());
        screen.setLocation(xPoint, yPoint);
        screen.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * @param screen The screen to set to the center of the screen.
     * @param width  The width of the screen.
     * @param height The height of the screen.
     */
    public SetScreenToCenter(@NotNull JFrame screen, int width, int height) {
        screen.setSize(width, height);

        int xPoint = getPoint(dimension.getWidth(), screen.getWidth());
        int yPoint = getPoint(dimension.getHeight(), screen.getHeight());
        screen.setLocation(xPoint, yPoint);
    }
}
