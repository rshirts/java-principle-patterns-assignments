package com.company;

public class RemoveCommand implements Command {
    RemoveObject removeObject;

    RemoveCommand(RemoveObject removeObject) {
        this.removeObject = removeObject;
    }

    @Override
    public void execute() {
        removeObject.remove();
        //todo: Remove this
        System.out.println("removed an item.");
    }

    @Override
    public void undo() {
        removeObject.add();
    }
}
