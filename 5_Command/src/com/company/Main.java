package com.company;

import java.io.*;
import java.util.*;

public class Main {

    // Main is the client creates concrete command objects.
    public static void main(String[] args) {

        //Used for database and commands.
        Queue<Command> commandQueue = new ArrayDeque<>();
        Deque<Command> commandStack = new ArrayDeque<>();
        Map<String, ActiveDatabase> databaseMap = new HashMap<>();

        //used for parsing each line of the file.
        String selection = "";
        Scanner mainScanner = new Scanner(System.in);
        BufferedReader br;
        File file = null;
        String currentLine = "";
        String[] splitString;
        String command = "";
        String databaseId = "";
        String key = "";
        String value = "";

        while(!selection.equals("q")) {
            System.out.println("Please provide a file to process.");
            System.out.print("Enter q to quit: ");
            selection = mainScanner.nextLine();
            if (!selection.equals("q")) {
                try {
                    //Open file provided.
                    file = new File(selection);
                    br = new BufferedReader(new FileReader(file));

                    //Process the file
                    while((currentLine = br.readLine()) != null) {

                        splitString = currentLine.split("\\s+");

                        //Parse the string.
                        if (splitString.length >= 1 ) {
                            command = splitString[0];
                        }

                        if (splitString.length >= 2) {
                            databaseId = splitString[1];
                        }

                        if (splitString.length >= 3) {
                            key = splitString[2];
                        }

                        if (splitString.length >= 4) {
                            int i = 3;
                            //reset values value
                            value = "";
                            while (i < splitString.length) {
                                value += splitString[i++];
                                if (i <= splitString.length - 1) {
                                    value += " ";
                                }

                            }
                        }

                        //Create all the command objects.
                        switch (command) {
                            case "A":
                                commandQueue.add(new AddCommand(new AddObject(databaseMap, databaseId, key, value)));
                                break;
                            case "U":
                                commandQueue.add(new UpdateCommand(new UpdateObject(databaseMap, databaseId, key, value)));
                                break;
                            case "R":
                                commandQueue.add(new RemoveCommand(new RemoveObject(databaseMap, databaseId, key)));
                                break;
                            case "B":
                                break;
                            case "E":
                                break;
                        }
                    }

                    //close file opened.
                    br.close();

                } catch (FileNotFoundException f) {
                    System.out.println("File not found: " + file);
                } catch (IOException e) {
                    System.out.println("Unable to process.\n " + e );
                }

                for (Command c : commandQueue) {
                    //run execute then push to commandProcessedStack
                    c.execute();
                    //add the command to the list of commands run.
                    commandStack.push(c);
                }

                //Print out the database
                databaseMap.forEach((k,v)->{
                    System.out.println("Database: " + k + " " + v.toString());
                });

                Command undoCommand;
                while(!commandStack.isEmpty()) {
                    undoCommand =  commandStack.pop();
                    undoCommand.undo();
                }

                //Print out the database
                databaseMap.forEach((k,v)->{
                    System.out.println("Database: " + k + " " + v.toString());
                });
            }
        }
    }
}
