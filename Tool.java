package classes;

import java.util.*;
import java.io.*;

/**
 * Write a description of class Tool here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tool extends InventoryItem {
    // instance variables - replace the example below with your own
    private Room whereUsed;
    private ArrayList<Room> whereUsedMult;

    public Tool(String n, String d, double w) {
        super(n, d, w);
    }

    public Tool(String n, String d, double w, Room c) {
        super(n, d, w);
        this.whereUsed = c;
    }

    public Tool(String n, String d, double w, ArrayList<Room> um) {
        super(n, d, w);
        this.whereUsedMult = um;
    }

    public String use(Room curr) {
        if (curr == whereUsed) {
            return "You used the " + super.getName();
        }

        return "You can't use this item here.";
    }

    public Room getWhereUsed() {
        return whereUsed;
    }

    public ArrayList<Room> getWhereMultUsed() {
        return whereUsedMult;
    }

    public void setWhereUsed(Room newR) {
        whereUsed = newR;
    }

    public Room setWhereUsed(int index, Room n) {
        return whereUsedMult.set(index, n);
    }

    public String toString() {
        if (whereUsedMult == null) {
            return super.toString() + ":used in " + whereUsed.getName();
        }

        String output = super.toString() + ":used in " + whereUsedMult.get(0).getName();
        for (int i = 1; i < whereUsedMult.size(); i++) {
            output += ", " + whereUsedMult.get(i);
        }
        return output;
    }
}
