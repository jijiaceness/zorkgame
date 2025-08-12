package classes;

import java.util.*;
import java.io.*;

/**
 * Write a description of class Document here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Document extends Tool {
    // instance variables - replace the example below with your own
    String contents;

    /**
     * Constructor for objects of class Document
     */
    public Document(String n, String d, double w, String c) {
        super(n, d, w);
        contents = c;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String n) {
        contents = n;
    }

}
