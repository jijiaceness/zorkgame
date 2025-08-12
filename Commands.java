package classes;

import java.util.*;
import java.io.*;

/**
 * Creates the class Commands,
 * There will only be one instance used by the game
 * therefore all of its methods are static to prevent multiple
 */
public class Commands {
        /*
         * TODO: checkpoint 4 Tasks
         *
         * add class level variables
         * Declare a two dimensional array called "map" it should be of type "Room"
         * Declare two variables of type int called "row" and "column"
         * Declare a Room object called currentRoom
         *
         * note that these variables should be "static" because there should only be one world
         */
        static Room[][] map = new Room[5][5];
        static ArrayList<InventoryItem> inventory = new ArrayList<InventoryItem>();
        static int row;
        static int column;
        static Room currentRoom = new Room();
        static boolean untiedH = false;
        static boolean maskOn = false;
        static boolean usedScissors = false;
        static boolean readLetter = false;
        static int numSteps = 0;

        // booleans that hold whether furniture was opened
        static boolean cupboardOpen = false;
        static boolean drawerOpen = false;
        static boolean cabinetOpen = false;
        static int lifePoints = 30;

/**
 * runGame method
 * method responsible for running a console version of the game
 * this method returns nothing and has no parameters
 * it contains the while loop that is used to run the game
 */

