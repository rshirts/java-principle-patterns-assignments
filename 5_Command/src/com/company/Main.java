package com.company;

import java.io.*;
import java.util.*;

public class Main {

    // Main is the client creates concrete command objects.
    public static void main(String[] args) {

        //Data Structures
        Queue<Command> commandQueue = new ArrayDeque<>();
        Deque<Command> commandStack = new ArrayDeque<>();
        DatabaseMap databaseMap = new DatabaseMap();
        CommandFactory commandFactory = new CommandFactory(databaseMap);

        //File info
        String selection = "";
        Scanner mainScanner = new Scanner(System.in);
        BufferedReader br;
        File file = null;
        String currentLine = "";

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
                        //batch command can return null objects don't add them to the queue
                        Command command = null;
                        command = commandFactory.getCommand(currentLine);
                        if (command != null) {
                            commandQueue.add(command);
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

                databaseMap.printMap();

                Command undoCommand;
                while(!commandStack.isEmpty()) {
                    undoCommand =  commandStack.pop();
                    undoCommand.undo();
                }

                databaseMap.printMap();
            }
        }
    }


}
