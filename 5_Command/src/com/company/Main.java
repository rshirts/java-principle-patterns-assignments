package com.company;

import java.io.*;
import java.util.*;

public class Main {

    // Main is the client creates concrete command objects.
    public static void main(String[] args) {

        //Used for database and commands.
        Queue<Command> commandQueue = new ArrayDeque<>();
        Map<String, ActiveDatabase> databaseMap = new HashMap<>();


        //used for parsing each line of the file.
        String selection = "";
        Scanner mainScanner = new Scanner(System.in);
        BufferedReader br;
        File file = null;
        String currentLine;
        String[] splitString;
        String command = "";
        String databaseId = null;
        String key = null;
        String value = null;


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
                            while (i < splitString.length) {
                                value += splitString[i++];
                            }
                        }

                        //Create all the command objects.
                        switch (command) {
                            case "A":
                                commandQueue.add(new AddCommand(new AddObject(databaseMap, databaseId, key, value)));
                                break;
                            case "U":
                                break;
                            case "R":
                                break;
                            case "B":
                                break;
                            case "E":
                                break;
                        }
                    }
                } catch (FileNotFoundException f) {
                    System.out.println("File not found: " + file);
                } catch (IOException e) {
                    System.out.println("Unable to process.\n " + e );
                }

                for (Command c : commandQueue) {
                    c.execute();
                }

                System.out.println(databaseMap.toString());
            }
        }
    }
}