        public static void runGame() {


        /*
         * TODO: checkpoint 4 Tasks
         *
         * initialize your map
         *
         * then construct each room of your world,
         * be sure they match the correct locations of you map and have the appropriate
         * passages set to true and false
         * Any spot in your map that is not used should be built with the default constructor
         *
         * HINT: The upper left is row 0 and column 0
         */
        map[0][0] = new Room();
        map[0][1] = new Room();
        map[0][2] = new Room();

        Room homeEntrance = new Room(false, true, true, false, "Entrance to Home",
                "After a long journey, you arrive at last to the front door of your home.\n" +
                "The walls are a baby blue, tainted by only a few rogue vines.\n" +
                "You see the oak door with its brass handles and lock, inviting you to go in.\n");

        map[0][3] = homeEntrance;

        Room home = new Room(false, false, false, false, "Home",
                "You open the door and are at last greeted with smooth wooden floors and, to\n" +
                "your surprise, a cozy, crackling fireplace. In front of the fireplace are two\n" +
                "velvet sofas and a table with a letter on it.\n");
        map[0][4] = home;

        // second row
        map[1][0] = new Room();
        map[1][1] = new Room();
        map[1][2] = new Room();

        Room bowerNest = new Room(false, true, false, false, "Bower Bird's Nest",
                "As you walk up the creek, you see a peculiar structure made with twigs\n" +
                "and many shiny items scattered around it, including a shiny silver key.\n" +
                "You need the key, but you can’t just steal it from the bird who made this.\n");
        map[1][3] = bowerNest;

        map[1][4] = new Room();
        // third row
        map[2][0] = new Room();
        map[2][1] = new Room();

        Room northPath = new Room(true, true, false, false, "North Path",
                "The forest is now silent as the sun sets, and soon stars glitter through\n" +
                        "the canopy of the trees. You don’t know why, but something about this path\n" +
                        "just feels right to you.\n");
        map[2][2] = northPath;

        Room creek = new Room(true, false, true, false, "Creek",
                "You come into sight of a babbling creek, the water bright blue and clear.\n" +
                        "The healer said the water was safe to drink, if only you had something to\n" +
                        "drink with ...");
        map[2][3] = creek;

        Room eastClearing = new Room(false, true, false, true, "East Clearing",
                "You find yourself in a small clearing. The grass feels soft under your feet\n" +
                        "and small breeze glides past you. You hear the babbling of water in the\n" +
                        "distance. Trees and bushes of berries block your path west.\n");
        map[2][4] = eastClearing;
        // fourth row
        Room bear = new Room(false, true, false, false, "Clearing with a Natural Enemy",
                "You continue past the clearing when you suddenly stop in your tracks.\n" +
                        "A huge black bear looms suddenly from the now menacing darkness of the\n" +
                        "forest. Something gold glitters from its neck. If you don’t do something soon,\n" +
                        "your dream of finding your home in this forest will be gone forever.\n");
        map[3][0] = bear;

        Room houseKey = new Room(false, false, true, false, "Bedroom",
                "As you enter, you see a bed in the corner, the sheets freshly cleaned.\n" +
                        "A cabinet sits next to the bed, and a beautiful rug covers the center\n" +
                        "of the room.\n");
        map[3][1] = houseKey;

        Room kitchen = new Room(false, true, false, false, "Kitchen",
                "As you enter the kitchen, you notice a fine layer of dust covering the\n" +
                        "countertops. Above the countertop, you can see a small cupboard.\n" +
                        "A water skin lies on the table, seemingly empty, with a small bag of jewels\n" +
                        "beside it. There are three doors past the kitchen, and all appear locked.\n");
        map[3][2] = kitchen;

        Room office = new Room(false, false, false, true, "Office",
                "The door cracks open, leading you to a dimly lit room. There are bookshelves\n" +
                        "lining all walls, save for a study desk with a drawer near the small window.\n" +
                        "Upon closer inspection, there seems to be a book on the desk.\n");
        map[3][3] = office;

        Room healerHut = new Room(true, true, false, false, "Healer's Hut",
                "As you enter, you notice the overwhelming scent of various herbs.\n" +
                        "Small bags and beakers line the many shelves. The healer scurries around\n" +
                        "while you take in your surroundings.\n" +
                        "\"There are many dangers in these woods and you might need protection,\" the\n" +
                        "healer said, walking towards you with two items, a mask and some bag in\n" +
                        "his arms.\n" +
                        "\"Please, take them as a gift for your kindness.\"\n" +
                        "You don't see how these things could help you fend off any threats, but\n" +
                        "you couldn't just leave the healer hanging.\n");
        map[3][4] = healerHut;
        // fifth row
        Room westClearing = new Room(true, false, true, false, "West Clearing",
                "You find yourself in another clearing. The grass feels soft under your feet\n" +
                        "and a small breeze glides past you. This time, bushes of berries cover the\n" +
                        "sides behind and to the left of you.\n");
        map[4][0] = westClearing;

        Room westPath = new Room(false, false, true, true, "West Path",
                "Birds are chirping in the distance and the trees give you welcome relief from\n" +
                        "the sun. The fallen leaves crunch under your feet as you walk.\n");
        map[4][1] = westPath;

        Room cottage = new Room(true, false, true, true, "Cottage",
                "In front of you is a worn-down cottage, with weeds growing from the crevices.\n" +
                        "The house is framed by tall trees and the door is slightly ajar.\n");
        map[4][2] = cottage;

        Room eastPath = new Room(false, false, true, true, "East Path",
                "Birds are chirping in the distance and the trees give you welcome relief from\n" +
                        "the sun. The fallen leaves crunch under your feet as you walk.\n");
        map[4][3] = eastPath;

        Room tiedHealer = new Room(false, false, false, true, "Entrance to Hut",
                "The trees part and you find yourself in front of another hut. Before you can\n" +
                        "inspect further, a desperate cry catches your attention. An old man is tied \n" +
                        "to a tree with rope for who knows how long. He wiggles his arms to emphasize\n" +
                        "his awkward situation.\n");
        map[4][4] = tiedHealer;

        // inserting all objects into corresponding rooms
        // kitchen
        Liquid waterSkin = new Liquid("water skin", "An empty flask that is able to hold water");
        Tool jewels = new Tool("bag of jewels",
                "A bag containing shining, sparkling gems", 0.2, bowerNest);
        ArrayList<Room> sc = new ArrayList<>();
        sc.add(tiedHealer);
        sc.add(bear);
        Tool scissors = new Tool("scissors", "An object for cutting something", 0.4, sc);
        Furniture cupboard = new Furniture("cupboard", "There are a pair of scissors lying inside.",
                scissors, false);
        kitchen.addFurniture(cupboard);
        kitchen.addObject(waterSkin);
        kitchen.addObject(jewels);
        kitchen.addObject(scissors);
        // map room
        String o = "You flip through the pages of the book. It seems to contain useful\n" +
                "information about the various plants and fauna that you found while exploring.\n";
        Document plantDoc = new Document("plant book", "A book that says IDENTIFYING FLORA on the cover",
                0.1, o);
        Key bronzeK = new Key("bronze key", "Key used to unlock some door in the cottage",
                kitchen, "west");
        Furniture drawer = new Furniture("drawer", "There is a bronze key inside.", bronzeK, false);
        office.addFurniture(drawer);
        office.addObject(plantDoc);
        office.addObject(bronzeK);
        // house key room
        Key houseK = new Key("house key", "Key used to unlock some door", homeEntrance, "east");
        Furniture cabinet = new Furniture("cabinet", "There is a key with a small inscription\n" +
                "that said \"HOUSE\".", houseK, false);
        houseKey.addFurniture(cabinet);
        houseKey.addObject(houseK);
        // bower bird's nest
        Key silverK = new Key("silver key", "Silver key used to unlock a door. You remember that \nthere were several locked doors in the cottage, maybe this could be used there",
                kitchen, "east");
        bowerNest.addObject(silverK);
        // bear
        Key goldK = new Key("gold key", "Gold key used to unlock a door.You remember that there were several locked doors in the cottage, maybe this could be used there",
                kitchen, "north");
        bear.addObject(goldK);
        // healer's hut
        Tool dust = new Tool("dust bag", "A bag containing fine dust that," +
                "according to the healer, could put someone to sleep", 0.1, bear);
        Tool mask = new Tool("mask", "Aask to protect whoever opens the dust bag", 0.05);
        healerHut.addObject(dust);
        healerHut.addObject(mask);
        // east clearing
        Food b1 = new Food("berries", "Food that could provide some sustenance", 0.2, 10);
        eastClearing.addObject(b1);
        // west clearing
        Food b2 = new Food("berries", "Food that could provide some sustenance", 0.2, 10);
        westClearing.addObject(b2);
        // home
        String letterC =
                "~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-\n" +
                        "|                                                                            |\n" +
                        "| Dear apprentice,                                                           |\n" +
                        "|                                                                            |\n" +
                        "| Congratulations for completing the quest. This was designed to test your   |\n" +
                        "| resourcefulness and ability to think out of the box. By reaching here, you |\n" +
                        "| have proved that you are a worthy recipient of the RANGER title and are    |\n" +
                        "| qualified to guard this part of the forest. About the cottage, you can use |\n" +
                        "| it as an office space, but please clean it regularly. Remember your        |\n" +
                        "| training and keep working hard.                                            |\n" +
                        "|                                                                            |\n" +
                        "| Sincerely,                                                                 |\n" +
                        "| The Ranger Corps                                                           |\n" +
                        "|                                                                            |\n" +
                        "~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-\n";
        Document letter = new Document("letter", "letter welcoming you in to your home",
                0.1, letterC);
        home.addObject(letter);

        /*
         * TODO: checkpoint 4 Tasks
         *
         * initialize the values for your variables "row" and "column"
         * to represent the starting location of your game,
         * then set the currentRoom to the starting location
         *
         */
        row = 4;
        column = 2;
        currentRoom = map[4][2];

        String userInput = "";
        String command = "";
        String item = "";
        Scanner s = new Scanner(System.in);

//TODO: When you have made your game work in the console
//change done to true to play your game in the JFrame
        boolean done = false;
        String output ="";
        if(!done){
            output = gameIntro();
            System.out.println(output);
        }

        while(!done){
            System.out.print("\n\n>>");
            userInput = s.nextLine().toLowerCase();
            command = getFirstWord(userInput);
            item = getRestOfSentence(userInput);
            if (readLetter) {
                if (userInput.equals("yes")) {
                    inventory.clear();
                    runGame();
                    break;
                } else if (userInput.equals("no")) {
                    System.out.println("Thank you for playing!");
                    break;
                }
            }
            output = executeCommand(command, item);

            /*
             * TODO: checkpoint 4 Task
             *
             * Update the currentRoom to the new location on the map
             * Hint: there is a new method for this, go to the bottom and make it
             * using the currentRoom object.
             */
            updateRoom();
            if (numSteps == 10) {
                westPath = new Room(false, false, true, true, "West Path",
                        "The fallen leaves crunching under your feet are the only sound you hear\n" +
                                "as you’re walking. The illuminating stars in the sky provide a little\n" +
                                "light against the dark woods.\n");
                map[4][1] = westPath;
                eastPath = new Room(false, false, true, true, "East Path",
                        "The fallen leaves crunching under your feet are the only sound you hear\n" +
                                "as you’re walking. The illuminating stars in the sky provide a little\n" +
                                "light against the dark woods.\n");
                map[4][3] = eastPath;
                northPath = new Room(true, false, true, false, "North Path",
                        "The forest is now silent against the dark blue sky, and stars glitter through\n" +
                                "the canopy of the trees. You don't know why, but something about this path\n" +
                                "feels right to you.\n");
                map[2][2] = northPath;
                creek = new Room(true, true, false, false, "Creek",
                        "As you walk, you hear the gentle gurgling of the creek. The water\n" +
                                "shines with the reflection of the clear night sky, as if the galaxy itself\n" +
                                "was flowing through the land.\n");
                map[2][3] = creek;
            }
            if (lifePoints < 5) {
                System.out.println("You continue walking, but your limbs grow weak and you\n" +
                        "fall to the ground. The last thing you see is the ground below you, and \n" +
                        "everything turns to black.");
                done = true;
                break;
            }

            System.out.println(output +"\n");
            if (output.substring(output.length() - 6).equals("teeth.")) {
                done = true;
            }

            if(command.equals("quit"))
                done = true;
        }
        s.close();
    }

/**
 * gameIntro method
 * used to set the scene to the opening of your game
 * @return: a String that is the opening description to your game,
 *          be sure to note the help option
 *          (i.e. "type help for a list of commands").
 */

//TODO: Update this to your Intro (copy and paste it here)
        public static String gameIntro(){
        return map[row][column].getDescription()
                + "\n (Type \"help\" to see alist of commands)";
    }

/**
 * getFirstWord method
 * pulls the first word out of any phrase (1 or more words)
 * param a string that contains the commands from the user
 * @return a string that is only the first word,
 *         returns a blank string "" if nothing entered,
 *         do not use print or println
 */

