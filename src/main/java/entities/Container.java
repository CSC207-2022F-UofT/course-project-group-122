package entities;

import java.util.ArrayList;

/**
 * this is a container for the objects, it is to be used for serialization purposes.
 */

public class Container {
    /**
     * An ArrayList for storing the objects
     */
    private final ArrayList<Object> box;

    /**
     * Initializes a container
     * @param box An ArrayList containing objects.
     */

    public Container(ArrayList<Object> box){
        this.box = box;
    }

    /**
     * gets Arraylist of objects contained within this container.
     * @return An Arraylist of objects.
     */

    public ArrayList<Object> getBox() {
        return box;
    }
}
