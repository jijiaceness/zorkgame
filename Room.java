package classes;

import java.util.*;
import java.io.*;

/**
 * Room Class
 * Each room represents a spot in the world
 * Room's have names, descriptions, inventories, and
 * passages or lack there of to the N,S,E, and W
 */
public class Room {
    //Informational: Fields for the Room class

    private boolean canGoNorth;
    private boolean canGoSouth;
    private boolean canGoEast;
    private boolean canGoWest;
    private String description;
    private String name;

    /*
     * TODO: Checkpoint 5 Task
     *
     * Add an instance variable (aka field) that gives the Room an inventory
     * This is an ArrayList that only the Room can access
     * the type is InventoryItem.
     * Be sure to use encapsulation
     */
    private ArrayList<InventoryItem> inventory;
    private Furniture furniture;

    /**
     * default Room constructor
     * it populates all of the instance variables with default values of false for movement
     * it also adds a description that this is not actually a room
     */
    public Room(){
        this.canGoNorth = false;
        this.canGoSouth = false;
        this.canGoEast = false;
        this.canGoWest = false;
        this.name = "Not a room";
        this.description = "This is not a room, you shouldn't be here!!!";
        inventory = new ArrayList<InventoryItem>();
    }

    /**
     * custom Room constructor
     * use to build an instance of a Room object
     * the client populates all of the instance variables by
     * passing the following parameters in this order
     *
     * @param canGoNorth
     * @param canGoSouth
     * @param canGoEast
     * @param canGoWest
     * @param name
     * @param description
     */
    public Room(boolean canGoNorth, boolean canGoSouth, boolean canGoEast, boolean canGoWest, String name, String description){
        this.canGoNorth = canGoNorth;
        this.canGoSouth = canGoSouth;
        this.canGoEast = canGoEast;
        this.canGoWest = canGoWest;
        this.name = name;
        this.description = description;


        /*
         * TODO: Checkpoint 5 Task
         *
         * initialize the inventory ArrayList
         */
        inventory = new ArrayList<InventoryItem>();
        furniture = new Furniture();

    }



    /**
     * custom Room constructor with 7 parameters
     * use to build an instance of a Room object
     * the client populates all of the instance variables by
     * passing the following parameters in this order
     *
     * @param canGoNorth
     * @param canGoSouth
     * @param canGoEast
     * @param canGoWest
     * @param name
     * @param description
     * @param item  -- this is type InventoryItem
     */
    /*
     * TODO: Checkpoint 5 Task
     *
     * create the new Room constructor noted above
     * Advanced Concept: you can use the custom constructor above with the "this" key word
     *
     */

    public Room(boolean canGoNorth, boolean canGoSouth, boolean canGoEast,
                boolean canGoWest, String name, String description, InventoryItem item) {
        this.canGoNorth = canGoNorth;
        this.canGoSouth = canGoSouth;
        this.canGoEast = canGoEast;
        this.canGoWest = canGoWest;
        this.name = name;
        this.description = description;
        inventory = new ArrayList<InventoryItem>();
        this.inventory.add(item);
    }

/**
 * optional custom Room constructor with 7 parameters
 * use to build an instance of a Room object
 * the client populates all of the instance variables by
 * passing the following parameters in this order
 *
 * @param canGoNorth
 * @param canGoSouth
 * @param canGoEast
 * @param canGoWest
 * @param name
 * @param description
 * @param item  -- this is an ArrayList of type Inventory
 */
    /*
     * TODO: Checkpoint 5 Optional Task
     *
     * create the optional constructor as noted above
     */
    /*
    public Room(boolean canGoNorth, boolean canGoSouth, boolean canGoEast,
    boolean canGoWest, String name, String description, ArrayList<Inventory> item) {
        this.canGoNorth = canGoNorth;
        this.canGoSouth = canGoSouth;
        this.canGoEast = canGoEast;
        this.canGoWest = canGoWest;
        this.name = name;
        this.description = description;
        // don't know about item
    }
    */

    /**
     * getDescription accessor method
     * gets the room description
     * @return the description
     */

    public String getDescription(){
        return this.description;
    }

    /**
     * getName accessor method
     * It gets the room name
     * @return the name
     */

    public String getName(){
        return this.name;
    }

    /**
     * setDescription mutator method
     * It sets the room description
     * @param d is the description of the room
     */

    public void setDescription(String d){
        description = d;
    }

    /**
     * setName mutator method
     * It sets the room name
     * @param n is the name you want the room to have
     */

    public void setName(String n){
        name = n;
    }


    /**
     * getCanGoNorth accessor method
     * used to determine if the player can move North
     * @return the value of canGoNorth
     */

    public boolean getCanGoNorth(){
        return this.canGoNorth;
    }

    /**
     * getCanGoSouth accessor method
     * used to determine if the player can move South
     * @return the value of canGoSouth
     */

    public boolean getCanGoSouth(){
        return this.canGoSouth;
    }

    /**
     * getCanGoEast accessor method
     * used to determine if the player can move East
     * @return the value of canGoEast
     */

    public boolean getCanGoEast(){
        return this.canGoEast;
    }

    /**
     * getCanGoWest accessor method
     * used to determine if the player can move West
     * @return the value of canGoWest
     */

    public boolean getCanGoWest(){
        return this.canGoWest;
    }

    /**
     * Mutator method called unlock
     * used to change the ability to move a given direction
     * @param direction a String value that changes the state of the provided direction if its locked
     * @return a String that meets the following conditions
    if the door is locked, the String returns "The door to the {direction} has been unlocked"
    if the door is already unlocked, the String returns "{direction} is already unlocked"
     */