        public static String getFirstWord(String input){
        int spaceLocation = input.indexOf(" ");
        if(spaceLocation > 0)
            return input.substring(0,spaceLocation);
        if(input.length() >0)
            return input;
        return "";
    }

/**
 * getRestOfSentence
 * pulls everything after the first word and the space behind it
 * parameters string that contains the commands from the user
 * return a string that returns everything after the first word
 *         and the space behind it, returns a blank string "" if 1 word entry
 *         or nothing entered.
 *         Do not use print or println
 */

        public static String getRestOfSentence(String input){
        int spaceLocation = input.indexOf(" ");
        if(spaceLocation >= 0)
            return input.substring(spaceLocation+1);
        return "";
    }


/**
 * north method
 * Method to state that you moved north, you will add movement functionality
 * in checkpoint 4
 * @return a string that states you moved North, do not use print or println
 */

        /*
         * TODO: checkpoint 4 Task
         *
         * Update the "north" method to allow the player to move North only if possible
         * Be sure to both move the player north and state that the player moved North
         * If you cannot move North, then state that you cannot move North
         */

        public static String north(){
        // need to add North Path if statement
        // check if healer was untied bc only then would you reach the hut
        if (row == 4 && column == 4) {
            if (untiedH) {
                row--;
                numSteps++;
                lifePoints--;
                return "You moved North.";
            } else {
                row -= 2;
                numSteps++;
                lifePoints--;
                return "You moved North.";
            }
        }
        if (row == 2 && column == 2) {
            row = 0;
            column = 3;
            numSteps++;
            lifePoints--;
            return "You moved North.";
        }
        if (currentRoom.getCanGoNorth()) {
            row--;
            numSteps++;
            lifePoints--;
            return "You moved North.";
        }
        return "You cannot move North.";
    }



/**
 * south method
 * Method to state that you moved south, you will add movement functionality
 * in checkpoint 4
 * @return a string that states you moved South, do not use print or println
 */

