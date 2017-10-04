package com.company;

public class RemoveCommand implements Command {
    AddRemoveObject addRemoveObject;

    RemoveCommand(AddRemoveObject addRemoveObject) {
        this.addRemoveObject = addRemoveObject;
    }

    @Override
    public void execute() {
        addRemoveObject.remove();
        //todo: Remove this
        System.out.println("removed an item.");
    }

    @Override
    public void undo() {
        addRemoveObject.add();
    }
}