    public String unlock(String direction){
        if (direction.equals("north")){
            if (canGoNorth) {
                return "north is already unlocked";
            }
            else {
                canGoNorth = true;
                return "The door to the north has been unlocked";
            }
        }
        else if (direction.equals("south")){
            if (canGoSouth ) {
                return "south is already unlocked";
            }
            else {
                canGoSouth = true;
                return "The door to the south has been unlocked";
            }
        }
        else if (direction.equals("east")){
            if (canGoEast){
                return "east is already unlocked";
            }
            else {
                canGoEast = true;
                return "The door to the east has been unlocked";
            }
        }
        else if (direction.equals("west")) {
            if (canGoWest ){
                return "west is already unlocked";
            }
            else {
                canGoWest = true;
                return "The door to the west has been unlocked";
            }
        }
        //this might be the invalid method later on
        return "";
    }












    /**
     * Mutator method called lock
     * used to change the ability to move a given direction
     * @param direction a String value that changes the state of the provided direction
     * @return a String that meets the following conditions
    if the door is unlocked, the String returns "The door to the {direction} has been locked"
    if the door is already locked, the String returns "{direction} is already locked"
     */

    public String lock(String direction){
        if (direction.equals("north")){
            if (canGoNorth) {
                canGoNorth = false;
                return "The door to the north has been locked";
            }
            else {
                return "north is already locked";
            }
        }
        else if (direction.equals("south")){
            if (canGoSouth) {
                canGoSouth = false;
                return "The door to the south has been locked";
            }
            else {
                return "south is already locked";
            }
        }
        else if (direction.equals("east")){
            if (canGoEast){
                canGoEast = false;
                return "The door to the east has been locked";
            }
            else {
                return "east is already locked";
            }
        }
        else if (direction.equals("west")) {
            if (canGoWest){
                canGoWest = false;
                return "The door to the west has been locked";
            }
            else {
                return "west is already locked";
            }
        }

        return "That is not a valid direction";
    }




    /**
     * toString accessor method
     * used to retrieve the state of the room you are in
     *
     * example output:
     * Kitchen
     * A room with a table and fridge
     * GoNorth: True GoSouth:False GoEast: True GoWest: True
     *
     * @return a String with the Room Name, Description, and the ability to move each direction
     */
    public String toString(){
        return name + "\n" + description + "\nGoNorth: " + canGoNorth + " Go South: " + canGoSouth + " Go East: " + canGoEast + " Go West: " +canGoWest;
    }



    /**
     * hasObject accessor method
     * uses a String to search through the objects in the Room to
     * determine if the object is present
     *
     * @param objectName - a String that is the name of the object
     * @return a boolean that is true if the object is in the Room
     *         and false if it is not
     */
    /*
     * TODO: Checkpoint 5 Task
     * make the hasObject method
     *
     */
    public boolean hasObject(String objectName) {
        for (InventoryItem item : inventory) {
            if (objectName.equals(item.getName())) {
                return true;
            }
        }
        return false;
    }

    public InventoryItem getObject(String objectName) {
        if (hasObject(objectName)) {
            for (InventoryItem item : inventory) {
                if (objectName.equals(item.getName())) {
                    return item;
                }
            }
        }

        return inventory.get(0);
    }

    /**
     * addObject mutator method
     * used to pass an Object to the room
     *
     * @param invObject - a InventoryItem object to be added to the room inventory
     */
    /*
     * TODO: Checkpoint 5 Task
     * make the addObject method
     *
     */
    public void addObject(InventoryItem invObject) {
        inventory.add(invObject);
    }

    /**
     * removeObject mutator method
     * used to remove an Object from the room and
     * pass it to the client code
     *
     * @param objName - a String that is the name of the object to pull from the room
     * @return an InventoryItem object that is the object to be pulled from the room
     *
     */
    /*
     * TODO: Checkpoint 5 Task
     * make the removeObject method
     *
     */
    public InventoryItem removeObject(String objName) {
        for (int i = 0; i < inventory.size(); i++) {
            if (objName.equals(inventory.get(i).getName())) {
                return inventory.remove(i);
            }
        }

        // what to return if it isn't in inventory?
        return inventory.get(0);
    }

    public boolean isEmpty() {
        return inventory.isEmpty();
    }

    /**
     * hasFurniture accessor method
     * used to see if the room has the corresponding furniture
     *
     * param fName - a String that is the name of the furniture that is checked
     * @return a boolean whether the room has furniture with fName
     */
    public boolean hasFurniture() {
        if (furniture.getName().equals("")) return false;

        return true;
    }

    /**
     * getFurniture accessor method
     * used to get furniture with a specific name from the room if it is in the furniture ArrayList if it is found
     *
     * param fName - a String that is the name of the furniture to be retrieved
     * @return Furniture object
     */

    public Furniture getFurniture() {
        return furniture;
    }

    /**
     * addFurniture mutator method
     * used to add furniture to the Room furniture ArrayList
     *
     * @param f - an object of type Furniture to be added
     * @return void
     */

    public void addFurniture(Furniture f) {
        furniture = f;
    }

    /**
     * getNamesOfObjectsInRoom accessor method
     * used to get the names of all of the Objects in the Room Inventory
     *
     * @return returns "Items in room are : " followed by the items in the room.
     *         If not items are in the room, then return "No items are in the room"
     */
    /*
     * TODO: Checkpoint 5 Task
     * make the getNamesOfObjectsInRoom method
     *
     */
    public String getNamesOfObjectsInRoom() {
        String output = "Items in " + name + " are :";
        for (InventoryItem item : inventory) {
            output += "\n" + item.getName();
        }

        return output;
    }

}