        /*
         * TODO: checkpoint 4 Task
         *
         * Update the "south" method to allow the player to move South only if possible
         * Be sure to move the player South and state that the player moved South
         * If you cannot move South, then state that you cannot move South
         */
        public static String south(){
        if (row == 2 && column == 4) {
            if (untiedH) {
                row++;
                numSteps++;
                lifePoints--;
                return "You moved South.";
            } else {
                row += 2;
                numSteps++;
                lifePoints--;
                return "You moved South.";
            }
        }
        if (row == 0 && column == 4) {
            row = 2;
            column = 2;
            numSteps++;
            lifePoints--;
            return "You moved South.";
        }
        if (currentRoom.getCanGoSouth()) {
            row++;
            numSteps++;
            lifePoints--;
            return "You moved South.";
        }
        return "You cannot move South.";
    }

/**
 * east method
 * Method to state the you moved East,  you will add movement functionality in
 * checkpoint 4
 * @return a string that states you moved East, do not use print or println
 */

        /*
         * TODO: checkpoint 4 Task
         *
         * Update the "east" method to allow the player to move East only if possible
         * Be sure to both move the player East and state that the player moved East
         * If you cannot move East, then state that you cannot move East
         */
        public static String east(){
        if (currentRoom.getCanGoEast()) {
            column++;
            numSteps++;
            lifePoints--;
            return "You moved East.";
        }
        return "You cannot move East.";
    }

/**
 * west method
 * Method to state the you moved West, you will add movement functionality in
 * checkpoint 4
 * @return a string that states you moved West, do not use print or println
 */

        /*
         * TODO: checkpoint 4 Task
         *
         * Update the "west" method to allow the player to move West only if possible
         * Be sure to move the player West and state that the player moved West
         * If you cannot move West, then state that you cannot move West
         */

