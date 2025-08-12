package classes;

import java.util.*;
import java.io.*;

/**
 * Write a description of class Key here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Key extends Tool {
    // instance variables - replace the example below with your own
    String directionToOpen;
    // nameOfRoomIWorkIn is inherited from Tool superclass

    /**
     * Constructor for objects of class Key
     */
    public Key(String n, String d, Room c, String dn) {
        super(n, d, 0.1, c);
        directionToOpen = dn;
    }

    public String use(Room curr) {
        if (super.getWhereUsed() == curr) {
            curr.unlock(directionToOpen);
            return "You used the " + super.getName() + " to unlock the door and turn the knob.";
        }

        return "You're not using this key in the right place.";
    }

    public String getDirection() {
        return directionToOpen;
    }

    public String toString() {
        return super.toString() + ":opens the door to the " + directionToOpen;
    }

}
