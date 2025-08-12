package classes;

import java.util.*;
import java.io.*;

/**
 * Write a description of class Food here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Food extends InventoryItem {
    // instance variables - replace the example below with your own
    private int lifePoints;

    /**
     * Constructor for objects of class Food
     */
    public Food(String n, String d, double w, int lp) {
        super(n, d, w);
        lifePoints = lp;
    }

    public int eat() {
        return lifePoints;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lp) {
        lifePoints = lp;
    }

    public String toString() {
        return super.toString() + ":has a health value of " + lifePoints;
    }

}