        public static String west(){
        if (currentRoom.getCanGoWest()) {
            column--;
            numSteps++;
            lifePoints--;
            return "You moved West.";
        }
        return "You cannot move West.";
    }

/**
 * take method
 * Method to allow you to take an item, for now you will just state that
 * "You took the <itemName>." where <itemName> is the actual name of the item.
 *
 * example return statement:
 * "You took the apple."
 *
 * You will actually pick up items in checkpoint 5
 *
 * param takes in a String to determine what object was picked up
 * @return a String that states "You took the <itemName>", do not use print or println
 */

        public static String take(String item){
        if (currentRoom.hasObject(item)) {
            if (currentRoom.hasFurniture()) {
                Furniture f = currentRoom.getFurniture();
                if (f.getItem() != null && item.equals(f.getItem().getName())) {
                    if (f.isOpen()) {
                        currentRoom.removeObject(item);
                        inventory.add(f.removeItem(item));
                        return "You took the " + item + ".";
                    } else {
                        return "The " + f.getName() + " isn't open yet.";
                    }
                }
            }

            if (item.equals("silver key") && row == 1 && column == 3) {
                if (!currentRoom.hasObject("jewels")) {
                    return "You have to give something to the bower's nest in exchange \n" +
                            "to taking the silver key.";
                }

                currentRoom.setDescription("As you walk up the creek, you see a peculiar structure made with twigs\n" +
                        "and many shiny items scattered around it, including the jewels you put down.\n");
            }

            if (item.equals("gold key") && row == 3 && column == 0) {
                if (!currentRoom.hasObject("dust bag")) {
                    return "You tried to snatch the key from the bear's neck, but the bear \n" +
                            "was too quick. The last thing you see is the bear's sharp teeth.";
                }

                if (usedScissors) {
                    inventory.add(currentRoom.removeObject(item));
                    return "You took the gold key while glancing at the bear to make sure it \n" +
                            "was asleep. Even though there is no threat now, you still want to leave \n" +
                            "as soon as possible.";
                } else {
                    return "You need to use something to cut the gold key from the bear's neck.\n";
                }
            }

            if (item.equals("jewels") && row == 1 && column == 3) {
                if (currentRoom.hasObject(item)) {
                    return "You can't possibly take the jewels from the bower bird's nest when\n" +
                            "you just took the silver key from the nest.\n";
                }
            }

            if ((item.equals("bag of jewels") || item.equals("water skin")) && row == 3 && column == 2) {
                currentRoom.setDescription("As you enter the kitchen, you notice a fine layer of dust covering the\n" +
                        "countertops. Above the countertop, you can see a small cupboard.\n" +
                        "There are three doors past the kitchen.\n");
            }

            if (item.equals("dust bag") || item.equals("mask")) {
                currentRoom.setDescription("As you enter, you notice the overwhelming scent of various herbs.\n" +
                        "Small bags and beakers line the many shelves. The healer scurries around to\n" +
                        "collect ingredients for a mysterious potion in the center of the room.\n");
            }

            inventory.add(currentRoom.removeObject(item));

            return "You took the " + item +".";
        }
        return item + " is not in the " + currentRoom.getName() + ".";
    }

/**
 * drop method
 * Method to allow you to drop an item, for now you will just state that
 * "You dropped the <itemName>." where <itemName> is the actual name of the item.
 *
 * example return statement:
 * "You dropped the apple."
 *
 * You will actually drop items in checkpoint 5
 * param takes in a string to determine what object was dropped
 * @return a string that states "You dropped the <itemName>", do not use print or println
 */

        public static String drop(String objectName){
        for (int i = 0; i < inventory.size(); i++) {
            if (objectName.equals(inventory.get(i).getName())) {
                if (objectName.equals("bag of jewels")) {
                    return use("bag of jewels");
                }
                currentRoom.addObject(inventory.get(i));
                inventory.remove(i);
                return "You dropped the " + objectName +".";
            }
        }
        return "the " + objectName + " is not in your inventory";
    }

/**
 * look method
 * Method to allow you to look around the room
 * In checkpoint3, this will change to the room description
 *  @return a string that states "You looked around the room", do not use print or println
 */

        /*
         * TODO: checkpoint 4 task
         *
         * update the "look" method to return the Name of the Room,
         * then a new line, and then the room's description instead of its current output.
         */

        public static String look(){
        String look = currentRoom.getName() + "\n" + currentRoom.getDescription();
        if (currentRoom.isEmpty())
            return look;

        return look + "\n" + currentRoom.getNamesOfObjectsInRoom();
    }

/**
 * inventory method
 * Method to display the items in your inventory, for now state
 * "The current items in your inventory are:"
 *
 * In checkpoint 5 you will create a String that consists of all of the
 * items in your inventory
 *  @return the "The current items in your inventory are:", do not use print or println
 */

