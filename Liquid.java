package classes;

import java.util.*;
import java.io.*;

/**
 * Write a description of class Liquid here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Liquid extends Food {
    public Liquid(String n, String d) {
        super(n, d, 0.1, 0);
    }

    public int drink() {
        super.setWeight(0.1);
        if (super.getLifePoints() == 0) {
            return 0;
        }
        super.setLifePoints(0);
        return 5;
    }

    public String fill() {
        super.setWeight(0.3);
        super.setLifePoints(5);
        return "You filled the " + super.getName() + ".";
    }

}
