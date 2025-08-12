package classes;

import java.util.*;

/**
 * Write a description of class Furniture here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Furniture {
    private String name;
    private String description;
    private InventoryItem item;
    private boolean open;

    public Furniture() {
        name = "";
        description = "";
        item = null;
        open = false;
    }

    public Furniture(String n, String d, InventoryItem i, boolean o) {
        name = n;
        description = d;
        item = i;
        open = o;
    }

    public String getName() {
        return name;
    }

    public InventoryItem getItem() {
        return item;
    }

    public boolean isOpen() {
        return open;
    }

    public String open() {
        String output = "";
        if (open) {
            output += "The " + name + " is already open. ";
        } else {
            open = true;
            output += "You opened the " + name + ". ";
        }

        if (item != null) {
            output += description;
            output += "\nThe items in here are : \n" + item.getName();
        }

        return output;
    }

    public String close() {
        if (!open) {
            return "The " + name + " is already closed.";
        }

        open = false;
        return "You closed the " + name + ".";
    }

    public InventoryItem removeItem(String name) {
        if (item.getName().equals(name)) {
            InventoryItem temp = item;
            item = null;
            return temp;
        }

        return null;
    }

}