        public static String inventory(){
        String output ="";
        for (InventoryItem item : inventory) {
            output += item.getName() + "\n";
        }
        //TODO add checkpoint inventory logic here
        return "The current items in your inventory are: \n" + output;
    }



/**
 * examine method
 * Method that returns the description on an item in your inventory, for now state:
 * "Description of <itemName>" where <itemName> is the itemName
 *
 * example return statement:
 * "Description of apple"
 *
 * In checkpoint 5 you will return the description of the object you are examining
 * param takes in a string to determine what item you want the description of
 * @return a string that is the description of the item, do not use print or println
 */


        public static String examine(String item){
        // return currentRoom.getObject(item).getDescription();
        for (InventoryItem i : inventory) {
            if (item.equals(i.getName())) {
                return i.getDescription();
            }
        }

        return "This item is not in your inventory.";
    }

/** read method
 * Method that allows you to read a Document object
 *
 * param takes in String that is the name of the document you want to read
 * @return a string of the contents in the document
 */
        public static String read(String item) {
        for (InventoryItem i : inventory) {
            if (item.equals(i.getName())) {
                if (i instanceof Document) {
                    String output = ((Document) i).getContents();
                    if (i.getName().equals("letter")) {
                        readLetter = true;
                        InventoryItem badge = new InventoryItem("Ranger badge",
                                "A gold badge that shows your admittance into the Ranger Corps", 0.2);
                        output += "You find the golden Ranger Badge behind the letter and pin it\n" +
                                "to your clothes, proud that you passed the test.\n" +
                                "You're ready to face the challenges that this job will bring.\n" +
                                "\nPlay again?";
                        inventory.add(badge);
                    }

                    return output;
                }

                return "This item is not a document.";
            }
        }

        return "This item is not in your inventory.";
    }

/**
 * eat method
 * Method that allows you to eat a Food object, for now state:
 * "You ate the <itemName>" where <itemName> is the name of the itemName
 *
 * example return statement:
 * "You ate the apple."
 *
 * In checkpoint 5, you will update this method to remove it from your inventory,
 * but not drop it in the room.  Advanced: this could be useful for a health system
 *
 *
 * param takes in a string to determine what item you want to eat
 * @return a string that states you ate the item, do not use print or println
 */

        public static String eat(String item){
        for (int i = 0; i < inventory.size(); i++) {
            InventoryItem temp = inventory.get(i);
            if (item.equals(temp.getName())) {
                if (temp instanceof Food && !(temp instanceof Liquid)) {
                    lifePoints += ((Food) temp).eat();
                    inventory.remove(i);
                    i--;
                    return "You ate the " + item + ".";
                } else {
                    return "This item is not food that you can eat.";
                }
            }
        }
        return "This item is not in your inventory.";
    }

/**
 * drink method
 * Method that allows you to drink an item that is of type Liquid and in your inventory
 *
 * param takes item to determine what you want to drink
 * @return a String that states you drank the item
 */

        public static String drink(String item) {
        for (int i = 0; i < inventory.size(); i++) {
            InventoryItem temp = inventory.get(i);
            if (item.equals(temp.getName())) {
                if (temp instanceof Liquid) {
                    int energy = ((Liquid) temp).drink();
                    if (energy == 0) {
                        return "You start to drink from the " + item + " but unfortunately find not a single \ndrop in there.";
                    }

                    return "You drank from the " + item + ".";
                } else {
                    return "You can't drink from this item.";
                }
            }
        }
        return "This item is not in  your inventory, you need a container to drink from.";
    }

/**
 * fill method
 * Method that allows you to fill an item with water or another liquid
 *
 * param String item that you want to fill
 * @return String that states you filled the item
 */
        public static String fill(String item) {
        for (int i = 0; i < inventory.size(); i++) {
            InventoryItem temp = inventory.get(i);
            if (item.equals(temp.getName())) {
                if (temp instanceof Liquid) {
                    if (column == 3 && (row == 1 || row == 2)) {
                        return ((Liquid) temp).fill();
                    }

                    return "You can't fill the " + item + " here.";
                } else {
                    return "You can't fill this item.";
                }
            }
        }
        return "This item is not in  your inventory.";
    }

/**
 * use method
 * Method that allows you to use an item it, for now state:
 * "You used the <itemName>", where <itemName> is the name of the item.
 *
 * example return statement:
 * "You used the apple."
 *
 * In checkpoint 5 this will be updated to only allow the player to use a Key
 * in the room where the key can open a door
 *
 * param takes in a string to determine what item you want to use
 * @return a string that You used the item, do not use print or println
 */

