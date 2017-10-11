package com.company;

import java.util.ArrayList;
import java.util.List;

public class CommandFactory {

    DatabaseMap databaseMap;
    List<Command> batchCommand = new ArrayList<>();
    boolean buildBatch = false;
    CommandInfo commandInfo;
    Command returnCommand = null;




    public CommandFactory(DatabaseMap databaseMap) {
        this.databaseMap = databaseMap;
    }

    public Command getCommand(String currentLine) {
        returnCommand = null;

        //parse the line and get the info back.
        commandInfo =  parseLine(currentLine);

        //Create all the command objects.
        if (!buildBatch) {
            switch (commandInfo.command) {
                case "A":
                    returnCommand = new AddCommand(new AddObject(databaseMap, commandInfo));
                    break;
                case "U":
                    returnCommand = new UpdateCommand(new UpdateObject(databaseMap, commandInfo));
                    break;
                case "R":
                    returnCommand = new RemoveCommand(new RemoveObject(databaseMap, commandInfo));
                    break;
                case "B":
                    buildBatch = true;
                    System.out.println("Starting a new Batch.");
                    break;
                case "E":
                    System.out.println("There is no Batch to end.");
                    break;
                default:
                    System.out.println("Unrecognized command found. and skipped.");
                    break;
            }
        }
        else {
            switch (commandInfo.command) {
                case "A":
                    batchCommand.add(new AddCommand(new AddObject(databaseMap, commandInfo)));
                    break;
                case "U":
                    batchCommand.add(new UpdateCommand(new UpdateObject(databaseMap, commandInfo)));
                    break;
                case "R":
                    batchCommand.add(new RemoveCommand(new RemoveObject(databaseMap, commandInfo)));
                    break;
                case "B":
                    buildBatch = true;
                    break;
                case "E":
                    returnCommand = (new BatchCommand(new BatchObject(batchCommand)));
                    batchCommand = null;
                    buildBatch = false;
                    System.out.println("Finished Batch.");
                    break;
                default:
                    System.out.println("Unrecognized command found. and skipped.");
                    break;
            }
        }
        return returnCommand;
    }

    CommandInfo parseLine(String currentLine) {
        String[] splitString;
        String value = "";
        CommandInfo commandInfo = new CommandInfo();
        splitString = currentLine.split("\\s+");

        //Parse the string.
        if (splitString.length >= 1 ) {
            commandInfo.command = splitString[0];
        }

        if (splitString.length >= 2) {
            commandInfo.databaseId = splitString[1];
        }

        if (splitString.length >= 3) {
            commandInfo.key = splitString[2];
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
            commandInfo.value = value;
        }

        return commandInfo;
    }
}
