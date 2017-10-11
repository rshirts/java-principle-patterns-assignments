package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BatchObject {

    List<Command> batchCommand = new ArrayList<>();


    public BatchObject(List<Command> batchCommand) {
        this.batchCommand = batchCommand;
    }

    public void execute() {
        Iterator<Command> myIterator = batchCommand.listIterator();
        while(myIterator.hasNext()) {
            Command myCommand = myIterator.next();
            myCommand.execute();
        }
    }

    public void undo() {
        Iterator<Command> myIterator = batchCommand.listIterator();
        while(myIterator.hasNext()) {
            Command myCommand = myIterator.next();
            myCommand.undo();
        }
    }
}