        public static String use(String item){
        InventoryItem temp = null;
        for (InventoryItem i : inventory) {
            if (item.equals(i.getName())) {
                temp = i;
                break;
            }
        }

        if (temp != null) {
            String output = "";
            if (temp instanceof Food) {
                if (temp instanceof Liquid) {
                    return drink(item);
                }

                return eat(item);
            } else if (temp instanceof Tool) {
                if (temp instanceof Key) {
                    output += ((Key)temp).use(currentRoom);
                    if (!output.equals("You're not using this key in the right place.")) {
                        executeCommand(((Key) temp).getDirection(), "");
                        updateRoom();
                        output += "\n\n" + look();
                    }

                    return output;
                }

                if (item.equals("scissors")) {
                    if (row == 4 && column == 4) {
                        untiedH = true;
                        currentRoom.setDescription("You come across the clearing with the tree the healer\n" +
                                "was stuck to. You shake your hand in wonder. What a peculiar guy.\n");
                        return "You used the scissors to cut the rope and freed the stranger.\n" +
                                "\"Thank goodness you came, I thought I was gonna be stuck there forever!\"\n" +
                                "the stranger exclaimed. You were curious why he was tied up in the first place, \n" +
                                "but before you could ask, the stranger said,\n" +
                                "\"I have something in my hut to give you in exchange for you kindness,\"\n" +
                                "beckoning you into his home up ahead north.";
                    }
                    if (row == 3 && column == 0) {
                        if (!currentRoom.hasObject("dust bag")) {
                            return "You made a valiant effort with your mighty scissors against\n" +
                                    "the bear, but the bear simply swatted it away. The last thing you\n" +
                                    "saw was the bear's sharp teeth.";
                        }

                        usedScissors = true;
                        return "You used the scissors to cut the gold key off of the now sleeping\n" +
                                "bear's neck, careful to not wake it.";
                    }
                }

                if (item.equals("dust bag")) {
                    if (row == 3 && column == 0) {
                        if (maskOn) {
                            drop("dust bag");
                            currentRoom.setDescription("You see the bear still peacefully sleeping in its lair.\n" +
                                    "Despite it being asleep, you want to get out of here as soon as possible in\n" +
                                    "case the bear wakes up.\n");
                            return "You opened the dust bag and threw it at the bear as it charged towards\n" +
                                    "you. You dodged as the bear thrashed around wildly, trying to disperse the\n" +
                                    "dust. You hope the healer wasn't lying about the dust's properties.\n\n" +
                                    "You let out a sigh of relief when the bear drops and begins to snore. The\n" +
                                    "gold key is now within reach on the rope. If only you had something to\n" +
                                    "cut it with ...\n";
                        } else {
                            return "You release the dust bag but end up falling asleep yourself.\n" +
                                    "The last thing you see is the bear charging at, blaring its sharp teeth.";
                        }
                    }

                    return "You can't use the dust bag here.\n";
                }

                if (item.equals("mask")) {
                    if (row == 3 && column == 0) {
                        maskOn = true;
                        return "You hurriedly put on the mask and lock eyes with the bear.\n" +
                                "You need to do something quick or you'll be the bear's next meal.\n";
                    }

                    return "There is no need to put on the mask here.\n";
                }

                if (item.equals("bag of jewels")) {
                    if (row == 1 && column == 3) {
                        for (int i = 0; i < inventory.size(); i++) {
                            if (inventory.get(i).getName().equals("bag of jewels")) {
                                inventory.remove(i);
                            }
                        }
                        InventoryItem jewels = new InventoryItem("jewels", "shiny gems in the bower bird's nest", 0.2);
                        currentRoom.addObject(jewels);

                        InventoryItem bag = new InventoryItem("bag", "an empty bag that originally contained the jewels",
                                0.05);
                        inventory.add(bag);
                        return "You kneel, carefully take the jewels out of the bag, and arrange it around\n" +
                                "the nest. You stand back up, satisfied that you didn't make an enemy.\n";
                    }
                }

                return ((Tool) temp).use(currentRoom);
            } else {
                return "You can't use this item.";
            }
        }
        return "This item is not in your inventory.";
    }

/***
 * open method
 * Method that allows you to open furniture with doors
 *
 * example return statement:
 * "You opened the cupboard. There is *object* inside."
 *
 * param takes in string to determine what you want to open
 * @return a string like above
 */
        public static String open(String item) {
        if (currentRoom.hasFurniture()) {
            return currentRoom.getFurniture().open();
        }
        return "There is no " + item + " here.";
    }

/**
 * close method
 * Method that closes furniture that can be closed
 *
 * example of return system:
 * "You closed the cupboard."
 *
 * param takes in string to determine what you want to close
 * @return returns string like above
 */
        public static String close(String item) {
        if (currentRoom.hasFurniture()) {
            return currentRoom.getFurniture().close();
        }
        return "There is no " + item + " here.";
    }

/**
 * help method
 * Method that returns all of the commands and what they do
 *
 * example return output:
 * "Command      Example      Description
 *  take         take apple   used to pick up objects"
 *
 * @return a String that contains all the command names, an example of use, and a description of what they do.  Be sure to consider readability of the player.  Do not use print or println.
 */

