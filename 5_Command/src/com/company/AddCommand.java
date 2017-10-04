package com.company;

public class AddCommand implements Command {
    AddRemoveObject addRemoveObject;

    AddCommand(AddRemoveObject addRemoveObject) {
        this.addRemoveObject = addRemoveObject;
    }

    @Override
    public void execute() {
        addRemoveObject.add();
        //todo: remove this
        System.out.println("Added Object.");
    }

    @Override
    public void undo() {
        addRemoveObject.remove();
    }
}