        public static String help(){
        return "The following commands are used to play the game\n"
                + "Command    Example          Description\n"
                + "North      North            Allows you to move North\n"
                + "South      south            Allows you to move South\n"
                + "East       east             Allows you to move East\n"
                + "West       west             Allows you to move West\n"
                + "Look       Look             Provides a detailed descriptoin of the room\n"
                + "Take       take key         Adds an item in a room to your inventory\n"
                + "Drop       drop key         Removes an item from your inventory and leaves it in the room\n"
                + "Inventory  inventory        Displays the names of items in your inventory\n"
                + "Examine    examine key      Provides a detailed description of the specified item, it must be in your inventory\n"
                + "Read       read letter      Provides the contents of the document you want to read\n"
                + "Eat        eat apple        Allows you to eat an edible item\n"
                + "Drink      drink water      Allows you to drink from a drinkable item\n"
                + "Fill       fill water skin  Allows you to fill a drinkable item from a source\n"
                + "Use        use key          Allows you to use the item\n"
                + "Open       open drawer      Allows you to open door of furniture if allowed\n"
                + "Close      close drawer     Allows you to close door of furniture if allowed\n"
                + "Help       help             Displays the help menu\n"
                + "Quit       quit             Player initiated end of game\n";
    }


/**
 * quit Method
 * Method that states "You have decided to quit the game"
 * @return a message saying You have decided to quit the game, do not use print or println
 */

        public static String quit(){
        return "You have decided to quit the game.";
    }

/**
 * invalid method
 * Method called when a player tries a command that is not used in the game
 * @return message "I do not understand", do not use print or println
 */

        public static String invalid(){
        return "I do not understand.";
    }

/**
 * executeCommand method
 * This method uses the first word to call the appropriate method that you
 * made above.  Basically, this method manages complexity by hosting the
 * logic to detemine which method should be used.
 * (for example, if the command is north, call the north() method).
 * param the String command used to check which method to call
 * param the String item used for methods that interact with objects
 * @return a String that is passed back from the appropriate method,
 *         do not use print or println
 */

        public static String executeCommand(String command, String item) {
        if(command.equals("north"))
            return north();
        if(command.equals("south"))
            return south();
        if(command.equals("east"))
            return east();
        if(command.equals("west"))
            return west();
        if(command.equals("inventory"))
            return inventory();
        if(command.equals("look"))
            return look();
        if(command.equals("take"))
            return take(item);
        if(command.equals("drop"))
            return drop(item);
        if(command.equals("examine"))
            return examine(item);
        if(command.equals("read"))
            return read(item);
        if(command.equals("eat"))
            return eat(item);
        if(command.equals("drink"))
            return drink(item);
        if(command.equals("fill"))
            return fill(item);
        if(command.equals("use"))
            return use(item);
        if(command.equals("open"))
            return open(item);
        if(command.equals("close"))
            return close(item);
        if(command.equals("help"))
            return help();
        if(command.equals("quit"))
            return quit();
        return invalid();

    }

/**
 * updateRoom method
 * Method to update the room you are in (currentRoom)
 * this method uses the row and column values to
 * update the currentRoom location
 * no parameters or return values
 */
        /*
         * TODO: checkpoint 4 Task
         *
         * make the updateRoom method
         */
    public static void updateRoom() {
        currentRoom = map[row][column];
    }

/**
 *     getCurrentRoom method
 *  In order to work with the JFrame, we need a way to get the room
 *  create an accessor method that returns the currentRoom called getCurrentRoom
 *  @return the current room, but sure to update the room first
 */

        /*
         * TODO: checkpoint 4 Task
         *
         * make the getCurrentRoom method
         */
    public static Room getCurrentRoom() {
        updateRoom();
        return currentRoom;
    }

        //DO NOT TOUCH

    public static void main (String[] args) {
        runGame();
    }

}
